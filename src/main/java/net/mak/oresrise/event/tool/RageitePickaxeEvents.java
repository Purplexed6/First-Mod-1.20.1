package net.mak.oresrise.event.tool;

import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.RageiteSet;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "oresrise",
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class RageitePickaxeEvents {

    @SubscribeEvent
    public static void onRagingOreMined(BlockEvent.BreakEvent event) {

        Level level = (Level) event.getLevel();

        // Server only
        if (level.isClientSide()) {
            return;
        }

        Player player = event.getPlayer();

        ItemStack tool = player.getMainHandItem();

        // Only Rageite Pickaxe
        if (!tool.is(RageiteSet.RAGEITE_PICKAXE.get())) {
            return;
        }

        // Only Raging Ore
        if (!level.getBlockState(event.getPos())
                .is(ModBlocks.RAGING_ORE.get())) {
            return;
        }

        /*
         * The actual explosion is handled by
         * RagingOreEvents.
         *
         * We give the player temporary
         * explosion immunity.
         */

        player.getPersistentData().putBoolean(
                "RageitePickaxeExplosionImmunity",
                true
        );

        /*
         * 10% chance for an extra fragment.
         */

        if (level.random.nextFloat() < 0.10F) {

            player.spawnAtLocation(
                    new ItemStack(
                            RageiteSet.RAGING_FRAGMENT.get()
                    )
            );
        }
    }
}