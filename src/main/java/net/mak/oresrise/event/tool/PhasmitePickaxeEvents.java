package net.mak.oresrise.event.tool;

import net.mak.oresrise.item.custom.PhasmiteSet;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "oresrise",
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class PhasmitePickaxeEvents {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        Player player = event.getPlayer();

        if (player.level().isClientSide()) {
            return;
        }

        ItemStack tool = player.getMainHandItem();

        if (!tool.is(PhasmiteSet.PHASMITE_PICKAXE.get())) {
            return;
        }

        // 25% chance
        if (player.getRandom().nextFloat() >= 0.25F) {
            return;
        }

        // We'll handle the extra drop separately.
    }
}