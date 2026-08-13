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

public class ColossiteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ColossiteSet.COLOSSITE_HELMET.get())
                .pattern("PAP")
                .pattern("P P")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('A', SoulSet.SOUL_PRISM.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ColossiteSet.COLOSSITE_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ColossiteSet.COLOSSITE_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ColossiteSet.COLOSSITE_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ColossiteSet.COLOSSITE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ColossiteSet.COLOSSITE_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ColossiteSet.COLOSSITE_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":colossite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ColossiteSet.COLOSSITE_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":colossite_axe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ColossiteSet.COLOSSITE_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ColossiteSet.COLOSSITE_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', ColossiteSet.COLOSSITE_INGOT.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ColossiteSet.COLOSSAL_COMPOUND.get(), 2)
                .requires(ColossiteSet.COLOSSAL_STAR.get())
                .requires(Misc.MOLTEN_NETHERITE_INGOT.get())
                .requires(Misc.STARDUST.get())
                .requires(Items.ECHO_SHARD)
                .unlockedBy("has_colossal_star", has(ColossiteSet.COLOSSAL_STAR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ColossiteSet.COLOSSAL_STAR.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ColossiteSet.COLOSSAL_ROD.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSAL_ROD.get()), has(ColossiteSet.COLOSSAL_ROD.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLLOSITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ColossiteSet.COLOSSITE_INGOT.get())
                .unlockedBy(getHasName(ColossiteSet.COLOSSITE_INGOT.get()), has(ColossiteSet.COLOSSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":colossite_block_from_item");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ColossiteSet.COLOSSITE_INGOT.get(), 9)
                .requires(ModBlocks.COLLOSITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COLLOSITE_BLOCK.get()), has(ModBlocks.COLLOSITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":colossite_from_block");

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}