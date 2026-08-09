package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.HemoSet;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.RoseGoldSet;
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

public class HemogemRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', HemoSet.HEMOGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', HemoSet.HEMOGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', HemoSet.HEMOGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', HemoSet.HEMOGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', HemoSet.HEMOGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', HemoSet.HEMOGEM.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HemoSet.HEMOGEM.get(), 1)
                .requires(Items.NETHER_WART)
                .requires(RubySet.RUBY.get())
                .requires(Misc.WEEPING_BIT.get())
                .requires(HemoSet.SANGUINE_FRAGMENT.get())
                .unlockedBy("has_sanguine_fragment", has(HemoSet.SANGUINE_FRAGMENT.get()))
                .save(pWriter);






        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEMOGEM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HemoSet.HEMOGEM.get(), 9)
                .requires(ModBlocks.HEMOGEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMOGEM_BLOCK.get()), has(ModBlocks.HEMOGEM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_from_block");


    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}