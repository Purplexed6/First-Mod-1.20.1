package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.SteelSet;
import net.mak.oresrise.item.custom.VoltiumSet;
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

public class VoltiumRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":voltium_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":voltium_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.ELECTRIC_MATTER.get(), 2)
                .requires(SteelSet.STEEL_INGOT.get(), 2)
                .requires(VoltiumSet.FLUXITE.get())
                .requires(Items.QUARTZ)
                .unlockedBy("has_fluxite", has(VoltiumSet.FLUXITE.get()))
                .save(pWriter);







        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.VOLTIUM_INGOT.get())
                .requires(VoltiumSet.VOLTIUM_NUGGET.get(), 9)
                .unlockedBy("voltium_nugget", has(VoltiumSet.VOLTIUM_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "voltium_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.VOLTIUM_NUGGET.get(), 9)
                .requires(VoltiumSet.VOLTIUM_INGOT.get())
                .unlockedBy("has_voltium_ingot", has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.FLUXITE_ARROW.get())
                .pattern("S")
                .pattern("#")
                .pattern("F")
                .define('S', VoltiumSet.FLUXITE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .define('F', Items.FEATHER)
                .unlockedBy(getHasName(VoltiumSet.FLUXITE.get()), has(VoltiumSet.FLUXITE.get()))
                .save(pWriter);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.VOLTIUM_BLOCK.get())
                .requires(VoltiumSet.VOLTIUM_INGOT.get(), 9)
                .unlockedBy("voltium_ingot", has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.VOLTIUM_INGOT.get(), 9)
                .requires(ModBlocks.VOLTIUM_BLOCK.get())
                .unlockedBy("has_voltium_block", has(ModBlocks.VOLTIUM_BLOCK.get()))
                .save(pWriter, new ResourceLocation("oresrise", "voltium_from_block"));
    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}