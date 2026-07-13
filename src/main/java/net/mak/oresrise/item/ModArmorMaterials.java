package net.mak.oresrise.item;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.custom.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.tools.obfuscation.fg3.ObfuscationServiceFG3;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    SOULFORGED("soulforged", 40, new int[]{ 4, 9, 7, 4 }, 18,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2.8f, 0.1f, () -> Ingredient.of(SoulSet.SOUL_CRYSTAL.get())),

    HEMOGEM("hemogem", 30, new int[]{ 3, 8, 6, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_GOLD,
            2.3f, // toughness (slightly above diamond, below netherite)
            0.05f, // knockback resistance (small bonus)
            () -> Ingredient.of(HemoSet.HEMOGEM.get())),

    QUINTESSITE("quintessite", 40,
            new int[]{ 4, 9, 7, 4 }, // strong but not insane
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f,   // toughness (high)
            0.25f,  // knockback resistance (very stable)
            () -> Ingredient.of(QuintessiteSet.QUINTESSITE.get())),

    LUNARIS("lunaris", 40, new int[]{ 4, 9, 7, 4 }, 18,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 3f, 0.2f, () -> Ingredient.of(LunarisSet.LUNARIS.get())),

    ONYX("onyx", 42, new int[]{ 4, 9, 7, 4 }, 17,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.2f, // toughness
            0.2f, // knockback resistance (feels heavy/powerful)
            () -> Ingredient.of(OnyxSet.ONYX.get())),

    SOUL_STEEL("soul_steel", 42, new int[]{ 4, 9, 7, 4 }, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.3f,
            0.12f,
            () -> Ingredient.of(SoulSteelSet.SOUL_STEEL_INGOT.get())),

    CRYPTON("crypton",
            45,                     // durability multiplier (strong but below quintessite)
            new int[]{ 5, 9, 8, 5 },// balanced protection (slightly below top tiers)
            22,                     // enchantability (high)
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f,                   // toughness (solid)
            0.15f,                  // knockback resistance (light, agile feel)
            () -> Ingredient.of(CryptonSet.CRYPTON.get())),

    STAR_PLATINUM("star_platinum", 44, new int[]{ 4, 9, 7, 4 }, 17,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.6f,
            0.15f,
            () -> Ingredient.of(StarPlatinumSet.STAR_PLATINUM_INGOT.get())),

    WITHERITE("witherite", 40, new int[]{ 4, 9, 7, 4 }, 18,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 3f, 0.2f, () -> Ingredient.of(WitheriteSet.WITHERITE_INGOT.get())),

    AZURITE("azurite", 37, new int[]{ 3, 8, 6, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3f, 0.1f, () -> Ingredient.of(AzuriteSet.AZURITE.get())),

    PLATINUM("platinum", 30, new int[]{ 3, 8, 6, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.5f, // toughness (slightly above diamond, below netherite)
            0.05f, // knockback resistance (small bonus)
            () -> Ingredient.of(PlatinumSet.PLATINUM_INGOT.get())),

    STARRITE("starrite", 30, new int[]{ 3, 8, 6, 3 }, 18,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.2f, // slightly above diamond (2)
            0.02f, // very small knockback resist
            () -> Ingredient.of(StarriteSet.STARRITE.get())),

    AMBER("amber", 40, new int[]{3, 8, 6, 3}, 18,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.0f, // ⬅ decent toughness (diamond = 2, netherite = 3)
            0.0f, // ⬅ no knockback resistance
            () -> Ingredient.of(AmberSet.AMBER.get())),


    ROSITE("rosite", 15, new int[]{ 2, 6, 5, 2 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 0f, 0f, () -> Ingredient.of(RositeSet.ROSITE_INGOT.get())),

    ROSE_GOLD_INGOT("rose_gold_ingot", 15, new int[]{ 2, 6, 5, 2 }, 14,
            SoundEvents.ARMOR_EQUIP_GOLD, 0f, 0f, () -> Ingredient.of(RoseGoldSet.ROSE_GOLD_INGOT.get())),

    AMETHYST("amethyst", 18, new int[]{ 2, 5, 7, 2 }, 18,
            SoundEvents.AMETHYST_BLOCK_PLACE, 0f, 0f, () -> Ingredient.of(Items.AMETHYST_SHARD)),

    EMERALD("emerald", 25, new int[]{ 3, 8, 6, 3 }, 20,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(Items.EMERALD)),

    OBSIDIAN("obsidian", 50, new int[]{ 3, 8, 6, 3 }, 16,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 3f, 0.2f, () -> Ingredient.of(Items.OBSIDIAN)),

    COBALT("cobalt", 33, new int[]{ 3, 8, 6, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0f, () -> Ingredient.of(CobaltSet.COBALT_INGOT.get())),



    SUGILITE("sugilite", 33, new int[]{ 3, 8, 6, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0f, () -> Ingredient.of(SugiliteSet.SUGILITE.get())),

    ALEXANDRITE("alexandrite", 33, new int[]{ 3, 8, 6, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0f, () -> Ingredient.of(AlexandriteSet.ALEXANDRITE.get())),

    RUBY("ruby", 33, new int[]{ 3, 8, 6, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0f, () -> Ingredient.of(RubySet.RUBY.get())),

    SAPPHIRE("sapphire", 33, new int[]{ 3, 8, 6, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0f, () -> Ingredient.of(SapphireSet.SAPPHIRE.get()));


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ExampleMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}