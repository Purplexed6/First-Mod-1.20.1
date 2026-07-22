package net.mak.oresrise.worldgen;

import com.mojang.blaze3d.audio.Library;
import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.worldgen.feature.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;


import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
 //   public static final ResourceKey<ConfiguredFeature<?, ?>> JADE_ORE_KEY = registerKey("jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_KEY = registerKey("aquamarine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIBRANIUM_ORE_KEY = registerKey("vibranium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WITHERITE_ORE_KEY = registerKey("witherite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_ORE_KEY = registerKey("soul_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUINTESSITE_ORE_KEY = registerKey("quintessite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEMOGEM_ORE_KEY = registerKey("hemogem_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUXITE_ORE_KEY = registerKey("fluxite_ore");

   // public static final ResourceKey<ConfiguredFeature<?, ?>> OBLIVIONITE_ORE_KEY = registerKey("oblivionite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_ORE_KEY = registerKey("lunaris_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTON_ORE_KEY = registerKey("crypton_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARRITE_ORE_KEY = registerKey("starrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARRITE_PILLAR_KEY = registerKey("starrite_pillar");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest blackstoneReplacables = new BlockMatchTest(Blocks.BLACKSTONE);
        RuleTest soulsoilReplacables = new BlockMatchTest(Blocks.SOUL_SOIL);
        RuleTest smoothBasaltReplaceables = new BlockMatchTest(Blocks.SMOOTH_BASALT);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest obsidianReplaceables = new BlockMatchTest(Blocks.OBSIDIAN);

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        /* List<OreConfiguration.TargetBlockState> overworldJadeOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.JADE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState())); */

        List<OreConfiguration.TargetBlockState> overworldAquamarineOres = List.of(
                OreConfiguration.target(
                        stoneReplaceable,
                        ModBlocks.AQUAMARINE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldVibraniumOres = List.of(
                OreConfiguration.target(
                        deepslateReplaceables,
                        ModBlocks.VIBRANIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldFluxiteOres = List.of(
                OreConfiguration.target(
                        smoothBasaltReplaceables,
                        ModBlocks.FLUXITE_ORE.get().defaultBlockState()));


        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 4, 0.5F));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 4, 0.5F));
     //   register(context, JADE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldJadeOres, 4, 0.5F));
        register(context, AQUAMARINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAquamarineOres, 4, 0.5F));
        register(context, VIBRANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldVibraniumOres, 3));
        register(context, FLUXITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFluxiteOres, 6));

        register(context, SOUL_ORE_KEY, Feature.ORE, new OreConfiguration(soulsoilReplacables,
                ModBlocks.SOUL_ORE.get().defaultBlockState(), 7));
        register(context, QUINTESSITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.QUINTESSITE_ORE.get().defaultBlockState(), 6));
        register(context, HEMOGEM_ORE_KEY, Feature.ORE, new OreConfiguration(blackstoneReplacables,
                ModBlocks.HEMOGEM_ORE.get().defaultBlockState(), 6));

        List<OreConfiguration.TargetBlockState> starriteOres = List.of(
                OreConfiguration.target(
                        obsidianReplaceables,
                        ModBlocks.STARRITE_ORE.get().defaultBlockState()));

        // register(context, OBLIVIONITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
          //       ModBlocks.OBLIVIONITE_ORE.get().defaultBlockState(), 2));
        register(context, LUNARIS_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.LUNARIS_ORE.get().defaultBlockState(), 3));
        register(context, CRYPTON_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.CRYPTON_ORE.get().defaultBlockState(), 2));

        register(context,
                STARRITE_PILLAR_KEY,
                ModFeatures.STARRITE_PILLAR.get(),
                NoneFeatureConfiguration.INSTANCE);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ExampleMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}