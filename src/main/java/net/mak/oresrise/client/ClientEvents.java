package net.mak.oresrise.client;

import net.mak.oresrise.client.ClientShakeHandler;
import net.mak.oresrise.client.renderer.layer.ResoniteGlowLayer;
import net.mak.oresrise.item.custom.VoltiumSet;
import net.mak.oresrise.item.custom.SoulSet;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oresrise", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        ClientShakeHandler.tick();
    }

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        // Iterate through available skin types ("default", "slim")
        for (String skinType : event.getSkins()) {
            EntityRenderer<? extends Player> renderer = event.getSkin(skinType);

            // Cast to PlayerRenderer to access .addLayer()
            if (renderer instanceof PlayerRenderer) {
                PlayerRenderer playerRenderer = (PlayerRenderer) renderer;
                playerRenderer.addLayer(new ResoniteGlowLayer(playerRenderer));
            }
        }
    }
}
