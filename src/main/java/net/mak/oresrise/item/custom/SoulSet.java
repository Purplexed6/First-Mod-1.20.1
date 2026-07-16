package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class SoulSet {

    public static final RegistryObject<Item> SOUL_FRAGMENT = ModItems.ITEMS.register("soul_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_CRYSTAL = ModItems.ITEMS.register("soul_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_POWDER = ModItems.ITEMS.register("soul_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_ESSENCE = ModItems.ITEMS.register("soul_essence",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOULFORGED_SWORD = ModItems.ITEMS.register("soulforged_sword",
            () -> new ModSwordItem(ModToolTiers.SOULFORGED, 4, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_PICKAXE = ModItems.ITEMS.register("soulforged_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SOULFORGED, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_AXE = ModItems.ITEMS.register("soulforged_axe",
            () -> new AxeItem(ModToolTiers.SOULFORGED, 5.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_SHOVEL = ModItems.ITEMS.register("soulforged_shovel",
            () -> new ShovelItem(ModToolTiers.SOULFORGED, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_HOE = ModItems.ITEMS.register("soulforged_hoe",
            () -> new HoeItem(ModToolTiers.SOULFORGED, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> SOULFORGED_HELMET = ModItems.ITEMS.register("soulforged_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SOULFORGED, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_CHESTPLATE = ModItems.ITEMS.register("soulforged_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SOULFORGED, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_LEGGINGS = ModItems.ITEMS.register("soulforged_leggings",
            () -> new ArmorItem(ModArmorMaterials.SOULFORGED, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SOULFORGED_BOOTS = ModItems.ITEMS.register("soulforged_boots",
            () -> new ArmorItem(ModArmorMaterials.SOULFORGED, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}