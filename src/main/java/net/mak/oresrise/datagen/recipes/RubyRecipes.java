package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.RubySet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RubyRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":ruby_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":ruby_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);








        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubySet.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROUGH_RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RubySet.ROUGH_RUBY.get())
                .unlockedBy(getHasName(RubySet.ROUGH_RUBY.get()), has(RubySet.ROUGH_RUBY.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubySet.ROUGH_RUBY.get(), 9)
                .requires(ModBlocks.ROUGH_RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROUGH_RUBY_BLOCK.get()), has(ModBlocks.ROUGH_RUBY_BLOCK.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}