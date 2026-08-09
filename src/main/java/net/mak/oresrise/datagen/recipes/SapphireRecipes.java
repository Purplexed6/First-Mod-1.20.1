package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.SapphireSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class SapphireRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":sapphire_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":sapphire_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);








        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SapphireSet.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROUGH_SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SapphireSet.ROUGH_SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.ROUGH_SAPPHIRE.get()), has(SapphireSet.ROUGH_SAPPHIRE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SapphireSet.ROUGH_SAPPHIRE.get(), 9)
                .requires(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get()), has(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}