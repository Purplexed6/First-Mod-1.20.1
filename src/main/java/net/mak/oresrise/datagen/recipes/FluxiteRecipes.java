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

public class FluxiteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUXITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', VoltiumSet.FLUXITE.get())
                .unlockedBy(getHasName(VoltiumSet.FLUXITE.get()), has(VoltiumSet.FLUXITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.FLUXITE.get(), 9)
                .requires(ModBlocks.FLUXITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FLUXITE_BLOCK.get()), has(ModBlocks.FLUXITE_BLOCK.get()))
                .save(pWriter);






        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.FLUXITE_STAFF.get())
                .pattern("S")
                .pattern("#")
                .pattern("#")
                .define('S', VoltiumSet.FLUXITE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.FLUXITE.get()), has(VoltiumSet.FLUXITE.get()))
                .save(pWriter);
    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}