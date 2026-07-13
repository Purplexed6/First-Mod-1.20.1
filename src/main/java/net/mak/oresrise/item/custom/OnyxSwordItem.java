package net.mak.oresrise.item.custom;

import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.List;

public class OnyxSwordItem extends SwordItem {

    public OnyxSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player player) {

            // direction target is facing
            var look = target.getLookAngle().normalize();

            // direction from target → attacker
            double dx = attacker.getX() - target.getX();
            double dz = attacker.getZ() - target.getZ();

            double length = Math.sqrt(dx * dx + dz * dz);

            if (length > 0.0001) {

                dx /= length;
                dz /= length;

                // dot product = how aligned the directions are
                double dot = dx * look.x + dz * look.z;

                //  BACKSTAB CHECK
                // -1 = directly behind
                // 1 = directly in front
                if (dot < -0.5) {

                    target.hurt(
                            player.damageSources().playerAttack(player),
                            4.0f
                    );

                    target.addEffect(new MobEffectInstance(
                            MobEffects.BLINDNESS,
                            40,
                            0,
                            false,
                            false
                    ));

                    //  SCREEN SHAKE ONLY ON BACKSTAB
                    if (!player.level().isClientSide) {
                        ModNetwork.CHANNEL.send(
                                PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player),
                                new ShakePacket(3.0f, 12) // tweak strength + duration here
                        );
                    }

                    if (!player.level().isClientSide) {
                        ((ServerLevel) player.level()).sendParticles(
                                ParticleTypes.SMOKE,
                                target.getX(),
                                target.getY() + 1,
                                target.getZ(),
                                15,
                                0.2, 0.3, 0.2,
                                0.02
                        );
                    }
                }
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.oresrise.onyx_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
