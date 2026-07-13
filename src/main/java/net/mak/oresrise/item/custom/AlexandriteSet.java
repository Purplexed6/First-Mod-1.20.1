package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class AlexandriteSet {

    public static final RegistryObject<Item> ALEXANDRITE = ModItems.ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = ModItems.ITEMS.register("alexandrite_sword",
            () -> new SwordItem(ModToolTiers.ALEXANDRITE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ModItems.ITEMS.register("alexandrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALEXANDRITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_AXE = ModItems.ITEMS.register("alexandrite_axe",
            () -> new AxeItem(ModToolTiers.ALEXANDRITE, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ModItems.ITEMS.register("alexandrite_shovel",
            () -> new ShovelItem(ModToolTiers.ALEXANDRITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_HOE = ModItems.ITEMS.register("alexandrite_hoe",
            () -> new HoeItem(ModToolTiers.ALEXANDRITE, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> ALEXANDRITE_HELMET = ModItems.ITEMS.register("alexandrite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_CHESTPLATE = ModItems.ITEMS.register("alexandrite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_LEGGINGS = ModItems.ITEMS.register("alexandrite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_BOOTS = ModItems.ITEMS.register("alexandrite_boots",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}