package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class RageiteSet {

    public static final RegistryObject<Item> RAGING_FRAGMENT = ModItems.ITEMS.register("raging_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAGING_COMPOUND = ModItems.ITEMS.register("raging_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_INGOT = ModItems.ITEMS.register("rageite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_NUGGET = ModItems.ITEMS.register("rageite_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAGEITE_SWORD = ModItems.ITEMS.register("rageite_sword",
            () -> new RageiteSwordItem(ModToolTiers.RAGEITE, 3, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_PICKAXE = ModItems.ITEMS.register("rageite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RAGEITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_AXE = ModItems.ITEMS.register("rageite_axe",
            () -> new AxeItem(ModToolTiers.RAGEITE, 5.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_SHOVEL = ModItems.ITEMS.register("rageite_shovel",
            () -> new ShovelItem(ModToolTiers.RAGEITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_HOE = ModItems.ITEMS.register("rageite_hoe",
            () -> new HoeItem(ModToolTiers.RAGEITE, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> RAGEITE_HELMET = ModItems.ITEMS.register("rageite_helmet",
            () -> new ArmorItem(ModArmorMaterials.RAGEITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_CHESTPLATE = ModItems.ITEMS.register("rageite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RAGEITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_LEGGINGS = ModItems.ITEMS.register("rageite_leggings",
            () -> new ArmorItem(ModArmorMaterials.RAGEITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RAGEITE_BOOTS = ModItems.ITEMS.register("rageite_boots",
            () -> new ArmorItem(ModArmorMaterials.RAGEITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}