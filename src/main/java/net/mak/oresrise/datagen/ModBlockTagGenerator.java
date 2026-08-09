package net.mak.oresrise.datagen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.ORE_DETECTOR_VALUABLES)
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.RUBY_ORE.get());

        this.tag(Tags.Blocks.ORES)
                .add(
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                        // ModBlocks.JADE_ORE.get(),
                        //  ModBlocks.DEEPSLATE_JADE_ORE.get(),
                        ModBlocks.HYDRIC_ORE.get(),
                    //    ModBlocks.MALACHITE_ORE.get(),
                      //  ModBlocks.DEEPSLATE_MALACHITE_ORE.get(),
                        //     ModBlocks.COBALT_ORE.get(),
                        ModBlocks.RAGING_ORE.get(),
                        ModBlocks.PHASMIC_ORE.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.SOUL_ORE.get(),
                        ModBlocks.FLUXITE_ORE.get(),
                        ModBlocks.SANGUINE_ORE.get(),
                        //   ModBlocks.QUINTESSITE_ORE.get(),
                        ModBlocks.ONYX_ORE.get(),
                        ModBlocks.CRYPTON_ORE.get(),
                        // ModBlocks.OBLIVIONITE_ORE.get());
                        ModBlocks.LUNARIS_ORE.get());


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.ROUGH_SAPPHIRE_BLOCK.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),

                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.ROUGH_RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),

                        ModBlocks.ROSITE_BLOCK.get(),

                        ModBlocks.OBSIDIUM_BLOCK.get(),

                       // ModBlocks.JADE_ORE.get(),
                      //  ModBlocks.DEEPSLATE_JADE_ORE.get(),

                        ModBlocks.HYDRIC_ORE.get(),
                        ModBlocks.HYDROGEM_BLOCK.get(),

                    //    ModBlocks.MALACHITE_ORE.get(),
                      //  ModBlocks.DEEPSLATE_MALACHITE_ORE.get(),

                    //    ModBlocks.COBALT_BLOCK.get(),
                    //    ModBlocks.RAW_COBALT_BLOCK.get(),
                   //     ModBlocks.COBALT_ORE.get(),

                        ModBlocks.RAGEITE_BLOCK.get(),
                        ModBlocks.RAGING_ORE.get(),

                        ModBlocks.STAR_PLATINUM_BLOCK.get(),

                        ModBlocks.PHASMITE_BLOCK.get(),
                        ModBlocks.PHASMIC_ORE.get(),

                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.ROUGH_VIBRANIUM_BLOCK.get(),





                        ModBlocks.WAILING_ORE.get(),
                        ModBlocks.STARDUST_ORE.get(),
                        ModBlocks.SOUL_ORE.get(),
                        ModBlocks.SOUL_BLOCK.get(),

                        ModBlocks.DREADSTEEL_BLOCK.get(),

                        ModBlocks.FLUXITE_ORE.get(),
                        ModBlocks.FLUXITE_BLOCK.get(),
                        ModBlocks.VOLTIUM_BLOCK.get(),

                        ModBlocks.WITHERITE_BLOCK.get(),
                        ModBlocks.RAW_WITHERITE_BLOCK.get(),

                        ModBlocks.SANGUINE_ORE.get(),
                        ModBlocks.HEMOGEM_BLOCK.get(),

                     //   ModBlocks.QUINTESSITE_ORE.get(),
                     //   ModBlocks.QUINTESSITE_BLOCK.get(),



                        ModBlocks.ONYX_BLOCK.get(),
                        ModBlocks.ONYX_ORE.get(),

                        ModBlocks.CRYPTON_BLOCK.get(),
                        ModBlocks.CRYPTON_ORE.get(),

                        ModBlocks.LUNARIS_BLOCK.get(),
                        ModBlocks.LUNARIS_ORE.get());

                     //   ModBlocks.OBLIVIONITE_BLOCK.get(),
                     //   ModBlocks.OBLIVIONITE_ORE.get());



        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.ROUGH_SAPPHIRE_BLOCK.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),

                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.ROUGH_RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),

                        ModBlocks.ROSITE_BLOCK.get(),

                    //    ModBlocks.JADE_ORE.get(),
                    //    ModBlocks.DEEPSLATE_JADE_ORE.get(),

                        ModBlocks.HYDRIC_ORE.get(),

                        ModBlocks.WAILING_ORE.get(),

                        //ModBlocks.MALACHITE_ORE.get(),
                      //  ModBlocks.DEEPSLATE_MALACHITE_ORE.get(),

                        //ModBlocks.COBALT_BLOCK.get(),
                     //   ModBlocks.RAW_COBALT_BLOCK.get(),
                     //   ModBlocks.COBALT_ORE.get(),

                        ModBlocks.RAGEITE_BLOCK.get(),
                        ModBlocks.RAGING_ORE.get(),

                        ModBlocks.PHASMITE_BLOCK.get(),
                        ModBlocks.PHASMIC_ORE.get());



        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FLUXITE_ORE.get(),
                        ModBlocks.FLUXITE_BLOCK.get(),
                        ModBlocks.VOLTIUM_BLOCK.get(),

                        ModBlocks.HYDRIC_ORE.get(),
                        ModBlocks.HYDROGEM_BLOCK.get(),

                        ModBlocks.SANGUINE_ORE.get(),
                        ModBlocks.HEMOGEM_BLOCK.get());



        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.SOUL_ORE.get(),
                        ModBlocks.DREADSTEEL_BLOCK.get(),
                        ModBlocks.SOUL_BLOCK.get(),

                        ModBlocks.WITHERITE_BLOCK.get(),
                        ModBlocks.RAW_WITHERITE_BLOCK.get(),

                        ModBlocks.STARDUST_ORE.get(),

                      //  ModBlocks.QUINTESSITE_ORE.get(),
                       // ModBlocks.QUINTESSITE_BLOCK.get(),

                        ModBlocks.STAR_PLATINUM_BLOCK.get());



        this.tag(ModTags.Blocks.NEEDS_DREADSTEEL_TOOL)
                .add(ModBlocks.ONYX_BLOCK.get(),
                        ModBlocks.ONYX_ORE.get(),

                        ModBlocks.CRYPTON_BLOCK.get(),
                        ModBlocks.CRYPTON_ORE.get(),

                        ModBlocks.LUNARIS_BLOCK.get(),
                        ModBlocks.LUNARIS_ORE.get());

                 //       ModBlocks.OBLIVIONITE_BLOCK.get(),
                  //      ModBlocks.OBLIVIONITE_ORE.get());








    }
}