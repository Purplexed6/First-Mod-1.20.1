package net.mak.oresrise.datagen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
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
      //  blockWithItem(ModBlocks.OBLIVIONITE_BLOCK);
        blockWithItem(ModBlocks.WITHERITE_BLOCK);
        blockWithItem(ModBlocks.RAW_WITHERITE_BLOCK);
        blockWithItem(ModBlocks.SOUL_BLOCK);
        blockWithItem(ModBlocks.HYDROGEM_BLOCK);
     //   blockWithItem(ModBlocks.JADE_BLOCK);
        //blockWithItem(ModBlocks.QUINTESSITE_BLOCK);
        blockWithItem(ModBlocks.HEMOGEM_BLOCK);
        blockWithItem(ModBlocks.DREADSTEEL_BLOCK);
        blockWithItem(ModBlocks.COLLOSITE_BLOCK);
        blockWithItem(ModBlocks.LUNARIS_BLOCK);
        blockWithItem(ModBlocks.FLUXITE_BLOCK);
        blockWithItem(ModBlocks.VOLTIUM_BLOCK);
        blockWithItem(ModBlocks.ONYX_BLOCK);
        blockWithItem(ModBlocks.PHASMITE_BLOCK);
      //  blockWithItem(ModBlocks.COBALT_BLOCK);
        //blockWithItem(ModBlocks.MALACHITE_BLOCK);
      //  blockWithItem(ModBlocks.RAW_COBALT_BLOCK);
        blockWithItem(ModBlocks.RAGEITE_BLOCK);
        blockWithItem(ModBlocks.SCOURIUM_BLOCK);
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.KEYOLITE_BLOCK);
        blockWithItem(ModBlocks.OBSIDIUM_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
      //  blockWithItem(ModBlocks.OBLIVIONITE_ORE);
        blockWithItem(ModBlocks.SOUL_ORE);
        blockWithItem(ModBlocks.HYDRIC_ORE);
     //   blockWithItem(ModBlocks.JADE_ORE);
     //   blockWithItem(ModBlocks.DEEPSLATE_JADE_ORE);
       // blockWithItem(ModBlocks.QUINTESSITE_ORE);
        blockWithItem(ModBlocks.SANGUINE_ORE);
        blockWithItem(ModBlocks.LUNARIS_ORE);
        blockWithItem(ModBlocks.COLOSSAL_ORE);
        blockWithItem(ModBlocks.PHASMIC_ORE);
        blockWithItem(ModBlocks.FLUXITE_ORE);
        blockWithItem(ModBlocks.ONYX_ORE);
        //blockWithItem(ModBlocks.MALACHITE_ORE);
      //  blockWithItem(ModBlocks.DEEPSLATE_MALACHITE_ORE);
        blockWithItem(ModBlocks.RAGING_ORE);
   //     blockWithItem(ModBlocks.COBALT_ORE);
        blockWithItem(ModBlocks.SCOUROUS_ORE);
        blockWithItem(ModBlocks.WAILING_ORE);
        blockWithItem(ModBlocks.STARDUST_ORE);

        blockWithItem(ModBlocks.RUGITE_BLOCK);
        blockWithItem(ModBlocks.POLISHED_RUGITE);
        blockWithItem(ModBlocks.RUGITE_BRICKS);

        blockWithItem(ModBlocks.SOULSTONE_BLOCK);
        blockWithItem(ModBlocks.POLISHED_SOULSTONE);
        blockWithItem(ModBlocks.SOULSTONE_BRICKS);
        blockWithItem(ModBlocks.SOUL_MAGMA);
        blockWithItem(ModBlocks.SOUL_GRAVEL);
        blockWithItem(ModBlocks.SOULSTONE_QUARTZ_ORE);

        blockWithItem(ModBlocks.ASTRALITE_BLOCK);
        blockWithItem(ModBlocks.POLISHED_ASTRALITE);
        blockWithItem(ModBlocks.ASTRALITE_BRICKS);

        blockWithItem(ModBlocks.ECHOROCK_BLOCK);
        blockWithItem(ModBlocks.POLISHED_ECHOROCK);
        blockWithItem(ModBlocks.ECHOROCK_BRICKS);

        blockWithItem(ModBlocks.VOIDSTONE_BLOCK);
        blockWithItem(ModBlocks.POLISHED_VOIDSTONE);
        blockWithItem(ModBlocks.VOIDSTONE_BRICKS);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ExampleMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}