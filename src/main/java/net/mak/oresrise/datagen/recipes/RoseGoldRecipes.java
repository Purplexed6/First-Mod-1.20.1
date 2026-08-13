package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.RoseGoldSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RoseGoldRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_AXE.get())
                .pattern("AA ")
                .pattern("A# ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_AXE.get())
                .pattern(" AA")
                .pattern(" #A")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_HOE.get())
                .pattern("AA ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RoseGoldSet.ROSE_GOLD_INGOT.get(), 1)
                .requires(Items.GOLD_INGOT)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(pWriter);





        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RoseGoldSet.ROSE_GOLD_INGOT.get(), 9)
                .requires(ModBlocks.ROSE_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROSE_GOLD_BLOCK.get()), has(ModBlocks.ROSE_GOLD_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_ingot_from_block");

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}