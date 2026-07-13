package net.mak.oresrise.worldgen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> ALEXANDRITE_ORE_PLACED_KEY = registerKey("alexandrite_ore_placed");
    public static final ResourceKey<PlacedFeature> SUGILITE_ORE_PLACED_KEY = registerKey("sugilite_ore_placed");

    public static final ResourceKey<PlacedFeature> WITHERITE_ORE_PLACED_KEY = registerKey("witherite_ore_placed");
    public static final ResourceKey<PlacedFeature> SOUL_ORE_PLACED_KEY = registerKey("soul_ore_placed");
    public static final ResourceKey<PlacedFeature> QUINTESSITE_ORE_PLACED_KEY = registerKey("quintessite_ore_placed");
    public static final ResourceKey<PlacedFeature> HEMOGEM_ORE_PLACED_KEY = registerKey("hemogem_ore_placed");

    public static final ResourceKey<PlacedFeature> OBLIVIONITE_ORE_PLACED_KEY = registerKey("oblivionite_ore_placed");
    public static final ResourceKey<PlacedFeature> CRYPTON_ORE_PLACED_KEY = registerKey("crypton_ore_placed");
    public static final ResourceKey<PlacedFeature> LUNARIS_ORE_PLACED_KEY = registerKey("lunaris_ore_placed");
    // public static final ResourceKey<PlacedFeature> STARRITE_ORE_PLACED_KEY = registerKey("starrite_ore_placed");

    public static final ResourceKey<PlacedFeature> AMBERWOOD_PLACED_KEY = registerKey("amberwood_placed");
    public static final ResourceKey<PlacedFeature> ASTRALITE_SURFACE_PLACED_KEY = registerKey("astralite_surface_placed");
    public static final ResourceKey<PlacedFeature> UMBROCK_FILLER_PLACED_KEY = registerKey("umbrock_filler_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-100), VerticalAnchor.absolute(16))));
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.rareOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-100), VerticalAnchor.absolute(16))));
        register(context, ALEXANDRITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALEXANDRITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-100), VerticalAnchor.absolute(16))));
        register(context, SUGILITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUGILITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-100), VerticalAnchor.absolute(100))));


        register(context, WITHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WITHERITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));
        register(context, SOUL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));
        register(context, QUINTESSITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUINTESSITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));
        register(context, HEMOGEM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HEMOGEM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));


        register(context, OBLIVIONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OBLIVIONITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(36))));
        register(context, LUNARIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUNARIS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        register(context, CRYPTON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYPTON_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));


        register(context, AMBERWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMBERWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.AMBERWOOD_SAPLING.get()));

        register(context, ASTRALITE_SURFACE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ASTRALITE_SURFACE_KEY),
                List.of(
                        CountPlacement.of(64), // how often
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ));

        register(context, UMBROCK_FILLER_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.UMBROCK_FILLER_KEY),
                List.of(
                        // Crank this up. 256 ensures a "blob" is attempted for almost every x/z coordinate.
                        CountPlacement.of(256),
                        InSquarePlacement.spread(),
                        PlacementUtils.FULL_RANGE,
                        BiomeFilter.biome()
                ));
    }



    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ExampleMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}