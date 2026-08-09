package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.HydroSet;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.SapphireSet;
import net.mak.oresrise.item.custom.SoulSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class SoulForgedRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', SoulSet.SOUL_PRISM.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSet.SOUL_PRISM.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSet.SOUL_PRISM.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSet.SOUL_PRISM.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', SoulSet.SOUL_PRISM.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', SoulSet.SOUL_PRISM.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', SoulSet.SOUL_PRISM.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', SoulSet.SOUL_PRISM.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', SoulSet.SOUL_PRISM.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', SoulSet.SOUL_PRISM.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_PRISM.get()), has(SoulSet.SOUL_PRISM.get()))
                .save(pWriter);










        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSet.SOUL_CRYSTAL.get(), 9)
                .requires(ModBlocks.SOUL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_BLOCK.get()), has(ModBlocks.SOUL_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_crystal_from_block");







        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SoulSet.SOUL_CRYSTAL.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', SoulSet.SOUL_FRAGMENT.get())
                .unlockedBy(getHasName(SoulSet.SOUL_FRAGMENT.get()), has(SoulSet.SOUL_FRAGMENT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSet.SOUL_PRISM.get(), 1)
                .requires(Items.ECHO_SHARD)
                .requires(Items.DIAMOND)
                .requires(Misc.WEEPING_BIT.get())
                .requires(SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy("has_soul_crystal", has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}