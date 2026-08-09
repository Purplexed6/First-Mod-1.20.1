package net.mak.oresrise.event.armor;

import net.mak.oresrise.item.custom.OnyxSet;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class OnyxFallDamageHandler {

    @SubscribeEvent
    public static void reduceFallDamage(LivingFallEvent event) {

        if (!(event.getEntity() instanceof Player player))
            return;


        int onyxPieces = 0;


        // Count Onyx armor pieces
        for (ItemStack armor : player.getArmorSlots()) {

            if (armor.is(OnyxSet.ONYX_HELMET.get())
                    || armor.is(OnyxSet.ONYX_CHESTPLATE.get())
                    || armor.is(OnyxSet.ONYX_LEGGINGS.get())
                    || armor.is(OnyxSet.ONYX_BOOTS.get())) {

                onyxPieces++;
            }
        }


        if (onyxPieces > 0) {

            // 10% reduction per piece
            float multiplier = 1.0F - (onyxPieces * 0.10F);

            event.setDamageMultiplier(Math.max(multiplier, 0.1F));
        }
    }
}