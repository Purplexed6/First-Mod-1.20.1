package net.mak.oresrise.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = "oresrise")
public class FluxiteStaffEvents {


    private static final List<StrikeTask> TASKS = new ArrayList<>();


    public static void addStrike(
            ServerLevel level,
            Player player,
            LivingEntity target,
            int delay
    ) {

        TASKS.add(
                new StrikeTask(
                        level,
                        player,
                        target,
                        delay
                )
        );
    }



    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {


        if (event.phase != TickEvent.Phase.END)
            return;


        for (int i = TASKS.size() - 1; i >= 0; i--) {


            StrikeTask task = TASKS.get(i);


            task.ticks--;


            if (task.ticks <= 0) {


                if (task.target.isAlive()) {


                    LightningBolt lightning =
                            EntityType.LIGHTNING_BOLT.create(task.level);


                    if (lightning != null) {


                        lightning.moveTo(
                                task.target.getX(),
                                task.target.getY(),
                                task.target.getZ()
                        );


                        task.level.addFreshEntity(lightning);
                    }


                    task.target.hurt(
                            task.player.damageSources()
                                    .playerAttack(task.player),
                            5F
                    );
                }


                TASKS.remove(i);
            }
        }
    }




    private static class StrikeTask {

        ServerLevel level;
        Player player;
        LivingEntity target;
        int ticks;


        StrikeTask(
                ServerLevel level,
                Player player,
                LivingEntity target,
                int ticks
        ) {

            this.level = level;
            this.player = player;
            this.target = target;
            this.ticks = ticks;
        }
    }
}