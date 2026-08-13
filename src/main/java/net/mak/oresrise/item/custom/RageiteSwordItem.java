package net.mak.oresrise.item.custom;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.*;

public class RageiteSwordItem extends SwordItem {

    // How long before a combo resets
    private static final int COMBO_TIMEOUT = 70;

    // Maximum combo bonus = +50%
    private static final int MAX_COMBO = 5;

    /*
     * Each enemy has its own combo.
     *
     * Enemy UUID -> ComboData
     */
    private static final Map<UUID, ComboData> COMBOS = new HashMap<>();


    public RageiteSwordItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public boolean hurtEnemy(
            ItemStack stack,
            LivingEntity target,
            LivingEntity attacker
    ) {

        if (!(attacker instanceof Player player)) {
            return super.hurtEnemy(stack, target, attacker);
        }

        Level level = target.level();


        // =====================================================
        // SERVER SIDE
        // =====================================================

        if (!level.isClientSide) {

            ServerLevel serverLevel = (ServerLevel) level;

            UUID targetUUID = target.getUUID();

            ComboData combo =
                    COMBOS.get(targetUUID);


            // =================================================
            // GET / RESET COMBO
            // =================================================

            if (combo == null) {

                combo = new ComboData();
                COMBOS.put(targetUUID, combo);

            } else {

                /*
                 * If more than 70 ticks passed since the
                 * previous hit, reset the combo.
                 */

                if (serverLevel.getGameTime() - combo.lastHit > COMBO_TIMEOUT) {

                    combo.hits = 0;
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


            // =================================================
            // EXECUTION
            // =================================================

            /*
             * Check the target's health BEFORE applying
             * this hit's damage.
             *
             * 15% of max health.
             */

            float healthPercent =
                    target.getHealth()
                            / target.getMaxHealth();


            if (healthPercent < 0.15F) {

                // Instantly kill the enemy
                target.hurt(
                        player.damageSources().playerAttack(player),
                        Float.MAX_VALUE
                );


                /*
                 * BIG FIRE PARTICLE EXPLOSION
                 */

                serverLevel.sendParticles(
                        ParticleTypes.FLAME,
                        target.getX(),
                        target.getY() + target.getBbHeight() * 0.5D,
                        target.getZ(),
                        80,
                        0.6D,
                        0.6D,
                        0.6D,
                        0.08D
                );


                serverLevel.sendParticles(
                        ParticleTypes.SMALL_FLAME,
                        target.getX(),
                        target.getY() + target.getBbHeight() * 0.5D,
                        target.getZ(),
                        40,
                        0.4D,
                        0.4D,
                        0.4D,
                        0.05D
                );


                // Reset this enemy's combo
                COMBOS.remove(targetUUID);

            } else {

                /*
                 * The normal sword hit is handled by
                 * super.hurtEnemy().
                 *
                 * The combo damage multiplier is applied
                 * separately below.
                 */

                float bonusMultiplier =
                        1.0F + (combo.hits * 0.10F);


                /*
                 * combo.hits:
                 *
                 * 1 hit = +10%
                 * 2 hits = +20%
                 * 3 hits = +30%
                 * 4 hits = +40%
                 * 5 hits = +50%
                 */

                float baseDamage =
                        (float) player.getAttributeValue(
                                net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE
                        );


                float bonusDamage =
                        baseDamage * (bonusMultiplier - 1.0F);


                /*
                 * Deal the extra combo damage.
                 *
                 * super.hurtEnemy() below handles the
                 * normal sword damage.
                 */

                if (bonusDamage > 0.0F) {

                    target.hurt(
                            player.damageSources().playerAttack(player),
                            bonusDamage
                    );
                }
            }
        }


        return super.hurtEnemy(
                stack,
                target,
                attacker
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }

        if (!level.isClientSide) {

            double radius = 5.0D;

            List<LivingEntity> enemies =
                    level.getEntitiesOfClass(
                            LivingEntity.class,
                            player.getBoundingBox().inflate(radius),
                            entity ->
                                    entity != player
                                            && entity.isAlive()
                                            && entity.distanceTo(player) <= radius
                    );

            for (LivingEntity enemy : enemies) {

                // Wither II for 3 seconds
                enemy.addEffect(
                        new MobEffectInstance(
                                MobEffects.MOVEMENT_SLOWDOWN,
                                60,
                                1,
                                false,
                                false
                        )
                );
            }

            // 5 second cooldown
            player.getCooldowns().addCooldown(this, 20 * 5);
        }

        return InteractionResultHolder.success(stack);
    }

    // =========================================================
    // COMBO DATA
    // =========================================================

    private static class ComboData {

        int hits = 0;

        long lastHit = 0;
    }
}