package net.mak.oresrise.item.custom;

import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.mak.oresrise.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.PacketDistributor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WitheriteSwordItem extends SwordItem {

    // 70 ticks = 3.5 seconds
    private static final int COMBO_TIMEOUT = 70;

    // Impact happens on the 5th hit
    private static final int MAX_COMBO = 5;

    // Player UUID -> combo data
    private static final Map<UUID, ComboData> COMBOS = new HashMap<>();


    public WitheriteSwordItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    // =========================================================
    // HIT
    // =========================================================

    @Override
    public boolean hurtEnemy(
            ItemStack stack,
            LivingEntity target,
            LivingEntity attacker
    ) {

        // Only players can build the combo
        if (!(attacker instanceof Player player)) {
            return super.hurtEnemy(stack, target, attacker);
        }

        Level level = target.level();


        // =====================================================
        // SERVER SIDE
        // =====================================================

        if (!level.isClientSide) {

            ServerLevel serverLevel = (ServerLevel) level;

            UUID playerUUID = player.getUUID();

            ComboData combo =
                    COMBOS.get(playerUUID);


            // =================================================
            // GET / RESET COMBO
            // =================================================

            if (combo == null) {

                combo = new ComboData();

                COMBOS.put(
                        playerUUID,
                        combo
                );

            } else {

                /*
                 * If more than 70 ticks passed since
                 * the previous hit, reset the combo.
                 */

                if (
                        serverLevel.getGameTime()
                                - combo.lastHit
                                > COMBO_TIMEOUT
                ) {

                    combo.hits = 0;

                    System.out.println(
                            "WITHERITE COMBO RESET"
                    );
                }
            }


            // =================================================
            // INCREASE COMBO
            // =================================================

            combo.hits = Math.min(
                    combo.hits + 1,
                    MAX_COMBO
            );

            combo.lastHit =
                    serverLevel.getGameTime();


            System.out.println(
                    "WITHERITE COMBO: "
                            + combo.hits
            );


            // =================================================
            // IMPACT
            // =================================================

            if (combo.hits >= MAX_COMBO) {

                System.out.println(
                        "WITHERITE IMPACT TRIGGERED"
                );


                // -------------------------------------------------
                // Sound
                // -------------------------------------------------

                serverLevel.playSound(
                        null,
                        target.getX(),
                        target.getY(),
                        target.getZ(),
                        ModSounds.WITHERITE_IMPACT.get(),
                        SoundSource.PLAYERS,
                        0.8F,
                        1.0F
                );


                // -------------------------------------------------
                // Firework particles
                // -------------------------------------------------

                serverLevel.sendParticles(
                        ParticleTypes.FIREWORK,
                        target.getX(),
                        target.getY() + 1.0D,
                        target.getZ(),
                        60,
                        2.0D,
                        2.0D,
                        2.0D,
                        0.2D
                );


                // -------------------------------------------------
                // Extra impact damage
                // -------------------------------------------------

                target.hurt(
                        player.damageSources().playerAttack(player),
                        6.0F
                );


                // -------------------------------------------------
                // Knockback
                // -------------------------------------------------

                target.knockback(
                        2.0D,
                        player.getX() - target.getX(),
                        player.getZ() - target.getZ()
                );


                // -------------------------------------------------
                // Screen shake
                // -------------------------------------------------

                ModNetwork.CHANNEL.send(
                        PacketDistributor.TRACKING_ENTITY_AND_SELF
                                .with(() -> target),
                        new ShakePacket(
                                1.5F,
                                15
                        )
                );


                // -------------------------------------------------
                // Reset combo after impact
                // -------------------------------------------------

                COMBOS.remove(playerUUID);

            }
        }


        // Normal sword damage
        return super.hurtEnemy(
                stack,
                target,
                attacker
        );
    }


    // =========================================================
    // RIGHT CLICK
    // =========================================================

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {

        ItemStack stack =
                player.getItemInHand(hand);


        // Cooldown
        if (player.getCooldowns().isOnCooldown(this)) {

            return InteractionResultHolder.fail(
                    stack
            );
        }


        if (!level.isClientSide) {

            double radius = 5.0D;


            // Find nearby living enemies
            var enemies =
                    level.getEntitiesOfClass(
                            LivingEntity.class,
                            player.getBoundingBox().inflate(radius),
                            entity ->
                                    entity != player
                                            && entity.isAlive()
                                            && entity.distanceTo(player)
                                            <= radius
                    );


            // Apply Slowness II
            for (LivingEntity enemy : enemies) {

                enemy.addEffect(
                        new net.minecraft.world.effect.MobEffectInstance(
                                net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN,
                                60,
                                1,
                                false,
                                false
                        )
                );
            }


            // 5 second cooldown
            player.getCooldowns().addCooldown(
                    this,
                    20 * 5
            );
        }


        return InteractionResultHolder.success(
                stack
        );
    }


    // =========================================================
    // COMBO DATA
    // =========================================================

    private static class ComboData {

        int hits = 0;

        long lastHit = 0;
    }
}