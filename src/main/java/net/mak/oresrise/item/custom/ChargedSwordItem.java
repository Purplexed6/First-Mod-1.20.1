package net.mak.oresrise.item.custom;

import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.List;

public class ChargedSwordItem extends SwordItem {

    public ChargedSwordItem(Tier tier, int damage, float speed, Properties props) {
        super(tier, damage, speed, props);
    }

    //  start
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    // duration
    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    // release
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {

        if (!(entity instanceof Player player)) return;
        if (level.isClientSide) return;

        int chargeTime = this.getUseDuration(stack) - timeLeft;

        // normalize charge (0 → 1)
        float power = chargeTime / 20f;
        power = Math.min(power, 5.0f);

// screen shake
        if (power > 2.0f) {
            ModNetwork.CHANNEL.send(
                    PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player),
                    new ShakePacket(1.0f + power, (int)(10 + power * 10))
            );
        }

        doAOEExplosion(level, player, power);

        player.getCooldowns().addCooldown(this, 100); // 5 seconds (20 ticks = 1 sec)
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int count) {

        if (level.isClientSide) return;

        if (entity instanceof Player player) {

            player.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    10, // short duration, constantly refreshed
                    1,
                    false,
                    false
            ));

            ((ServerLevel) level).sendParticles(
                    ParticleTypes.SMOKE,
                    player.getX(),
                    player.getY() + 1,
                    player.getZ(),
                    2,
                    0.1, 0.1, 0.1,
                    0.01
            );
        }

        int chargeTime = this.getUseDuration(stack) - count;
        float power = chargeTime / 20f;

        ((ServerLevel) level).sendParticles(
                ParticleTypes.END_ROD,
                entity.getX(),
                entity.getY() + 1,
                entity.getZ(),
                (int)(2 + power), // more particles as charge increases
                0.2, 0.3, 0.2,
                0.01
        );
    }

    //explosion
    private void doAOEExplosion(Level level, Player player, float power) {

        double radius = 2.5 + power; // bigger with charge

        for (var entity : level.getEntities(player, player.getBoundingBox().inflate(radius))) {

            if (entity instanceof LivingEntity target && target != player) {

                target.hurt(
                        player.damageSources().playerAttack(player),
                        2.0f + (2.0f * power)
                );
            }
        }

        ((ServerLevel) level).sendParticles(
                ParticleTypes.EXPLOSION,
                player.getX(),
                player.getY() + 1,
                player.getZ(),
                10,
                0.5, 0.5, 0.5,
                0.1
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.oresrise.colossite_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}