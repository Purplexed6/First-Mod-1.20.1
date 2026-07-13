package net.mak.oresrise.item.custom;

import net.mak.oresrise.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ShadowDaggerItem extends SwordItem {

    public ShadowDaggerItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide) {

            // smoke at start
            ((ServerLevel) level).sendParticles(
                    net.minecraft.core.particles.ParticleTypes.SMOKE,
                    player.getX(), player.getY() + 1, player.getZ(),
                    50,
                    0.3, 0.5, 0.3,
                    0.01
            );

            double startX = player.getX();
            double startY = player.getY();
            double startZ = player.getZ();

            // dash forward
            var hit = player.pick(5.0, 0.0f, false);

            double newX = hit.getLocation().x;
            double newY = hit.getLocation().y;
            double newZ = hit.getLocation().z;

            // teleport
            player.teleportTo(newX, newY + 0.1, newZ);

            if (!player.isCrouching()) {

                player.level().playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        ModSounds.TELEPORT.get(),
                        net.minecraft.sounds.SoundSource.PLAYERS,
                        0.8f,
                        1.0f
                );
            }

            // smoke at destination
            ((ServerLevel) level).sendParticles(
                    net.minecraft.core.particles.ParticleTypes.SMOKE,
                    newX, newY + 1, newZ,
                    20,
                    0.3, 0.5, 0.3,
                    0.01
            );

            // SLICE THROUGH DAMAGE
            for (var entity : level.getEntities(player, player.getBoundingBox().inflate(6.0))) {

                if (entity instanceof net.minecraft.world.entity.LivingEntity target && target != player) {

                    double dashDX = newX - startX;
                    double dashDZ = newZ - startZ;

                    double toTargetX = target.getX() - startX;
                    double toTargetZ = target.getZ() - startZ;

                    double dot = (toTargetX * dashDX + toTargetZ * dashDZ);
                    double dashLengthSq = dashDX * dashDX + dashDZ * dashDZ;

                    double t = dot / dashLengthSq;

                    if (t >= 0 && t <= 1) {

                        double projX = startX + dashDX * t;
                        double projZ = startZ + dashDZ * t;

                        double distToLine = Math.sqrt(
                                Math.pow(target.getX() - projX, 2) +
                                        Math.pow(target.getZ() - projZ, 2)
                        );

                        if (distToLine < 1.5) {

                            target.hurt(
                                    target.damageSources().magic(),
                                    2.0f
                            );

                            ((ServerLevel) level).sendParticles(
                                    net.minecraft.core.particles.ParticleTypes.CRIT,
                                    target.getX(), target.getY() + 1, target.getZ(),
                                    10,
                                    0.2, 0.3, 0.2,
                                    0.01
                            );
                        }
                    }
                }
            }

            // cooldown
            player.getCooldowns().addCooldown(this, 60);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.oresrise.shadow_dagger.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}