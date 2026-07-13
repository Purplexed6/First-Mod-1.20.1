package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class EmeraldSet {

    public static final RegistryObject<Item> EMERALD_SWORD = ModItems.ITEMS.register("emerald_sword",
            () -> new SwordItem(ModToolTiers.EMERALD, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ModItems.ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMERALD, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ModItems.ITEMS.register("emerald_axe",
            () -> new AxeItem(ModToolTiers.EMERALD, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ModItems.ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModToolTiers.EMERALD, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ModItems.ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModToolTiers.EMERALD, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> EMERALD_HELMET = ModItems.ITEMS.register("emerald_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ModItems.ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ModItems.ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ModItems.ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}

