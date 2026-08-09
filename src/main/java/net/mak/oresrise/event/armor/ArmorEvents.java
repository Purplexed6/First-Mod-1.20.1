package net.mak.oresrise.event.armor;

import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArmorEvents {

    private static final Map<UUID, ItemStack> LAST_BOOTS = new HashMap<>();


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        Player player = event.player;

        if (player.level().isClientSide) {
            return;
        }

        ItemStack boots = player.getInventory().getArmor(0);

        // Remove Soul Speed from previous boots if boots changed
        ItemStack oldBoots = LAST_BOOTS.get(player.getUUID());

        if (oldBoots != null && !ItemStack.matches(oldBoots, boots)) {

            removeSoulSpeed(oldBoots);
        }

        // 🔥 DREADSTEEL SOUL SPEED III
        if (hasCorrectArmorOn(ModArmorMaterials.DREADSTEEL, player)) {

            addSoulSpeed(boots, 3);

        }

        // 👻 SOULFORGED SOUL SPEED II
        else if (hasCorrectArmorOn(ModArmorMaterials.SOULFORGED, player)) {

            addSoulSpeed(boots, 2);

        }

        else {

            removeSoulSpeed(boots);

        }

        // Save current boots for next tick
        LAST_BOOTS.put(
                player.getUUID(),
                boots.copy()
        );
    }




    private static void addSoulSpeed(ItemStack boots, int level) {

        var enchantments = EnchantmentHelper.getEnchantments(boots);


        if (enchantments.getOrDefault(Enchantments.SOUL_SPEED, 0) < level) {

            enchantments.put(
                    Enchantments.SOUL_SPEED,
                    level
            );


            EnchantmentHelper.setEnchantments(
                    enchantments,
                    boots
            );
        }
    }




    private static void removeSoulSpeed(ItemStack boots) {

        var enchantments = EnchantmentHelper.getEnchantments(boots);


        if (enchantments.containsKey(Enchantments.SOUL_SPEED)) {

            enchantments.remove(Enchantments.SOUL_SPEED);


            EnchantmentHelper.setEnchantments(
                    enchantments,
                    boots
            );
        }
    }




    private static boolean hasCorrectArmorOn(ModArmorMaterials material, Player player) {

        return player.getInventory().getArmor(0).getItem() instanceof net.minecraft.world.item.ArmorItem boots
                && boots.getMaterial() == material

                && player.getInventory().getArmor(1).getItem() instanceof net.minecraft.world.item.ArmorItem leggings
                && leggings.getMaterial() == material

                && player.getInventory().getArmor(2).getItem() instanceof net.minecraft.world.item.ArmorItem chestplate
                && chestplate.getMaterial() == material

                && player.getInventory().getArmor(3).getItem() instanceof net.minecraft.world.item.ArmorItem helmet
                && helmet.getMaterial() == material;
    }
}