package net.mak.oresrise.client;

import net.mak.oresrise.entity.FluxiteArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class FluxiteArrowRenderer extends ArrowRenderer<FluxiteArrowEntity> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    "oresrise",
                    "textures/entity/projectiles/fluxite_arrow.png"
            );

    public FluxiteArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(FluxiteArrowEntity entity) {
        return TEXTURE;
    }
}