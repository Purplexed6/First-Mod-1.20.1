package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import static net.mak.oresrise.item.ModItems.ITEMS;

public class StarriteSet {

    public static final RegistryObject<Item> STARRITE = ModItems.ITEMS.register("starrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STARRITE_SWORD = ModItems.ITEMS.register("starrite_sword",
            () -> new ModSwordItem(ModToolTiers.STARRITE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_PICKAXE = ModItems.ITEMS.register("starrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STARRITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_AXE = ModItems.ITEMS.register("starrite_axe",
            () -> new AxeItem(ModToolTiers.STARRITE, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_SHOVEL = ModItems.ITEMS.register("starrite_shovel",
            () -> new ShovelItem(ModToolTiers.STARRITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_HOE = ModItems.ITEMS.register("starrite_hoe",
            () -> new HoeItem(ModToolTiers.STARRITE, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> STARRITE_HELMET = ModItems.ITEMS.register("starrite_helmet",
            () -> new ArmorItem(ModArmorMaterials.STARRITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_CHESTPLATE = ModItems.ITEMS.register("starrite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STARRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_LEGGINGS = ModItems.ITEMS.register("starrite_leggings",
            () -> new ArmorItem(ModArmorMaterials.STARRITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STARRITE_BOOTS = ModItems.ITEMS.register("starrite_boots",
            () -> new ArmorItem(ModArmorMaterials.STARRITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> STAR_STAFF = ITEMS.register("star_staff",
            () -> new StarStaffItem(new Item.Properties().stacksTo(1)));

    public static void register() {}
}