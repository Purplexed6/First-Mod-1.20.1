package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.CryptonSet;
import net.mak.oresrise.item.custom.Misc;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class CryptonRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CryptonSet.CRYPTON_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', CryptonSet.CRYPTON.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CryptonSet.CRYPTON_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', CryptonSet.CRYPTON.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CryptonSet.CRYPTON_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', CryptonSet.CRYPTON.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CryptonSet.CRYPTON_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', CryptonSet.CRYPTON.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CryptonSet.CRYPTON_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', CryptonSet.CRYPTON.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CryptonSet.CRYPTON_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', CryptonSet.CRYPTON.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CryptonSet.CRYPTON_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', CryptonSet.CRYPTON.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CryptonSet.CRYPTON_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', CryptonSet.CRYPTON.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_axe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CryptonSet.CRYPTON_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', CryptonSet.CRYPTON.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CryptonSet.CRYPTON_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', CryptonSet.CRYPTON.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CryptonSet.CRYPTON.get(), 2)
                .pattern("ASA")
                .pattern("ECE")
                .pattern("ASA")
                .define('A', Misc.STARDUST.get())
                .define('S', CryptonSet.CRYPTON_SHARD.get())
                .define('E', Items.ECHO_SHARD)
                .define('C', Items.ENDER_PEARL)
                .unlockedBy(getHasName(CryptonSet.CRYPTON_SHARD.get()), has(CryptonSet.CRYPTON_SHARD.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_craft");




        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYPTON_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CryptonSet.CRYPTON.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_block_from_item");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CryptonSet.CRYPTON.get(), 9)
                .requires(ModBlocks.CRYPTON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CRYPTON_BLOCK.get()), has(ModBlocks.CRYPTON_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_from_block");

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}