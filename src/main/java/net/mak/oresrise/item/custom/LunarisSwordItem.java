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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class LunarisSwordItem extends SwordItem {


    public LunarisSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }



    // LUNARIS AERIAL SLAM
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);


        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }



        if (!level.isClientSide) {

            launchEnemies(level, player);


            level.playSound(
                    null,
                    player.blockPosition(),
                    SoundEvents.ENDERMAN_TELEPORT,
                    SoundSource.PLAYERS,
                    1.0F,
                    0.8F
            );


            player.getCooldowns().addCooldown(this, 60);
        }


        return InteractionResultHolder.success(stack);
    }




    private void launchEnemies(Level level, Player player) {


        double radius = 6.0;



        // lunar particles
        if (level instanceof ServerLevel server) {


            for (int i = 0; i < 100; i++) {


                double angle = Math.random() * Math.PI * 2;
                double distance = Math.random() * radius;


                double x = player.getX() + Math.cos(angle) * distance;
                double z = player.getZ() + Math.sin(angle) * distance;



                server.sendParticles(
                        ParticleTypes.END_ROD,
                        x,
                        player.getY() + 0.2,
                        z,
                        2,
                        0.1,
                        0.2,
                        0.1,
                        0.02
                );


                server.sendParticles(
                        ParticleTypes.GLOW,
                        x,
                        player.getY() + 0.5,
                        z,
                        1,
                        0,
                        0.1,
                        0,
                        0.02
                );
            }
        }




        List<LivingEntity> enemies =
                level.getEntitiesOfClass(
                        LivingEntity.class,
                        player.getBoundingBox().inflate(radius),
                        entity -> entity != player && entity.isAlive()
                );



        for (LivingEntity enemy : enemies) {


            // launch into the sky
            enemy.setDeltaMovement(
                    enemy.getDeltaMovement().x,
                    2.0,
                    enemy.getDeltaMovement().z
            );


            enemy.hurtMarked = true;
        }
    }




    @Override
    public void appendHoverText(ItemStack pStack,
                                @Nullable Level pLevel,
                                List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(
                Component.translatable("tooltip.oresrise.lunaris_sword.tooltip")
        );

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (!attacker.level().isClientSide) {

            // smaller upward fling on normal hit
            target.setDeltaMovement(
                    target.getDeltaMovement().x,
                    target.getDeltaMovement().y + 1,
                    target.getDeltaMovement().z
            );

            target.hurtMarked = true;


            // small lunar particles
            if (attacker.level() instanceof ServerLevel server) {

                server.sendParticles(
                        ParticleTypes.END_ROD,
                        target.getX(),
                        target.getY() + 1,
                        target.getZ(),
                        8,
                        0.2,
                        0.3,
                        0.2,
                        0.02
                );
            }
        }


        return super.hurtEnemy(stack, target, attacker);
    }
}
