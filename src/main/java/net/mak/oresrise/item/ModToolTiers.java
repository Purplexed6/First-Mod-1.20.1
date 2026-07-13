package net.mak.oresrise.item;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SOULFORGED = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2600, 10f, 5f, 16,
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(SoulSet.SOUL_CRYSTAL.get())),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "soulforged"), List.of(Tiers.STONE), List.of(Tiers.DIAMOND));

    public static final Tier SHADOW_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2300, 10f, 5f, 16,
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(AmberSet.ROUGH_AMBER.get())),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "shadow"), List.of(Tiers.STONE), List.of(Tiers.DIAMOND));

    public static final Tier WITHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2600, 10f, 5f, 16,
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(WitheriteSet.WITHERITE_INGOT.get())),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "witherite"), List.of(Tiers.STONE), List.of(Tiers.DIAMOND));

    public static final Tier ROSE_GOLD_INGOT = TierSortingRegistry.registerTier(
            new ForgeTier(2, 250, 12f, 2f, 14, // Level 2 is Iron level
                    BlockTags.NEEDS_IRON_TOOL, // Use the Vanilla BlockTag
                    () -> Ingredient.of(RoseGoldSet.ROSE_GOLD_INGOT.get())),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "rose_gold"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier AZURITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    4, // mining level
                    2031, // durability
                    9f, // mining speed
                    4f, // attack damage bonus
                    15, // enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(AzuriteSet.AZURITE.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "azurite"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier OBSIDIAN = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3,                      // ⬅ mining level
                    2300,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    16,                     // ⬅ enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(ObsidianSet.OBSIDIAN_SHARD.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "obsidian"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));// ⬅ repair item

    public static final Tier ROSITE = TierSortingRegistry.registerTier(        //SAME AS IRON
            new ForgeTier(
                    2,                      // ⬅ mining level
                    250,                    // ⬅ durability
                    6f,                    // ⬅ mining speed
                    2f,                     // ⬅ attack damage bonus
                    14,                     // ⬅ enchantability
                    BlockTags.NEEDS_IRON_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(RositeSet.ROSITE_INGOT.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "rosite"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier COBALT = TierSortingRegistry.registerTier(        //SAME AS IRON
            new ForgeTier(
                    2,                      // ⬅ mining level
                    250,                    // ⬅ durability
                    6f,                    // ⬅ mining speed
                    2f,                     // ⬅ attack damage bonus
                    14,                     // ⬅ enchantability
                    BlockTags.NEEDS_IRON_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(CobaltSet.COBALT_INGOT.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "cobalt"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier ALEXANDRITE = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    10,                     // ⬅ enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(AlexandriteSet.ALEXANDRITE.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "alexandrite"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier RUBY = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    10,                     // ⬅ enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(RubySet.RUBY.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "ruby"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier AMBER = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // ⬅ Diamond mining level
                    2000, // ⬅ VERY high durability (Netherite = 2031)
                    8.0f, // ⬅ Same as diamond (not faster)
                    3.0f, // ⬅ Same as diamond (not combat-focused)
                    15, // ⬅ Good enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(AmberSet.AMBER.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "amber"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier SUGILITE = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus wait lemme find this shit
                    10,                     // ⬅ enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(SugiliteSet.SUGILITE.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "sugilite"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    10,                     // ⬅ enchantability
                    BlockTags.NEEDS_DIAMOND_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(SapphireSet.SAPPHIRE.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "sapphire"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier PLATINUM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // ⬅ mining level (Diamond is 3, so same)
                    1800, // ⬅ durability (Diamond = 1561, Netherite = 2031)
                    9f, // ⬅ mining speed (Diamond = 8, Netherite = 9)
                    3.5f, // ⬅ attack damage bonus (between diamond 3 and netherite 4)
                    15, // ⬅ enchantability (better than diamond)
                    BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(PlatinumSet.PLATINUM_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "platinum"),
            List.of(Tiers.STONE),   // ⬅ weaker than platinum
            List.of(Tiers.DIAMOND));  // ⬅ stronger than platinum

    public static final Tier STARRITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // same mining level as diamond
                    1700, // slightly above diamond (1561)
                    8.5f, // between diamond (8) and platinum (9)
                    3.2f, // tiny boost over diamond
                    18, // ⬅ main strength (very enchantable)
                    BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(StarriteSet.STARRITE.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "starrite"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier EMERALD = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // ⬅ mining level (iron level, weaker than diamond)
                    900, // ⬅ durability (lower than diamond)
                    7f, // ⬅ mining speed (slightly slower)
                    2.5f, // ⬅ attack damage
                    20, // ⬅ VERY high enchantability (main strength)
                    BlockTags.NEEDS_IRON_TOOL,
                    () -> Ingredient.of(Items.EMERALD)
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "emerald"),

            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier AMETHYST = TierSortingRegistry.registerTier(
            new ForgeTier(
                    2, // ⬅ iron level
                    600, // ⬅ low durability (fragile crystal)
                    10f, // ⬅ VERY fast mining
                    2f, // ⬅ lower damage
                    18, // ⬅ high enchantability
                    BlockTags.NEEDS_IRON_TOOL,
                    () -> Ingredient.of(Items.AMETHYST_SHARD)
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "amethyst"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier SOUL_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5, // new tier above netherite
                    2300, // not too high (leave room)
                    10f, // small upgrade
                    4.5f, // slight damage boost
                    15, // decent enchantability
                    ModTags.Blocks.NEEDS_SOUL_STEEL_TOOL,
                    () -> Ingredient.of(SoulSteelSet.SOUL_STEEL_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "soul_steel"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier STAR_PLATINUM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5,
                    2450,
                    9f,
                    4.5f,
                    17,
                    ModTags.Blocks.NEEDS_SOUL_STEEL_TOOL,
                    () -> Ingredient.of(StarPlatinumSet.STAR_PLATINUM_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "star_platinum"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier HEMOGEM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // same as diamond
                    1500, // ⬇ LOWER durability (risk/reward)
                    9f, // ⬆ faster than diamond
                    3.0f, // ⬇ slightly weaker base damage
                    12, // ⬆ high enchantability (build-focused)
                    BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(HemoSet.HEMOGEM.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "hemogem"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier LUNARIS = TierSortingRegistry.registerTier(
            new ForgeTier(
                    4, // same as netherite
                    2400, // ⬇ slightly less than before (not insane)
                    8.5f, // ⬇ slower than netherite (heavy feel)
                    5f, // ⬆ strong hits
                    18, // ⬇ lower enchantability (not magic-focused)
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL,
                    () -> Ingredient.of(LunarisSet.LUNARIS.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "lunaris"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier ONYX = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5, // above netherite
                    3000, // high durability (end-tier feel)
                    10.5f, // fast but not insane
                    5.5f, // strong hits
                    17, // decent enchantability
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL,
                    () -> Ingredient.of(OnyxSet.ONYX.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "onyx"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));

    public static final Tier QUINTESSITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5,
                    3500, // very high durability
                    9.5f,
                    5.5f,
                    20,
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL,
                    () -> Ingredient.of(QuintessiteSet.QUINTESSITE.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "quintessite"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND));



    public static final Tier CRYPTON = TierSortingRegistry.registerTier(
            new ForgeTier(
                    6,      // same level as netherite
                    2800,   // durable, but not insane
                    11f,  // fast
                    5.0f,   // strong but not max
                    22,     // high enchantability
                    ModTags.Blocks.NEEDS_CRYPTON_TOOL,
                    () -> Ingredient.of(CryptonSet.CRYPTON.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "crypton"),
            List.of(Tiers.STONE),
            List.of(Tiers.DIAMOND)
    );
}
