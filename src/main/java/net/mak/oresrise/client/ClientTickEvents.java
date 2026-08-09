package net.mak.oresrise.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oresrise", value = Dist.CLIENT)
public class ClientTickEvents {


    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase == TickEvent.Phase.END) {
            ClientShakeHandler.tick();
        }

    }
}