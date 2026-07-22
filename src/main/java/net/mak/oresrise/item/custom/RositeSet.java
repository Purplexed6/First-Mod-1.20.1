package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class RositeSet {

    public static final RegistryObject<Item> ROSITE_INGOT = ModItems.ITEMS.register("rosite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_NUGGET = ModItems.ITEMS.register("rosite_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROSITE_SWORD = ModItems.ITEMS.register("rosite_sword",
            () -> new RositeSwordItem(ModToolTiers.ROSITE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_PICKAXE = ModItems.ITEMS.register("rosite_pickaxe",
            () -> new RositePickaxeItem(ModToolTiers.ROSITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_AXE = ModItems.ITEMS.register("rosite_axe",
            () -> new RositeAxeItem(ModToolTiers.ROSITE, 6.0f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_SHOVEL = ModItems.ITEMS.register("rosite_shovel",
            () -> new RositeShovelItem(ModToolTiers.ROSITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_HOE = ModItems.ITEMS.register("rosite_hoe",
            () -> new RositeAxeItem(ModToolTiers.ROSITE, -2, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> ROSITE_HELMET = ModItems.ITEMS.register("rosite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ROSITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_CHESTPLATE = ModItems.ITEMS.register("rosite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ROSITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_LEGGINGS = ModItems.ITEMS.register("rosite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ROSITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ROSITE_BOOTS = ModItems.ITEMS.register("rosite_boots",
            () -> new ArmorItem(ModArmorMaterials.ROSITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}

