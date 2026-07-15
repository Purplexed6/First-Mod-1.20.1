package net.mak.oresrise.datagen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.ROUGH_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.ROUGH_RUBY_BLOCK);
        blockWithItem(ModBlocks.ROSITE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GOLD_BLOCK);
        blockWithItem(ModBlocks.OBLIVIONITE_BLOCK);
        blockWithItem(ModBlocks.WITHERITE_BLOCK);
        blockWithItem(ModBlocks.RAW_WITHERITE_BLOCK);
        blockWithItem(ModBlocks.SOUL_BLOCK);
        blockWithItem(ModBlocks.SUGILITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.QUINTESSITE_BLOCK);
        blockWithItem(ModBlocks.HEMOGEM_BLOCK);
        blockWithItem(ModBlocks.SOUL_STEEL_BLOCK);
        blockWithItem(ModBlocks.CRYPTON_BLOCK);
        blockWithItem(ModBlocks.LUNARIS_BLOCK);
        blockWithItem(ModBlocks.FLUXITE_BLOCK);
        blockWithItem(ModBlocks.ONYX_BLOCK);
        blockWithItem(ModBlocks.STARRITE_BLOCK);
        blockWithItem(ModBlocks.COBALT_BLOCK);
        blockWithItem(ModBlocks.MALACHITE_BLOCK);
        blockWithItem(ModBlocks.RAW_COBALT_BLOCK);
        blockWithItem(ModBlocks.PLATINUM_BLOCK);
        blockWithItem(ModBlocks.RAW_PLATINUM_BLOCK);
        blockWithItem(ModBlocks.STAR_PLATINUM_BLOCK);
        blockWithItem(ModBlocks.ROUGH_VIBRANIUM_BLOCK);
        blockWithItem(ModBlocks.VIBRANIUM_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.OBLIVIONITE_ORE);
        blockWithItem(ModBlocks.WITHERITE_ORE);
        blockWithItem(ModBlocks.SOUL_ORE);
        blockWithItem(ModBlocks.SUGILITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SUGILITE_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.QUINTESSITE_ORE);
        blockWithItem(ModBlocks.HEMOGEM_ORE);
        blockWithItem(ModBlocks.LUNARIS_ORE);
        blockWithItem(ModBlocks.CRYPTON_ORE);
        blockWithItem(ModBlocks.STARRITE_ORE);
        blockWithItem(ModBlocks.FLUXITE_ORE);
        blockWithItem(ModBlocks.ONYX_ORE);
        blockWithItem(ModBlocks.MALACHITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MALACHITE_ORE);
        blockWithItem(ModBlocks.PLATINUM_ORE);
        blockWithItem(ModBlocks.COBALT_ORE);
        blockWithItem(ModBlocks.VIBRANIUM_ORE);

        blockWithItem(ModBlocks.ASTRALITE);
        blockWithItem(ModBlocks.UMBROCK);
        blockWithItem(ModBlocks.MOD_PORTAL);

        makeStrawberryCrop(
                (CropBlock) ModBlocks.STRAWBERRY_CROP.get(),
                "strawberry_stage",
                "strawberry_stage"
        );
        blockWithItem(ModBlocks.SOUND_BLOCK);

        logBlock(((RotatedPillarBlock) ModBlocks.AMBERWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.AMBERWOOD_WOOD.get()), blockTexture(ModBlocks.AMBERWOOD_LOG.get()), blockTexture(ModBlocks.AMBERWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_AMBERWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_AMBERWOOD_LOG.get()),
                new ResourceLocation(ExampleMod.MOD_ID, "block/stripped_amberwood_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_AMBERWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_AMBERWOOD_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_AMBERWOOD_LOG.get()));

        blockItem(ModBlocks.AMBERWOOD_LOG);
        blockItem(ModBlocks.AMBERWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_AMBERWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_AMBERWOOD_WOOD);
        blockWithItem(ModBlocks.AMBERWOOD_PLANKS);
        simpleBlockWithItem(ModBlocks.AMBERWOOD_LEAVES.get(),
                models().singleTexture("amberwood_leaves",
                        new ResourceLocation("minecraft", "block/leaves"), // Uses vanilla leaves parent
                        "all", modLoc("block/amberwood_leaves")));
        saplingBlock(ModBlocks.AMBERWOOD_SAPLING);


        logBlock((RotatedPillarBlock) ModBlocks.PALESLATE.get());
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ExampleMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function =
                state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block,
                                               String modelName, String textureName) {

        return new ConfiguredModel[]{
                new ConfiguredModel(
                        models().crop(
                                modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                                modLoc("block/" + textureName +
                                        state.getValue(((StrawberryCropBlock) block).getAgeProperty()))
                        ).renderType("cutout")
                )
        };
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}