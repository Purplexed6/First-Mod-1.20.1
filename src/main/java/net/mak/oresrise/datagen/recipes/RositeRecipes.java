package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.RositeSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RositeRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get(), 1)
                .requires(Items.IRON_INGOT, 1)
                .requires(Items.REDSTONE, 1)
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(pWriter);








        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get())
                .requires(RositeSet.ROSITE_NUGGET.get(), 9)
                .unlockedBy("rosite_nugget", has(RositeSet.ROSITE_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "rosite_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_NUGGET.get(), 9)
                .requires(RositeSet.ROSITE_INGOT.get())
                .unlockedBy("has_rosite_ingot", has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);






        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get(), 9)
                .requires(ModBlocks.ROSITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROSITE_BLOCK.get()), has(ModBlocks.ROSITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_from_block");

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}