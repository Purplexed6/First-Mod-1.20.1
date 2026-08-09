package net.mak.oresrise.item.custom;

import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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



    // BACKSTAB
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player player) {

            var look = target.getLookAngle().normalize();


            double dx = attacker.getX() - target.getX();
            double dz = attacker.getZ() - target.getZ();


            double length = Math.sqrt(dx * dx + dz * dz);


            if (length > 0.0001) {

                dx /= length;
                dz /= length;


                double dot = dx * look.x + dz * look.z;


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


                    if (player instanceof ServerPlayer serverPlayer) {

                        Advancement advancement =
                                serverPlayer.server.getAdvancements()
                                        .getAdvancement(
                                                new ResourceLocation("oresrise", "onyx_sword")
                                        );

                        if (advancement != null) {
                            serverPlayer.getAdvancements()
                                    .award(advancement, "backstab");
                        }
                    }


                    if (!player.level().isClientSide) {

                        ModNetwork.CHANNEL.send(
                                PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player),
                                new ShakePacket(1.0f, 15)
                        );


                        ((ServerLevel) player.level()).sendParticles(
                                ParticleTypes.SMOKE,
                                target.getX(),
                                target.getY() + 1,
                                target.getZ(),
                                15,
                                0.2,
                                0.3,
                                0.2,
                                0.02
                        );
                    }
                }
            }
        }


        return super.hurtEnemy(stack, target, attacker);
    }





    // ONYX GROUND SLAM
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);


        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }



        if (!level.isClientSide) {

            createSlam(level, player);


            level.playSound(
                    null,
                    player.blockPosition(),
                    SoundEvents.GENERIC_EXPLODE,
                    SoundSource.PLAYERS,
                    1.2F,
                    0.7F
            );


            player.getCooldowns().addCooldown(this, 70);
        }


        return InteractionResultHolder.success(stack);
    }





    private void createSlam(Level level, Player player) {


        double radius = 6.0;



        // BIG GROUND PARTICLE RING
        if (level instanceof ServerLevel server) {


            for (int i = 0; i < 150; i++) {


                double angle = Math.random() * Math.PI * 2;


                double distance = Math.random() * radius;


                double x = player.getX() + Math.cos(angle) * distance;
                double z = player.getZ() + Math.sin(angle) * distance;



                server.sendParticles(
                        ParticleTypes.SMOKE,
                        x,
                        player.getY() + 0.1,
                        z,
                        2,
                        0.2,
                        0.05,
                        0.2,
                        0.02
                );


                server.sendParticles(
                        ParticleTypes.CRIT,
                        x,
                        player.getY() + 0.2,
                        z,
                        1,
                        0,
                        0.1,
                        0,
                        0.05
                );
            }


            // center explosion dust
            server.sendParticles(
                    ParticleTypes.EXPLOSION,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    3,
                    0,
                    0,
                    0,
                    0
            );
        }





        // FIND ENEMIES
        List<LivingEntity> enemies =
                level.getEntitiesOfClass(
                        LivingEntity.class,
                        player.getBoundingBox().inflate(radius),
                        entity -> entity != player && entity.isAlive()
                );



        for (LivingEntity enemy : enemies) {


            enemy.hurt(
                    player.damageSources().playerAttack(player),
                    8.0F
            );



            double dx = enemy.getX() - player.getX();
            double dz = enemy.getZ() - player.getZ();



            double distance = Math.sqrt(dx * dx + dz * dz);



            if (distance > 0) {

                dx /= distance;
                dz /= distance;


                // throw away
                enemy.knockback(
                        3.0F,
                        -dx,
                        -dz
                );


                // launch upward
                enemy.setDeltaMovement(
                        enemy.getDeltaMovement().x,
                        0.8,
                        enemy.getDeltaMovement().z
                );
            }
        }
    }





    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(
                Component.translatable("tooltip.oresrise.onyx_sword.tooltip")
        );

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}