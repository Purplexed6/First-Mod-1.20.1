package net.mak.oresrise.event.armor;

import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CryptonArmorHandler {

    @SubscribeEvent
    public static void onPlayerHit(LivingAttackEvent event) {

        if (!(event.getEntity() instanceof Player player))
            return;

        if (hasFullCryptonArmor(player)) {

            // 20% chance to completely ignore the hit
            if (player.getRandom().nextFloat() < 0.25f) {
                event.setCanceled(true);
            }
        }
    }

    private static boolean hasFullCryptonArmor(Player player) {

        return player.getInventory().getArmor(0).getItem() instanceof net.minecraft.world.item.ArmorItem boots &&
                boots.getMaterial() == ModArmorMaterials.COLOSSITE &&

                player.getInventory().getArmor(1).getItem() instanceof net.minecraft.world.item.ArmorItem leggings &&
                leggings.getMaterial() == ModArmorMaterials.COLOSSITE &&

                player.getInventory().getArmor(2).getItem() instanceof net.minecraft.world.item.ArmorItem chestplate &&
                chestplate.getMaterial() == ModArmorMaterials.COLOSSITE &&

                player.getInventory().getArmor(3).getItem() instanceof net.minecraft.world.item.ArmorItem helmet &&
                helmet.getMaterial() == ModArmorMaterials.COLOSSITE;
    }
}