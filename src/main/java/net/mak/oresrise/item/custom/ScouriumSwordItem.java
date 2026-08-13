package net.mak.oresrise.item.custom;

import net.mak.oresrise.effect.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ScouriumSwordItem extends SwordItem {

    public ScouriumSwordItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {

            double radius = 5.0D;

            AABB area = player.getBoundingBox().inflate(radius);

            List<LivingEntity> entities =
                    level.getEntitiesOfClass(
                            LivingEntity.class,
                            area
                    );

            // Infect everything inside the 5-block radius
            for (LivingEntity entity : entities) {

                if (entity == player) {
                    continue;
                }

                entity.addEffect(new MobEffectInstance(
                        ModEffects.SCOURIUM_INFECTION.get(),
                        20 * 30,
                        0
                ));
            }

            // ==============================
            // SCOURIA SOUND
            // ==============================

            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.WARDEN_SONIC_BOOM,
                    player.getSoundSource(),
                    0.8F,
                    0.65F
            );

            // ==============================
            // CIRCLE PARTICLES
            // ==============================

            for (int i = 0; i < 64; i++) {

                double angle =
                        (Math.PI * 2.0D * i) / 64.0D;

                double x =
                        player.getX()
                                + Math.cos(angle) * radius;

                double z =
                        player.getZ()
                                + Math.sin(angle) * radius;

                ((ServerLevel) level).sendParticles(
                        ParticleTypes.ENTITY_EFFECT,
                        x,
                        player.getY() + 0.1D,
                        z,
                        1,
                        0.0D,
                        0.0D,
                        0.0D,
                        0.0D
                );
            }

            // Extra particles around the player
            ((ServerLevel) level).sendParticles(
                    ParticleTypes.SMOKE,
                    player.getX(),
                    player.getY() + 1.0D,
                    player.getZ(),
                    20,
                    1.5D,
                    0.5D,
                    1.5D,
                    0.05D
            );

            // 2 second cooldown
            player.getCooldowns().addCooldown(this, 100);
        }

        return InteractionResultHolder.sidedSuccess(
                stack,
                level.isClientSide()
        );
    }
}