package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.custom.AmethystSet;
import net.mak.oresrise.item.custom.RageiteSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class AmethystRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AmethystSet.AMETHYST_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AmethystSet.AMETHYST_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AmethystSet.AMETHYST_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AmethystSet.AMETHYST_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', Items.AMETHYST_SHARD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AmethystSet.AMETHYST_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', Items.AMETHYST_SHARD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', Items.AMETHYST_SHARD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter, ExampleMod.MOD_ID + ":amethyst_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', Items.AMETHYST_SHARD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter, ExampleMod.MOD_ID + ":amethyst_axe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', Items.AMETHYST_SHARD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', Items.AMETHYST_SHARD)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}