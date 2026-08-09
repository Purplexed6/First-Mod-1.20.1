package net.mak.oresrise.event.armor;

import net.mak.oresrise.item.custom.RageiteSet;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

import java.util.List;

@Mod.EventBusSubscriber(
        modid = "oresrise",
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class RageiteArmorEvents {

    private static final String RAGE_TAG = "RageiteRage";

    private static final int MAX_RAGE = 20;

    private static final DustParticleOptions RAGE_PARTICLE =
            new DustParticleOptions(
                    new Vector3f(
                            1.0F,
                            0.05F,
                            0.0F
                    ),
                    1.5F
            );


    // =========================================================
    // PLAYER HITS AN ENEMY
    // =========================================================

    @SubscribeEvent
    public static void onAttack(LivingAttackEvent event) {

        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        if (player.level().isClientSide()) {
            return;
        }

        // Must be wearing the full Rageite set
        if (!isWearingFullRageite(player)) {
            return;
        }

        LivingEntity victim = event.getEntity();

        if (victim == player) {
            return;
        }

        addRage(player, 1);
    }


    // =========================================================
    // PLAYER GETS HIT
    // =========================================================

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {

        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (player.level().isClientSide()) {
            return;
        }

        // Must be wearing the full Rageite set
        if (!isWearingFullRageite(player)) {
            return;
        }

        addRage(player, 1);
    }


    // =========================================================
    // ADD RAGE
    // =========================================================

    private static void addRage(Player player, int amount) {

        int rage = getRage(player);

        rage += amount;

        if (rage > MAX_RAGE) {
            rage = MAX_RAGE;
        }

        player.getPersistentData().putInt(
                RAGE_TAG,
                rage
        );

        if (rage >= MAX_RAGE) {
            unleashRage(player);
        }
    }


    // =========================================================
    // GET RAGE
    // =========================================================

    private static int getRage(Player player) {

        return player.getPersistentData()
                .getInt(RAGE_TAG);
    }


    // =========================================================
    // RESET RAGE
    // =========================================================

    private static void resetRage(Player player) {

        player.getPersistentData().putInt(
                RAGE_TAG,
                0
        );
    }


    // =========================================================
    // RAGE EXPLOSION
    // =========================================================

    private static void unleashRage(Player player) {

        if (!(player.level() instanceof ServerLevel level)) {
            return;
        }

        double x = player.getX();
        double y = player.getY() + 0.5D;
        double z = player.getZ();

        // =====================================================
        // PARTICLES
        // =====================================================

        level.sendParticles(
                RAGE_PARTICLE,
                x,
                y,
                z,
                250,
                3.0D,
                2.0D,
                3.0D,
                0.4D
        );

        level.sendParticles(
                RAGE_PARTICLE,
                x,
                y,
                z,
                100,
                1.0D,
                1.0D,
                1.0D,
                0.8D
        );


        // =====================================================
        // SOUND
        // =====================================================

        level.playSound(
                null,
                player.blockPosition(),
                SoundEvents.GENERIC_EXPLODE,
                SoundSource.PLAYERS,
                1.5F,
                0.8F
        );


        // =====================================================
        // THROW ENEMIES
        // =====================================================

        double radius = 5.0D;

        AABB area = new AABB(
                x - radius,
                y - radius,
                z - radius,
                x + radius,
                y + radius,
                z + radius
        );

        List<LivingEntity> enemies =
                level.getEntitiesOfClass(
                        LivingEntity.class,
                        area,
                        entity ->
                                entity.isAlive()
                                        && entity != player
                                        && entity.distanceTo(player) <= radius
                );


        for (LivingEntity enemy : enemies) {

            double dx = enemy.getX() - x;
            double dz = enemy.getZ() - z;

            double distance =
                    Math.sqrt(
                            dx * dx +
                                    dz * dz
                    );

            if (distance < 0.1D) {
                distance = 0.1D;
            }

            dx /= distance;
            dz /= distance;

            enemy.setDeltaMovement(
                    dx * 2.5D,
                    1.2D,
                    dz * 2.5D
            );

            enemy.hurtMarked = true;
        }


        // =====================================================
        // BUFFS
        // =====================================================

        // Strength I
        player.addEffect(
                new MobEffectInstance(
                        MobEffects.DAMAGE_BOOST,
                        200,
                        0
                )
        );

        // Resistance I
        player.addEffect(
                new MobEffectInstance(
                        MobEffects.DAMAGE_RESISTANCE,
                        200,
                        0
                )
        );

        // Regeneration I
        player.addEffect(
                new MobEffectInstance(
                        MobEffects.REGENERATION,
                        200,
                        0
                )
        );

        // Speed I
        player.addEffect(
                new MobEffectInstance(
                        MobEffects.MOVEMENT_SPEED,
                        200,
                        0
                )
        );


        // =====================================================
        // RESET
        // =====================================================

        resetRage(player);
    }


    // =========================================================
    // RAGE DISPLAY
    // =========================================================

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Player player = event.player;

        if (player.level().isClientSide()) {
            return;
        }

        // Only show Rage while wearing the full set
        if (!isWearingFullRageite(player)) {

            // Also reset Rage if they remove the armor
            if (getRage(player) != 0) {
                resetRage(player);
            }

            return;
        }

        int rage = getRage(player);

        player.displayClientMessage(
                Component.literal(
                        "RAGE: " + rage + "/" + MAX_RAGE
                ).withStyle(ChatFormatting.RED),
                true
        );
    }


    // =========================================================
    // FULL RAGEITE SET CHECK
    // =========================================================

    private static boolean isWearingFullRageite(Player player) {

        ItemStack helmet =
                player.getInventory().getArmor(3);

        ItemStack chestplate =
                player.getInventory().getArmor(2);

        ItemStack leggings =
                player.getInventory().getArmor(1);

        ItemStack boots =
                player.getInventory().getArmor(0);

        return helmet.is(
                RageiteSet.RAGEITE_HELMET.get()
        )
                && chestplate.is(
                RageiteSet.RAGEITE_CHESTPLATE.get()
        )
                && leggings.is(
                RageiteSet.RAGEITE_LEGGINGS.get()
        )
                && boots.is(
                RageiteSet.RAGEITE_BOOTS.get()
        );
    }
}