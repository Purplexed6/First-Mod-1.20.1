package net.mak.oresrise.entity.client;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class EmberHuskRenderer extends ZombieRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("oresrise", "textures/entity/ember_husk.png");

    public EmberHuskRenderer(EntityRendererProvider.Context context) {
        // This tells Forge: "Use the vanilla Zombie model/animations for my Ember Husk"
        super(context, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
        }

        @Override
        public ResourceLocation getTextureLocation(Zombie pEntity) {
            return TEXTURE;
        }
    }
