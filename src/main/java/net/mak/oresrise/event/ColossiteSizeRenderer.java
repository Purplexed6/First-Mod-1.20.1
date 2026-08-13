package net.mak.oresrise.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "oresrise",
        value = Dist.CLIENT
)
public class ColossiteSizeRenderer {

    private static final String SIZE_TAG = "ColossiteSize";

    @SubscribeEvent
    public static void onRenderLiving(
            RenderLivingEvent.Pre<?, ?> event
    ) {

        LivingEntity entity = event.getEntity();

        int size = entity.getPersistentData().getInt(SIZE_TAG);

        PoseStack poseStack = event.getPoseStack();

        if (size == 1) {

            poseStack.scale(
                    0.5F,
                    0.5F,
                    0.5F
            );

        } else if (size == 3) {

            poseStack.scale(
                    3.0F,
                    3.0F,
                    3.0F
            );
        }
    }
}