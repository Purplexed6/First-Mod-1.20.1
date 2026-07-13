package net.mak.oresrise.event;

import net.mak.oresrise.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CheeseSmeltEvent {

    @SubscribeEvent
    public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        ItemStack result = event.getSmelting();
        Player player = event.getEntity();

        if (result.getItem() == ModItems.CHEESE.get()) {
            ItemStack bucket = new ItemStack(Items.BUCKET);

            if (!player.getInventory().add(bucket)) {
                player.drop(bucket, false);
            }
        }
    }
}

