package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import static net.mak.oresrise.item.ModItems.ITEMS;

public class ShadowSteelSet {

    public static final RegistryObject<Item> SHADOW_DAGGER =
            ITEMS.register("shadow_dagger",
                    () -> new ShadowDaggerItem(
                            Tiers.NETHERITE,
                            1,
                            -2.2f,
                            new Item.Properties()
                    ));

    public static void register() {}
}