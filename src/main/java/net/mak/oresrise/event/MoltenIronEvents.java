package net.mak.oresrise.event;

import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.Misc;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MoltenIronEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        LivingEntity player = event.player;

        // Only run on the server
        if (player.level().isClientSide()) {
            return;
        }

        // Check main hand
        ItemStack mainHand = player.getMainHandItem();

        // Check off hand
        ItemStack offHand = player.getOffhandItem();

        if (mainHand.is(Misc.MOLTEN_IRON_INGOT.get())
                || offHand.is(Misc.MOLTEN_IRON_INGOT.get())) {

            // 1 damage = half a heart
            player.hurt(
                    player.damageSources().hotFloor(),
                    1.0F
            );
        }
    }
}