package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.SteelSet;
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

public class SteelRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_PICKAXE.get())
                .pattern("AAA")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_AXE.get())
                .pattern("AA ")
                .pattern("A# ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":steel_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_AXE.get())
                .pattern(" AA")
                .pattern(" #A")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":steel_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_HOE.get())
                .pattern("AA ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_SHOVEL.get())
                .pattern(" A ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);








        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_INGOT.get(), 2)
                .requires(Items.IRON_INGOT, 2)
                .requires(Items.COAL, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_INGOT.get())
                .requires(SteelSet.STEEL_NUGGET.get(), 9)
                .unlockedBy("steel_nugget", has(SteelSet.STEEL_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "steel_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_NUGGET.get(), 9)
                .requires(SteelSet.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .requires(SteelSet.STEEL_INGOT.get(), 9)
                .unlockedBy("steel_ingot", has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter, new ResourceLocation("oresrise", "steel_from_block"));
    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}