package net.mak.oresrise.item;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModToolTiers {

    public static final Tier ROSE_GOLD_INGOT = TierSortingRegistry.registerTier(
            new ForgeTier(
                    2,
                    250,
                    12f,
                    2f,
                    10, // Level 2 is Iron level
                    ModTags.Blocks.NEEDS_ROSE_GOLD_TOOL, // Use the Vanilla BlockTag
                    () -> Ingredient.of(RoseGoldSet.ROSE_GOLD_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "rose_gold"),
            List.of(Tiers.IRON),
            List.of());

    public static final Tier ROSITE = TierSortingRegistry.registerTier(        //SAME AS IRON
            new ForgeTier(
                    2,                      // ⬅ mining level
                    400,                    // ⬅ durability
                    7f,                    // ⬅ mining speed
                    2.5f,                     // ⬅ attack damage bonus
                    18,                     // ⬅ enchantability
                    ModTags.Blocks.NEEDS_ROSITE_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(RositeSet.ROSITE_INGOT.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "rosite"),
            List.of(ModToolTiers.ROSE_GOLD_INGOT),
            List.of());

    public static final Tier STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(
                    2,      // mining level (Iron)
                    750,    // durability (~2.8x Iron)
                    8f,   // mining speed
                    1.5f,   // attack damage bonus (+1 over Iron)
                    10,     // enchantability
                    ModTags.Blocks.NEEDS_STEEL_TOOL,
                    () -> Ingredient.of(SteelSet.STEEL_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "steel"),
            List.of(ModToolTiers.ROSITE),
            List.of(Tiers.DIAMOND));

    /* public static final Tier COBALT = TierSortingRegistry.registerTier(        //SAME AS IRON
            new ForgeTier(
                    2,                      // ⬅ mining level
                    250,                    // ⬅ durability
                    6f,                    // ⬅ mining speed
                    2f,                     // ⬅ attack damage bonus
                    14,                     // ⬅ enchantability
                    ModTags.Blocks.NEEDS_COBALT_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(CobaltSet.COBALT_INGOT.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "cobalt"),
            List.of(ModToolTiers.STEEL),
            List.of()); */

    public static final Tier AMETHYST = TierSortingRegistry.registerTier(
            new ForgeTier(
                    2, // ⬅ iron level
                    500, // ⬅ low durability (fragile crystal)
                    9f, // ⬅ VERY fast mining
                    2f, // ⬅ lower damage
                    20, // ⬅ high enchantability
                    ModTags.Blocks.NEEDS_AMETHYST_TOOL,
                    () -> Ingredient.of(Items.AMETHYST_SHARD)
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "amethyst"),
            List.of(ModToolTiers.STEEL),
            List.of());

    public static final Tier EMERALD = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // ⬅ mining level (iron level, weaker than diamond)
                    900, // ⬅ durability (lower than diamond)
                    7f, // ⬅ mining speed (slightly slower)
                    3f, // ⬅ attack damage
                    13, // ⬅ VERY high enchantability (main strength)
                    ModTags.Blocks.NEEDS_EMERALD_TOOL,
                    () -> Ingredient.of(Items.EMERALD)
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "emerald"),
            List.of(ModToolTiers.AMETHYST),
            List.of(Tiers.DIAMOND));

    /* public static final Tier JADE = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    10,                     // ⬅ enchantability
                    ModTags.Blocks.NEEDS_JADE_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(JadeSet.JADE.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "jade"),
            List.of(ModToolTiers.EMERALD),
            List.of()); */

    public static final Tier RUBY = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    10,                     // ⬅ enchantability
                    ModTags.Blocks.NEEDS_RUBY_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(RubySet.RUBY.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "ruby"),
            List.of(Tiers.DIAMOND),
            List.of(Tiers.NETHERITE));

    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(       //SAME AS DIAMOND
            new ForgeTier(
                    3,                      // ⬅ mining level
                    1500,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    10,                     // ⬅ enchantability
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(SapphireSet.SAPPHIRE.get()) // ⬅ repair item
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "sapphire"),
            List.of(Tiers.DIAMOND),
            List.of(Tiers.NETHERITE));

    public static final Tier RAGEITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // ⬅ mining level (Diamond is 3, so same)
                    1800, // ⬅ durability (Diamond = 1561, Netherite = 2031)
                    10f, // ⬅ mining speed (Diamond = 8, Netherite = 9)
                    3.5f, // ⬅ attack damage bonus (between diamond 3 and netherite 4)
                    17, // ⬅ enchantability (better than diamond)
                    ModTags.Blocks.NEEDS_RAGEITE_TOOL,
                    () -> Ingredient.of(RageiteSet.RAGEITE_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "rageite"),
            List.of(ModToolTiers.SAPPHIRE),   // ⬅ weaker than rageite
            List.of());  // ⬅ stronger than rageite

    public static final Tier OBSIDIUM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3,                      // ⬅ mining level
                    2300,                    // ⬅ durability
                    8f,                    // ⬅ mining speed
                    3f,                     // ⬅ attack damage bonus
                    16,                     // ⬅ enchantability
                    ModTags.Blocks.NEEDS_OBSIDIUM_TOOL, // ⬅ what blocks it can mine
                    () -> Ingredient.of(ObsidiumSet.OBSIDIUM_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "obsidian"),
            List.of(ModToolTiers.RAGEITE),
            List.of());

    public static final Tier KEYOLITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // mining level
                    1600, // durability
                    8f, // mining speed
                    2f, // attack damage bonus
                    20, // enchantability
                    ModTags.Blocks.NEEDS_KEYOLITE_TOOL,
                    () -> Ingredient.of(KeyoliteSet.KEYOLITE_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "keyolite"),
            List.of(ModToolTiers.OBSIDIUM),
            List.of());

    public static final Tier VOLTIUM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // mining level
                    2031, // durability
                    10f, // mining speed
                    4f, // attack damage bonus
                    15, // enchantability
                    ModTags.Blocks.NEEDS_VOLTIUM_TOOL,
                    () -> Ingredient.of(VoltiumSet.VOLTIUM_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "fluxite"),
            List.of(ModToolTiers.KEYOLITE),
            List.of(Tiers.NETHERITE));

    /*public static final Tier FIREITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    4, // mining level
                    2031, // durability
                    9f, // mining speed
                    4f, // attack damage bonus
                    15, // enchantability
                    ModTags.Blocks.NEEDS_FIREITE_TOOL,
                    () -> Ingredient.of(FireiteSet.FIREITE_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "fireite"),
            List.of(ModToolTiers.VOLTIUM),
            List.of());*/

    public static final Tier SOULFORGED = TierSortingRegistry.registerTier(
            new ForgeTier(4,
                    2300,
                    9.5f,
                    4f,
                    18,
                    ModTags.Blocks.NEEDS_SOULFORGED_TOOL,
                    () -> Ingredient.of(SoulSet.SOUL_CRYSTAL.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "soulforged"),
            List.of(Tiers.NETHERITE),
            List.of());

    public static final Tier HEMOGEM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // same as diamond
                    1500, // ⬇ HIGHER durability (risk/reward)
                    8.5f, // ⬆ slower
                    3.0f, // ⬇ slightly weaker base damage
                    12, // ⬆ high enchantability (build-focused)
                    ModTags.Blocks.NEEDS_HEMOGEM_TOOL,
                    () -> Ingredient.of(HemoSet.HEMOGEM.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "hemogem"),
            List.of(ModToolTiers.SOULFORGED),
            List.of());

    public static final Tier HYDROGEM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // same as diamond
                    1500, // ⬇ LOWER durability (risk/reward)
                    10f, // ⬆ faster
                    3.0f, // ⬇ slightly weaker base damage
                    12, // ⬆ high enchantability (build-focused)
                    ModTags.Blocks.NEEDS_HYDROGEM_TOOL,
                    () -> Ingredient.of(HydroSet.HYDROGEM.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "hydrogem"),
            List.of(ModToolTiers.HEMOGEM),
            List.of());

    public static final Tier SHADOW_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(4,
                    2300,
                    10f,
                    5f,
                    16,
                    ModTags.Blocks.NEEDS_SHADOW_STEEL_TOOL,
                    () -> Ingredient.of(Items.ECHO_SHARD)),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "shadow"),
            List.of(ModToolTiers.HYDROGEM),
            List.of());

    public static final Tier WITHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(4,
                    2600,
                    9f,
                    5f,
                    16,
                    ModTags.Blocks.NEEDS_WITHERITE_TOOL,
                    () -> Ingredient.of(WitheriteSet.WITHERITE_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "witherite"),
            List.of(ModToolTiers.SHADOW_STEEL),
            List.of());

    public static final Tier SCOURIUM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // ⬅ Diamond mining level
                    2000, // ⬅ VERY high durability (Netherite = 2031)
                    8.0f, // ⬅ Same as diamond (not faster)
                    3.0f, // ⬅ Same as diamond (not combat-focused)
                    15, // ⬅ Good enchantability
                    ModTags.Blocks.NEEDS_SCOURIUM_TOOL,
                    () -> Ingredient.of(ScouriumSet.SCOURIUM_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "amber"),
            List.of(ModToolTiers.WITHERITE),
            List.of());

    public static final Tier PHASMITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    3, // same mining level as diamond
                    1700, // slightly above diamond (1561)
                    8.5f, // between diamond (8) and platinum (9)
                    4f, // tiny boost over diamond
                    18, // ⬅ main strength (very enchantable)
                    ModTags.Blocks.NEEDS_PHASMITE_TOOL,
                    () -> Ingredient.of(PhasmiteSet.PHASMITE.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "phasmite"),
            List.of(ModToolTiers.SCOURIUM),
            List.of());

    public static final Tier DREADSTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5, // new tier above netherite
                    2500, // not too high (leave room)
                    10f, // small upgrade
                    5f, // slight damage boost
                    13, // decent enchantability
                    ModTags.Blocks.NEEDS_DREADSTEEL_TOOL,
                    () -> Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "dreadsteel"),
            List.of(ModToolTiers.PHASMITE),
            List.of());

    /*public static final Tier QUINTESSITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5,
                    3500, // very high durability
                    9.5f,
                    5.5f,
                    20,
                    ModTags.Blocks.NEEDS_QUINTESSITE_TOOL,
                    () -> Ingredient.of(QuintessiteSet.QUINTESSITE.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "quintessite"),
            List.of(ModToolTiers.HEMOGEM),
            List.of()); */

    public static final Tier LUNARIS = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5, // same as netherite
                    2400, // ⬇ slightly less than before (not insane)
                    9.5f, // ⬇ slower than netherite (heavy feel)
                    4f, // ⬆ strong hits
                    18, // ⬇ lower enchantability (not magic-focused)
                    ModTags.Blocks.NEEDS_LUNARIS_TOOL,
                    () -> Ingredient.of(LunarisSet.LUNARIS.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "lunaris"),
            List.of(ModToolTiers.DREADSTEEL),
            List.of());

    public static final Tier ONYX = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5, // above netherite
                    5500, // high durability (end-tier feel)
                    7f, // fast but not insane
                    5f, // strong hits
                    17, // decent enchantability
                    ModTags.Blocks.NEEDS_ONYX_TOOL,
                    () -> Ingredient.of(OnyxSet.ONYX.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "onyx"),
            List.of(ModToolTiers.LUNARIS),
            List.of());

    public static final Tier COLOSSITE = TierSortingRegistry.registerTier(
            new ForgeTier(
                    6,      // same level as netherite
                    2800,   // durable, but not insane
                    11f,  // fast
                    5.0f,   // strong but not max
                    22,     // high enchantability
                    ModTags.Blocks.NEEDS_COLOSSITE_TOOL,
                    () -> Ingredient.of(ColossiteSet.COLOSSITE_INGOT.get())
            ),
            ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "colossite"),
            List.of(ModToolTiers.ONYX),
            List.of()
    );
}
