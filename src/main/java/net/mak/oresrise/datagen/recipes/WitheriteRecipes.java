package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.WitheriteSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class WitheriteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":witherite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":witherite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);









        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WITHERITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 9)
                .requires(ModBlocks.WITHERITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.WITHERITE_BLOCK.get()), has(ModBlocks.WITHERITE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_WITHERITE_BLOCK.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', WitheriteSet.RAW_WITHERITE.get())
                .unlockedBy(getHasName(WitheriteSet.RAW_WITHERITE.get()), has(WitheriteSet.RAW_WITHERITE.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WitheriteSet.RAW_WITHERITE.get(), 9)
                .requires(ModBlocks.RAW_WITHERITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_WITHERITE_BLOCK.get()), has(ModBlocks.RAW_WITHERITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_witherite_from_block");

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}