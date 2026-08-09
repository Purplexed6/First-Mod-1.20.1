package net.mak.oresrise.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class VoltiumSwordItem extends SwordItem {


    public VoltiumSwordItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    // ⚡ CHAIN LIGHTNING
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (!target.level().isClientSide && attacker instanceof Player player) {

            // 50% chance
            if (player.getRandom().nextFloat() <= 0.50f) {


                List<LivingEntity> nearby =
                        target.level().getEntitiesOfClass(
                                LivingEntity.class,
                                target.getBoundingBox().inflate(7.5),
                                entity -> entity != target && entity != player
                        );


                int chains = 0;


                for (LivingEntity enemy : nearby) {

                    if (chains >= 3)
                        break;


                    enemy.hurt(
                            target.damageSources().playerAttack(player),
                            5.0F
                    );


                    createLightningParticles(
                            target.level(),
                            target,
                            enemy
                    );


                    chains++;
                }
            }
        }


        return super.hurtEnemy(stack, target, attacker);
    }



    // ⚡ RIGHT CLICK LIGHTNING
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);


        // cooldown check
        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }


        if (!level.isClientSide) {

            LivingEntity closest = null;
            double closestDistance = Double.MAX_VALUE;


            // Find nearest enemy
            for (LivingEntity entity : level.getEntitiesOfClass(
                    LivingEntity.class,
                    player.getBoundingBox().inflate(15),
                    e -> e != player && e.isAlive()
            )) {


                double distance = player.distanceTo(entity);


                if (distance < closestDistance) {

                    closestDistance = distance;
                    closest = entity;

                }
            }


            if (closest != null) {

                LightningBolt lightning =
                        EntityType.LIGHTNING_BOLT.create(level);


                if (lightning != null) {

                    lightning.moveTo(
                            closest.getX(),
                            closest.getY(),
                            closest.getZ()
                    );


                    level.addFreshEntity(lightning);

                    triggerAdvancement(player);

                    // ⚡ Damage Voltium Sword durability
                    stack.hurtAndBreak(
                            5,
                            player,
                            p -> p.broadcastBreakEvent(hand)
                    );

                    // 2,5 second cooldown
                    player.getCooldowns().addCooldown(this, 50);
                }

            }
        }


        return InteractionResultHolder.success(stack);
    }




    private void createLightningParticles(Level level, LivingEntity from, LivingEntity to) {

        double dx = to.getX() - from.getX();
        double dy = to.getY() + 1 - from.getY();
        double dz = to.getZ() - from.getZ();


        for (int i = 0; i < 20; i++) {

            double x = from.getX() + dx * i / 20;
            double y = from.getY() + 1 + dy * i / 20;
            double z = from.getZ() + dz * i / 20;


            level.addParticle(
                    ParticleTypes.ELECTRIC_SPARK,
                    x,
                    y,
                    z,
                    0,
                    0,
                    0
            );
        }
    }


    private void triggerAdvancement(Player player) {

        if (!(player instanceof ServerPlayer serverPlayer))
            return;


        Advancement advancement = serverPlayer.server.getAdvancements()
                .getAdvancement(
                        new ResourceLocation("oresrise", "voltium_sword")
                );


        if (advancement == null)
            return;


        serverPlayer.getAdvancements()
                .award(
                        advancement,
                        "voltium_sword_strike"
                );
    }

    // appendHoverText stays BELOW it
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(
                Component.translatable("tooltip.oresrise.voltium_sword.tooltip")
        );

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}