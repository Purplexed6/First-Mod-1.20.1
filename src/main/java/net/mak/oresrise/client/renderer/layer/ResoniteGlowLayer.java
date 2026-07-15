package net.mak.oresrise.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mak.oresrise.item.custom.ResoniteSet;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class ResoniteGlowLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    // CHANGE THIS to your actual mod ID
    private static final ResourceLocation GLOW_TEXTURE = new ResourceLocation("oresrise", "textures/models/armor/resonite_glow_layer_1.png");

    public ResoniteGlowLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                       AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {

        // Only render if the player is wearing your armor
        if (!player.getInventory().getArmor(2).is(ResoniteSet.RESONITE_CHESTPLATE.get())) {
            return;
        }

        VertexConsumer consumer = buffer.getBuffer(RenderType.eyes(GLOW_TEXTURE));

        this.getParentModel().renderToBuffer(
                poseStack,
                consumer,
                15728640, // Full brightness
                OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F
        );
    }
}
