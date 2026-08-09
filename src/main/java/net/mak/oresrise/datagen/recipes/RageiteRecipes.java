package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.RageiteSet;
import net.mak.oresrise.item.custom.RoseGoldSet;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import java.util.function.Consumer;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class RageiteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, RageiteSet.RAGEITE_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, RageiteSet.RAGEITE_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, RageiteSet.RAGEITE_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, RageiteSet.RAGEITE_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RageiteSet.RAGEITE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, RageiteSet.RAGEITE_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RageiteSet.RAGEITE_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rageite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RageiteSet.RAGEITE_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rageite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RageiteSet.RAGEITE_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RageiteSet.RAGEITE_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', RageiteSet.RAGEITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RageiteSet.RAGING_COMPOUND.get(), 1)
                .requires(Items.GUNPOWDER)
                .requires(Items.REDSTONE)
                .requires(Misc.MOLTEN_IRON_INGOT.get())
                .requires(RageiteSet.RAGING_FRAGMENT.get())
                .unlockedBy("has_raging_fragment_ingot", has(RageiteSet.RAGING_FRAGMENT.get()))
                .save(pWriter);




        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAGEITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RageiteSet.RAGEITE_INGOT.get())
                .unlockedBy(getHasName(RageiteSet.RAGEITE_INGOT.get()), has(RageiteSet.RAGEITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rageite_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RageiteSet.RAGEITE_INGOT.get(), 9)
                .requires(ModBlocks.RAGEITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAGEITE_BLOCK.get()), has(ModBlocks.RAGEITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rageite_ingot_from_block");
    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}