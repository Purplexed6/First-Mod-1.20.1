package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModItems;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class Misc {
    public static final RegistryObject<Item> IRON_STICK = ModItems.ITEMS.register("iron_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_STICK = ModItems.ITEMS.register("diamond_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_STICK = ModItems.ITEMS.register("obsidian_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_STICK = ModItems.ITEMS.register("netherite_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DOUGH = ModItems.ITEMS.register("dough",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_SLAG = ModItems.ITEMS.register("compressed_slag",
            () -> new FuelItem(new Item.Properties(), 7500));
    public static final RegistryObject<Item> NETHER_SLAG = ModItems.ITEMS.register("nether_slag",
            () -> new FuelItem(new Item.Properties(), 10000));
    public static final RegistryObject<Item> ENDER_SLAG = ModItems.ITEMS.register("ender_slag",
            () -> new FuelItem(new Item.Properties(), 12500));
    public static final RegistryObject<Item> BLAZE_SLAG = ModItems.ITEMS.register("blaze_slag",
            () -> new FuelItem(new Item.Properties(), 12500));
    public static final RegistryObject<Item> WITHER_SLAG = ModItems.ITEMS.register("wither_slag",
            () -> new FuelItem(new Item.Properties(), 15000));
    public static final RegistryObject<Item> STARDUST = ModItems.ITEMS.register("stardust",
            () -> new StardustItem(new Item.Properties()));
    public static final RegistryObject<Item> STARDUST_FRAGMENT = ModItems.ITEMS.register("stardust_fragment",
            () -> new StardustItem(new Item.Properties()));
    public static final RegistryObject<Item> WITHERED_BONE = ModItems.ITEMS.register("withered_bone",
            () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> ICE_CRYSTAL = ModItems.ITEMS.register("ice_crystal",
     //       () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ModItems.ITEMS.register("netherite_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_MESH = ModItems.ITEMS.register("netherite_mesh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEEPING_BIT = ModItems.ITEMS.register("weeping_bit",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_IRON_INGOT = ModItems.ITEMS.register("molten_iron_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_NETHERITE_INGOT = ModItems.ITEMS.register("molten_netherite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHANTOM_CELL = ModItems.ITEMS.register("phantom_cell",
            () -> new Item(new Item.Properties()));


    public static void register() {}
}