package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class StarPlatinumSet {

    public static final RegistryObject<Item> STAR_PLATINUM_INGOT = ModItems.ITEMS.register("star_platinum_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STAR_PLATINUM_SWORD = ModItems.ITEMS.register("star_platinum_sword",
            () -> new ModSwordItem(ModToolTiers.STAR_PLATINUM, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_PICKAXE = ModItems.ITEMS.register("star_platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STAR_PLATINUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_AXE = ModItems.ITEMS.register("star_platinum_axe",
            () -> new AxeItem(ModToolTiers.STAR_PLATINUM, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_SHOVEL = ModItems.ITEMS.register("star_platinum_shovel",
            () -> new ShovelItem(ModToolTiers.STAR_PLATINUM, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_HOE = ModItems.ITEMS.register("star_platinum_hoe",
            () -> new HoeItem(ModToolTiers.STAR_PLATINUM, -4, 0, new Item.Properties()));

    public static final RegistryObject<Item> STAR_PLATINUM_HELMET = ModItems.ITEMS.register("star_platinum_helmet",
            () -> new ModArmorItem(ModArmorMaterials.STAR_PLATINUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_CHESTPLATE = ModItems.ITEMS.register("star_platinum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STAR_PLATINUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_LEGGINGS = ModItems.ITEMS.register("star_platinum_leggings",
            () -> new ArmorItem(ModArmorMaterials.STAR_PLATINUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STAR_PLATINUM_BOOTS = ModItems.ITEMS.register("star_platinum_boots",
            () -> new ArmorItem(ModArmorMaterials.STAR_PLATINUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}