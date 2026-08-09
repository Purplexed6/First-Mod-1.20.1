package net.mak.oresrise.item.custom;

import net.mak.oresrise.event.FluxiteStaffEvents;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;


public class FluxiteStaffItem extends Item {


    public FluxiteStaffItem(Properties properties) {
        super(properties);
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



            double radius = 7.5;



            List<LivingEntity> targets =
                    level.getEntitiesOfClass(
                            LivingEntity.class,
                            player.getBoundingBox().inflate(radius),
                            entity -> entity != player && entity.isAlive()
                    );



            // circle particles
            if (level instanceof ServerLevel server) {


                for (int i = 0; i < 100; i++) {


                    double angle =
                            (Math.PI * 2 * i) / 100;


                    double x =
                            player.getX()
                                    + Math.cos(angle) * radius;


                    double z =
                            player.getZ()
                                    + Math.sin(angle) * radius;



                    server.sendParticles(
                            ParticleTypes.ELECTRIC_SPARK,
                            x,
                            player.getY() + 0.1,
                            z,
                            2,
                            0.05,
                            0.05,
                            0.05,
                            0.02
                    );
                }



                int delay = 0;


                for (LivingEntity target : targets) {

                    FluxiteStaffEvents.addStrike(
                            server,
                            player,
                            target,
                            delay
                    );

                    delay += 6;
                }


                if (!targets.isEmpty()) {
                    triggerAdvancement(player);
                }
            }



            stack.hurtAndBreak(
                    1,
                    player,
                    p -> p.broadcastBreakEvent(hand)
            );


            player.getCooldowns()
                    .addCooldown(this, 20 * 5);
        }



        return InteractionResultHolder.success(stack);
    }



    private void triggerAdvancement(Player player) {

        if (!(player instanceof ServerPlayer serverPlayer))
            return;


        Advancement advancement = serverPlayer.server.getAdvancements()
                .getAdvancement(
                        new ResourceLocation("oresrise", "thunderstruck")
                );


        if (advancement == null)
            return;


        serverPlayer.getAdvancements()
                .award(
                        advancement,
                        "fluxite_staff_strike"
                );
    }



    @Override
    public void appendHoverText(
            ItemStack stack,
            @Nullable Level level,
            List<Component> tooltip,
            TooltipFlag flag
    ) {


        tooltip.add(
                Component.translatable(
                        "tooltip.oresrise.fluxite_staff.tooltip"
                )
        );


        super.appendHoverText(
                stack,
                level,
                tooltip,
                flag
        );
    }
}