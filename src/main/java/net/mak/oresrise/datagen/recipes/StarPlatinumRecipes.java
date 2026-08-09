package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.RageiteSet;
import net.mak.oresrise.item.custom.StarPlatinumSet;
import net.mak.oresrise.item.custom.PhasmiteSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class StarPlatinumRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, StarPlatinumSet.STAR_BREAKER.get())
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" # ")
                .define('B', ModBlocks.STAR_PLATINUM_BLOCK.get())
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, StarPlatinumSet.STAR_PLATINUM_INGOT.get(), 1)
                .requires(RageiteSet.RAGEITE_INGOT.get())
                .requires(PhasmiteSet.PHASMITE.get())
                .unlockedBy("rageite_ingot", has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);





        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAR_PLATINUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, StarPlatinumSet.STAR_PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.STAR_PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STAR_PLATINUM_BLOCK.get()), has(ModBlocks.STAR_PLATINUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_ingot_from_block");


    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}