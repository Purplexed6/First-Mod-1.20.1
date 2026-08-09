package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.*;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class HydrogemRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', HydroSet.HYDROGEM.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HydroSet.HYDROGEM.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', HydroSet.HYDROGEM.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', HydroSet.HYDROGEM.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', HydroSet.HYDROGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', HydroSet.HYDROGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', HydroSet.HYDROGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hydrogem_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', HydroSet.HYDROGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hydrogem_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', HydroSet.HYDROGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HydroSet.HYDROGEM_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', HydroSet.HYDROGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HydroSet.HYDROGEM.get(), 1)
                .requires(Items.KELP)
                .requires(Items.PRISMARINE_SHARD)
                .requires(SapphireSet.SAPPHIRE.get())
                .requires(HydroSet.HYDRIC_FRAGMENT.get())
                .unlockedBy("has_hydric_fragment", has(HydroSet.HYDRIC_FRAGMENT.get()))
                .save(pWriter);





        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HYDROGEM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HydroSet.HYDROGEM.get())
                .unlockedBy(getHasName(HydroSet.HYDROGEM.get()), has(HydroSet.HYDROGEM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HydroSet.HYDROGEM.get(), 9)
                .requires(ModBlocks.HYDROGEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HYDROGEM_BLOCK.get()), has(ModBlocks.HYDROGEM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hydrogem_from_block");


    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}