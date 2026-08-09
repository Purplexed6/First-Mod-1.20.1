package net.mak.oresrise.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class HydrogemSwordItem extends SwordItem {


    public HydrogemSwordItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);


        // Nether water rejection
        if (level.dimension() == Level.NETHER) {

            level.playSound(
                    null,
                    player.blockPosition(),
                    SoundEvents.FIRE_EXTINGUISH,
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );


            if (!level.isClientSide) {

                ((ServerLevel) level).sendParticles(
                        ParticleTypes.SMOKE,
                        player.getX(),
                        player.getY() + 1,
                        player.getZ(),
                        5,
                        0.2,
                        0.2,
                        0.2,
                        0.01
                );
            }


            return InteractionResultHolder.success(stack);
        }



        // cooldown check
        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }



        if (!level.isClientSide) {

            createTidalWave(level, player);


            // durability cost
            stack.hurtAndBreak(
                    5,
                    player,
                    p -> p.broadcastBreakEvent(hand)
            );


            level.playSound(
                    null,
                    player.blockPosition(),
                    SoundEvents.PLAYER_SPLASH,
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        }



        // 2.5 second cooldown
        player.getCooldowns().addCooldown(this, 50);


        return InteractionResultHolder.success(stack);
    }



    private void createTidalWave(Level level, Player player) {


        double radius = 2.0;


        // water particles
        for (int i = 0; i < 60; i++) {

            double angle = (Math.PI * 2) * i / 60;

            double x = player.getX() + Math.cos(angle) * radius;
            double z = player.getZ() + Math.sin(angle) * radius;


            ((ServerLevel) level).sendParticles(
                    ParticleTypes.SPLASH,
                    x,
                    player.getY() + 0.2,
                    z,
                    3,
                    0.1,
                    0.1,
                    0.1,
                    0.05
            );


            ((ServerLevel) level).sendParticles(
                    ParticleTypes.BUBBLE,
                    x,
                    player.getY() + 0.5,
                    z,
                    2,
                    0.1,
                    0.1,
                    0.1,
                    0.02
            );
        }



        // find enemies
        List<LivingEntity> enemies =
                level.getEntitiesOfClass(
                        LivingEntity.class,
                        player.getBoundingBox().inflate(8),
                        entity -> entity != player && entity.isAlive()
                );



        for (LivingEntity enemy : enemies) {


            enemy.hurt(
                    player.damageSources().playerAttack(player),
                    5.0F
            );


            // push away from player
            double dx = enemy.getX() - player.getX();
            double dz = enemy.getZ() - player.getZ();


            enemy.knockback(
                    2.0F,
                    -dx,
                    -dz
            );
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(
                Component.translatable("tooltip.oresrise.hydrogem_sword.tooltip")
        );

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}