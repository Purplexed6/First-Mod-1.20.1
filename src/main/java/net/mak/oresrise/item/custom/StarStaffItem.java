package net.mak.oresrise.item.custom;

import net.mak.oresrise.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class StarStaffItem extends Item {

    public StarStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide) {

            // 🔊 sound
            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    ModSounds.CHARM.get(),
                    SoundSource.PLAYERS,
                    0.8f,
                    1.0f
            );
            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    ModSounds.TITAN.get(),
                    SoundSource.PLAYERS,
                    0.5f,
                    1.0f
            );

            double range = 20.0;

            var look = player.getLookAngle();

            for (double i = 0; i < range; i += 0.3) {

                double x = player.getX() + look.x * i;
                double y = player.getEyeY() + look.y * i;
                double z = player.getZ() + look.z * i;

                //  beam particles
                ((ServerLevel) level).sendParticles(
                        ParticleTypes.END_ROD,
                        x, y, z,
                        2,
                        0, 0, 0,
                        0
                );

                //  hit detection
                for (var entity : level.getEntities(player,
                        player.getBoundingBox().inflate(20))) {

                    if (entity instanceof LivingEntity target && target != player) {

                        double dist = target.distanceToSqr(x, y, z);

                        if (dist < 2.5) {

                            target.hurt(
                                    target.damageSources().magic(),
                                    4.0f // damage (2 hearts)
                            );

                            target.addEffect(new MobEffectInstance(
                                    MobEffects.GLOWING,
                                    60,
                                    0,
                                    false,
                                    false,
                                    false
                            ));
                        }
                    }
                }
            }

            ((ServerLevel) level).sendParticles(
                    ParticleTypes.FIREWORK,
                    player.getX() + look.x * range,
                    player.getEyeY() + look.y * range,
                    player.getZ() + look.z * range,
                    50,
                    1.0, 1.0, 1.0,
                    0.1
            );

            // cooldown
            player.getCooldowns().addCooldown(this, 30);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.oresrise.star_staff.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}