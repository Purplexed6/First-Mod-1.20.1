package net.mak.oresrise.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oresrise", value = Dist.CLIENT)
public class ClientCameraEvents {

    @SubscribeEvent
    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {

        float shake = ClientShakeHandler.getShake();

        if (shake > 0) {
            event.setYaw(event.getYaw() + (float)(Math.random() - 0.5) * shake);
            event.setPitch(event.getPitch() + (float)(Math.random() - 0.5) * shake);
        }
    }
}