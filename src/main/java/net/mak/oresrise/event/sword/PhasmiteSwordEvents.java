package net.mak.oresrise.event.sword;

import net.mak.oresrise.item.custom.PhasmiteSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = "oresrise")
public class PhasmiteSwordEvents {

    private static final List<MirrorStrikeTask> TASKS = new ArrayList<>();

    @SubscribeEvent
    public static void onSwordHit(LivingAttackEvent event) {

        // Only players can trigger Mirror Strike
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        // Server only
        if (player.level().isClientSide()) {
            return;
        }

        // Must be holding the Illusion Sword
        ItemStack weapon = player.getMainHandItem();

        if (!weapon.is(PhasmiteSet.PHASMITE_SWORD.get())) {
            return;
        }

        LivingEntity target = event.getEntity();

        if (!target.isAlive()) {
            return;
        }

        ServerLevel level = (ServerLevel) player.level();

        /*
         * Prevent the delayed illusion hits from
         * triggering Mirror Strike again.
         */
        if (event.getSource().getDirectEntity() instanceof MirrorStrikeMarker) {
            return;
        }

        /*
         * First illusion hit: 5 ticks later
         */
        TASKS.add(
                new MirrorStrikeTask(
                        level,
                        player,
                        target,
                        5
                )
        );

        /*
         * Second illusion hit: 10 ticks later
         */
        TASKS.add(
                new MirrorStrikeTask(
                        level,
                        player,
                        target,
                        10
                )
        );
    }

    @SubscribeEvent
    public static void onServerTick(net.minecraftforge.event.TickEvent.ServerTickEvent event) {

        if (event.phase != net.minecraftforge.event.TickEvent.Phase.END) {
            return;
        }

        for (int i = TASKS.size() - 1; i >= 0; i--) {

            MirrorStrikeTask task = TASKS.get(i);

            task.ticks--;

            if (task.ticks <= 0) {

                if (task.target.isAlive()) {

                    /*
                     * Deal the same basic attack damage.
                     *
                     * 0.0F here means the delayed hit
                     * uses the player's normal attack damage.
                     */
                    task.target.hurt(
                            task.player.damageSources()
                                    .playerAttack(task.player),
                            task.player.getAttackStrengthScale(0.5F)
                                    * (float) task.player.getAttributeValue(
                                    net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE
                            )
                    );

                    /*
                     * Critical-hit particles
                     */
                    task.level.sendParticles(
                            net.minecraft.core.particles.ParticleTypes.CRIT,
                            task.target.getX(),
                            task.target.getY() + task.target.getBbHeight() * 0.5,
                            task.target.getZ(),
                            8,
                            0.3,
                            0.3,
                            0.3,
                            0.1
                    );

                    /*
                     * Sword-hit sound
                     */
                    task.level.playSound(
                            null,
                            task.target.blockPosition(),
                            net.minecraft.sounds.SoundEvents.PLAYER_ATTACK_STRONG,
                            net.minecraft.sounds.SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                    );
                }

                TASKS.remove(i);
            }
        }
    }

    private static class MirrorStrikeTask {

        ServerLevel level;
        Player player;
        LivingEntity target;
        int ticks;

        MirrorStrikeTask(
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

    /*
     * Empty marker class used only to identify
     * delayed Mirror Strike damage.
     */
    private static class MirrorStrikeMarker extends net.minecraft.world.entity.Entity {

        protected MirrorStrikeMarker(
                net.minecraft.world.entity.EntityType<?> type,
                Level level
        ) {
            super(type, level);
        }

        @Override
        protected void defineSynchedData() {
        }

        @Override
        protected void readAdditionalSaveData(
                net.minecraft.nbt.CompoundTag tag
        ) {
        }

        @Override
        protected void addAdditionalSaveData(
                net.minecraft.nbt.CompoundTag tag
        ) {
        }
    }
}