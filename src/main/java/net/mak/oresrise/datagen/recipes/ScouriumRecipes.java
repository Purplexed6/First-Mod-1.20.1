package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.ObsidiumSet;
import net.mak.oresrise.item.custom.ScouriumSet;
import net.mak.oresrise.item.custom.SteelSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ScouriumRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":scourium_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":scourium_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ScouriumSet.SCOURIUM_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ScouriumSet.SCOUROUS_SUBSTANCE.get(), 1)
                .requires(ScouriumSet.SCOURIUM.get())
                .requires(Misc.MOLTEN_IRON_INGOT.get())
                .requires(SteelSet.STEEL_INGOT.get())
                .requires(ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy("has_scourous_tear", has(ScouriumSet.SCOUROUS_TEAR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ScouriumSet.SCOURIUM.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ScouriumSet.SCOUROUS_TEAR.get())
                .unlockedBy(getHasName(ScouriumSet.SCOUROUS_TEAR.get()), has(ScouriumSet.SCOUROUS_TEAR.get()))
                .save(pWriter);





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCOURIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ScouriumSet.SCOURIUM_INGOT.get())
                .unlockedBy(getHasName(ScouriumSet.SCOURIUM_INGOT.get()), has(ScouriumSet.SCOURIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ScouriumSet.SCOURIUM_INGOT.get(), 9)
                .requires(ModBlocks.SCOURIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SCOURIUM_BLOCK.get()), has(ModBlocks.SCOURIUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":scourium_ingot_from_block");
    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}