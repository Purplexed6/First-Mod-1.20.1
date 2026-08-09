package net.mak.oresrise.event.armor;

import net.mak.oresrise.item.custom.PhasmiteSet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = "oresrise")
public class PhasmiteArmorEvents {

    // 60 ticks = 3 seconds
    private static final int HISTORY_LENGTH = 60;

    private static final Map<UUID, Deque<Position>> HISTORY = new HashMap<>();

    // Cooldown after activating Phantom Rewind
    private static final int COOLDOWN_TICKS = 40;

    private static final Map<UUID, Integer> COOLDOWNS = new HashMap<>();


    /*
     * Record the player's position every tick.
     */
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Player player = event.player;

        // Server only
        if (player.level().isClientSide()) {
            return;
        }

        UUID uuid = player.getUUID();

        /*
         * Decrease cooldown.
         */
        if (COOLDOWNS.containsKey(uuid)) {

            int cooldown = COOLDOWNS.get(uuid);

            if (cooldown > 0) {
                COOLDOWNS.put(uuid, cooldown - 1);
            } else {
                COOLDOWNS.remove(uuid);
            }
        }

        /*
         * Get / create position history.
         */
        Deque<Position> positions =
                HISTORY.computeIfAbsent(
                        uuid,
                        ignored -> new ArrayDeque<>()
                );

        /*
         * Store current position.
         */
        positions.addLast(
                new Position(
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        player.getYRot(),
                        player.getXRot()
                )
        );

        /*
         * Keep only the last 60 ticks.
         */
        while (positions.size() > HISTORY_LENGTH) {
            positions.removeFirst();
        }
    }


    /*
     * Detect when the player gets attacked.
     */
    @SubscribeEvent
    public static void onPlayerHit(LivingAttackEvent event) {

        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        // Server only
        if (player.level().isClientSide()) {
            return;
        }

        /*
         * Must be wearing the COMPLETE Phasmite set.
         */
        if (!isFullPhasmiteSet(player)) {
            return;
        }

        UUID uuid = player.getUUID();

        /*
         * Don't activate while on cooldown.
         */
        if (COOLDOWNS.containsKey(uuid)) {
            return;
        }

        /*
         * 25% chance.
         */
        if (player.getRandom().nextFloat() > 0.25F) {
            return;
        }

        /*
         * Need a full 3 seconds of history.
         */
        Deque<Position> positions = HISTORY.get(uuid);

        if (positions == null || positions.size() < HISTORY_LENGTH) {
            return;
        }

        /*
         * Get the position from 3 seconds ago.
         */
        Position oldPosition = positions.peekFirst();

        if (oldPosition == null) {
            return;
        }

        /*
         * Teleport the player back.
         */
        player.teleportTo(
                oldPosition.x,
                oldPosition.y,
                oldPosition.z
        );

        player.setYRot(oldPosition.yRot);
        player.setXRot(oldPosition.xRot);

        /*
         * Start cooldown.
         */
        COOLDOWNS.put(uuid, COOLDOWN_TICKS);

        /*
         * Attacker gets Weakness II + Slowness II.
         */
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {

            attacker.addEffect(
                    new MobEffectInstance(
                            MobEffects.WEAKNESS,
                            100, // 5 seconds
                            1     // Level II
                    )
            );

            attacker.addEffect(
                    new MobEffectInstance(
                            MobEffects.MOVEMENT_SLOWDOWN,
                            100, // 5 seconds
                            1     // Level II
                    )
            );
        }

        /*
         * Phasmite particles.
         */
        if (player.level() instanceof net.minecraft.server.level.ServerLevel serverLevel) {

            serverLevel.sendParticles(
                    ParticleTypes.PORTAL,
                    player.getX(),
                    player.getY() + 1.0,
                    player.getZ(),
                    40,
                    0.5,
                    0.8,
                    0.5,
                    0.2
            );

            serverLevel.sendParticles(
                    ParticleTypes.ENCHANT,
                    player.getX(),
                    player.getY() + 1.0,
                    player.getZ(),
                    30,
                    0.5,
                    0.8,
                    0.5,
                    0.2
            );
        }

        /*
         * Teleport sound.
         */
        player.level().playSound(
                null,
                player.blockPosition(),
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.PLAYERS,
                1.0F,
                1.2F
        );
    }


    /*
     * Checks whether the player is wearing
     * all four Phasmite armor pieces.
     */
    private static boolean isFullPhasmiteSet(Player player) {

        ItemStack helmet = player.getInventory().getArmor(3);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack boots = player.getInventory().getArmor(0);

        return helmet.is(PhasmiteSet.PHASMITE_HELMET.get())
                && chestplate.is(PhasmiteSet.PHASMITE_CHESTPLATE.get())
                && leggings.is(PhasmiteSet.PHASMITE_LEGGINGS.get())
                && boots.is(PhasmiteSet.PHASMITE_BOOTS.get());
    }


    /*
     * Stores a player's previous position.
     */
    private static class Position {

        double x;
        double y;
        double z;

        float yRot;
        float xRot;

        Position(
                double x,
                double y,
                double z,
                float yRot,
                float xRot
        ) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.yRot = yRot;
            this.xRot = xRot;
        }
    }
}