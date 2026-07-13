package net.mak.oresrise.event;

import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.Misc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class DoughCraftEvent {

    @Mod.EventBusSubscriber
    public class ModCraftingEvents {

        @SubscribeEvent
        public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
            ItemStack result = event.getCrafting();
            Player player = event.getEntity();

            if (result.getItem() == Misc.DOUGH.get()) {
            }
        }
    }
}
