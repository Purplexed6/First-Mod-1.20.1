package net.mak.oresrise.event;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.entity.ModEntities;
import net.mak.oresrise.entity.client.EmberHuskRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.EMBER_HUSK.get(), EmberHuskRenderer::new);
    }
}
