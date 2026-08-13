package net.mak.oresrise.event.sword;

import net.mak.oresrise.item.custom.RageiteSet;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = "oresrise")
public class RageiteSwordEvents {

    private static final List<ExplosionTask> TASKS = new ArrayList<>();

    private static final double RADIUS = 6.0D;

    private static final float EXPLOSION_POWER = 2.5F;

    private static final int COOLDOWN = 20 * 8;


    // =========================================================
    // RMB ACTIVATION
    // =========================================================

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {

        Player player = event.getEntity();

        if (player.level().isClientSide()) {
            return;
        }

        // Main hand only
        if (!event.getHand().equals(net.minecraft.world.InteractionHand.MAIN_HAND)) {
            return;
        }

        ItemStack stack = player.getMainHandItem();

        // Must be Rageite Sword
        if (!stack.is(RageiteSet.RAGEITE_SWORD.get())) {
            return;
        }

        // Cooldown
        if (player.getCooldowns().isOnCooldown(stack.getItem())) {
            return;
        }

        if (!(player.level() instanceof ServerLevel level)) {
            return;
        }


        // =====================================================
        // FIND ENEMIES
        // =====================================================

        AABB area = player.getBoundingBox().inflate(RADIUS);

        List<LivingEntity> enemies =
                level.getEntitiesOfClass(
                        LivingEntity.class,
                        area,
                        entity ->
                                entity.isAlive()
                                        && entity != player
                                        && entity.distanceTo(player) <= RADIUS
                );


        if (enemies.isEmpty()) {
            return;
        }


        // =====================================================
        // CREATE EXPLOSION CHAIN
        // =====================================================

        int delay = 1;

        for (LivingEntity enemy : enemies) {

            addExplosion(
                    level,
                    player,
                    enemy,
                    delay
            );

            // One tick between explosions
            delay++;
        }


        // =====================================================
        // USE 1 DURABILITY
        // =====================================================

        stack.hurtAndBreak(
                1,
                player,
                p -> p.broadcastBreakEvent(
                        net.minecraft.world.entity.EquipmentSlot.MAINHAND
                )
        );


        // =====================================================
        // COOLDOWN
        // =====================================================

        player.getCooldowns().addCooldown(
                stack.getItem(),
                COOLDOWN
        );

        event.setCanceled(true);
    }


    // =========================================================
    // ADD EXPLOSION TASK
    // =========================================================

    public static void addExplosion(
            ServerLevel level,
            Player player,
            LivingEntity target,
            int delay
    ) {

        TASKS.add(
                new ExplosionTask(
                        level,
                        player,
                        target,
                        delay
                )
        );
    }


    // =========================================================
    // SERVER TICK
    // =========================================================

    @SubscribeEvent
    public static void onServerTick(
            TickEvent.ServerTickEvent event
    ) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }


        for (int i = TASKS.size() - 1; i >= 0; i--) {

            ExplosionTask task = TASKS.get(i);

            task.ticks--;


            if (task.ticks <= 0) {

                if (task.target.isAlive()) {

                    double x = task.target.getX();
                    double y = task.target.getY();
                    double z = task.target.getZ();


                    // =================================================
                    // EXPLOSION — PLAYER IS IMMUNE
                    // =================================================

                    boolean wasInvulnerable = task.player.isInvulnerable();

                    task.player.setInvulnerable(true);

                    task.level.explode(
                            null,
                            x,
                            y,
                            z,
                            EXPLOSION_POWER,
                            Level.ExplosionInteraction.NONE
                    );

                    task.player.setInvulnerable(wasInvulnerable);


                    // =================================================
                    // EXTRA RAGE PARTICLES
                    // =================================================

                    task.level.sendParticles(
                            ParticleTypes.FLAME,
                            x,
                            y + 0.5D,
                            z,
                            25,
                            0.5D,
                            0.5D,
                            0.5D,
                            0.15D
                    );

                    task.level.sendParticles(
                            ParticleTypes.SMOKE,
                            x,
                            y + 0.5D,
                            z,
                            15,
                            0.5D,
                            0.5D,
                            0.5D,
                            0.1D
                    );


                    // =================================================
                    // SOUND
                    // =================================================

                    task.level.playSound(
                            null,
                            task.target.blockPosition(),
                            SoundEvents.GENERIC_EXPLODE,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                    );
                }


                TASKS.remove(i);
            }
        }
    }

    private static void triggerAdvancement(Player player) {

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        Advancement advancement =
                serverPlayer.server.getAdvancements().getAdvancement(
                        new ResourceLocation("oresrise", "rageite_sword")
                );

        if (advancement == null) {
            return;
        }

        serverPlayer.getAdvancements().award(
                advancement,
                "rage_blast"
        );
    }

    // =========================================================
    // TASK
    // =========================================================

    private static class ExplosionTask {

        ServerLevel level;

        Player player;

        LivingEntity target;

        int ticks;


        ExplosionTask(
                ServerLevel level,
                Player player,
                LivingEntity target,
                int ticks
        ) {

            this.level = level;

            this.player = player;

            this.target = target;

            this.ticks = ticks;
        }
    }
}