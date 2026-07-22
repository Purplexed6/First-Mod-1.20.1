package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class RubySet {

    public static final RegistryObject<Item> ROUGH_RUBY = ModItems.ITEMS.register("rough_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ModItems.ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBY_SWORD = ModItems.ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ModItems.ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ModItems.ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ModItems.ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ModItems.ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_HELMET = ModItems.ITEMS.register("ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ModItems.ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ModItems.ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ModItems.ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}