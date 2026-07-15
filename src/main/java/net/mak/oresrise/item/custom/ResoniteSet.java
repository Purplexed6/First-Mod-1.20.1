package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class ResoniteSet {

    public static final RegistryObject<Item> RESONITE_INGOT = ModItems.ITEMS.register("resonite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RESONITE_SWORD = ModItems.ITEMS.register("resonite_sword",
            () -> new SwordItem(ModToolTiers.RESONITE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_PICKAXE = ModItems.ITEMS.register("resonite_pickaxe",
            () -> new ModPickaxeItem(ModToolTiers.RESONITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_AXE = ModItems.ITEMS.register("resonite_axe",
            () -> new AxeItem(ModToolTiers.RESONITE, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_SHOVEL = ModItems.ITEMS.register("resonite_shovel",
            () -> new ShovelItem(ModToolTiers.RESONITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_HOE = ModItems.ITEMS.register("resonite_hoe",
            () -> new HoeItem(ModToolTiers.RESONITE, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> RESONITE_HELMET = ModItems.ITEMS.register("resonite_helmet",
            () -> new ArmorItem(ModArmorMaterials.RESONITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_CHESTPLATE = ModItems.ITEMS.register("resonite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RESONITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_LEGGINGS = ModItems.ITEMS.register("resonite_leggings",
            () -> new ArmorItem(ModArmorMaterials.RESONITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RESONITE_BOOTS = ModItems.ITEMS.register("resonite_boots",
            () -> new ArmorItem(ModArmorMaterials.RESONITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}