package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.custom.EmeraldSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class EmeraldRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EmeraldSet.EMERALD_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EmeraldSet.EMERALD_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EmeraldSet.EMERALD_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EmeraldSet.EMERALD_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', Items.EMERALD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EmeraldSet.EMERALD_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', Items.EMERALD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', Items.EMERALD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter, ExampleMod.MOD_ID + ":emerald_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', Items.EMERALD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter, ExampleMod.MOD_ID + ":emerald_axe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', Items.EMERALD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', Items.EMERALD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}