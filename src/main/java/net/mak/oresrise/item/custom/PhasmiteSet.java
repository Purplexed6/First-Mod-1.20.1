package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import static net.mak.oresrise.item.ModItems.ITEMS;

public class PhasmiteSet {

    public static final RegistryObject<Item> PHASMIC_SHARD = ModItems.ITEMS.register("phasmic_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE = ModItems.ITEMS.register("phasmite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHASMITE_SWORD = ModItems.ITEMS.register("phasmite_sword",
            () -> new SwordItem(ModToolTiers.PHASMITE, 4, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_PICKAXE = ModItems.ITEMS.register("phasmite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PHASMITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_AXE = ModItems.ITEMS.register("phasmite_axe",
            () -> new AxeItem(ModToolTiers.PHASMITE, 6f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_SHOVEL = ModItems.ITEMS.register("phasmite_shovel",
            () -> new ShovelItem(ModToolTiers.PHASMITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_HOE = ModItems.ITEMS.register("phasmite_hoe",
            () -> new HoeItem(ModToolTiers.PHASMITE, -4, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> PHASMITE_HELMET = ModItems.ITEMS.register("phasmite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.PHASMITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_CHESTPLATE = ModItems.ITEMS.register("phasmite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PHASMITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_LEGGINGS = ModItems.ITEMS.register("phasmite_leggings",
            () -> new ArmorItem(ModArmorMaterials.PHASMITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PHASMITE_BOOTS = ModItems.ITEMS.register("phasmite_boots",
            () -> new ArmorItem(ModArmorMaterials.PHASMITE, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> STAR_STAFF = ITEMS.register("star_staff",
            () -> new StarStaffItem(new Item.Properties().stacksTo(1)));

    public static void register() {}
}