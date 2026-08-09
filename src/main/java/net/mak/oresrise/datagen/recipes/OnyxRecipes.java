package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.OnyxSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class OnyxRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, OnyxSet.ONYX_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, OnyxSet.ONYX_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, OnyxSet.ONYX_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, OnyxSet.ONYX_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', OnyxSet.ONYX.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, OnyxSet.ONYX_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', OnyxSet.ONYX.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', OnyxSet.ONYX.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":onyx_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', OnyxSet.ONYX.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":onyx_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', OnyxSet.ONYX.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', OnyxSet.ONYX.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);







        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ONYX_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OnyxSet.ONYX.get(), 9)
                .requires(ModBlocks.ONYX_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ONYX_BLOCK.get()), has(ModBlocks.ONYX_BLOCK.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}