package net.mak.oresrise.event;

import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "oresrise",
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class RagingOreEvents {

    @SubscribeEvent
    public static void onRagingOreMined(BlockEvent.BreakEvent event) {

        Level level = (Level) event.getLevel();

        if (level.isClientSide()) {
            return;
        }

        BlockPos pos = event.getPos();

        if (!level.getBlockState(pos)
                .is(ModBlocks.RAGING_ORE.get())) {
            return;
        }

        level.explode(
                null,
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                3.0F,
                Level.ExplosionInteraction.NONE
        );
    }


    @SubscribeEvent
    public static void onExplosionDamage(LivingAttackEvent event) {

        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (player.getPersistentData()
                .getBoolean("RageitePickaxeExplosionImmunity")) {

            // Prevent the explosion from hurting the player
            if (event.getSource()
                    .is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION)) {

                event.setCanceled(true);

                // Remove immunity after surviving the explosion
                player.getPersistentData()
                        .remove("RageitePickaxeExplosionImmunity");
            }
        }
    }
}