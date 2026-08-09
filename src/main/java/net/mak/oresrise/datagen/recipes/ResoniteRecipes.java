package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.ResoniteSet;
import net.mak.oresrise.item.custom.VibraniumSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ResoniteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":resonite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":resonite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter);









        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ResoniteSet.RESONITE_INGOT.get(), 3)
                .pattern("VVV")
                .pattern("ASA")
                .pattern("EEE")
                .define('V', VibraniumSet.VIBRANIUM.get())
                .define('A', Items.AMETHYST_SHARD)
                .define('E', Misc.ECHO_STEEL_INGOT.get())
                .define('S', Misc.STARDUST.get())
                .unlockedBy(getHasName(VibraniumSet.VIBRANIUM.get()), has(VibraniumSet.VIBRANIUM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.ECHO_STEEL_INGOT.get(), 1)
                .requires(Items.ECHO_SHARD, 2)
                .requires(Items.DIAMOND)
                .requires(Items.IRON_INGOT)
                .unlockedBy("has_echo_shard", has(Items.ECHO_SHARD))
                .save(pWriter);





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VIBRANIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', VibraniumSet.VIBRANIUM.get())
                .unlockedBy(getHasName(VibraniumSet.VIBRANIUM.get()), has(VibraniumSet.VIBRANIUM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VibraniumSet.VIBRANIUM.get(), 9)
                .requires(ModBlocks.VIBRANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.VIBRANIUM_BLOCK.get()), has(ModBlocks.VIBRANIUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":vibranium_from_block");





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROUGH_VIBRANIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', VibraniumSet.ROUGH_VIBRANIUM.get())
                .unlockedBy(getHasName(VibraniumSet.ROUGH_VIBRANIUM.get()), has(VibraniumSet.ROUGH_VIBRANIUM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VibraniumSet.ROUGH_VIBRANIUM.get(), 9)
                .requires(ModBlocks.ROUGH_VIBRANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROUGH_VIBRANIUM_BLOCK.get()), has(ModBlocks.ROUGH_VIBRANIUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rough_vibranium_from_block");
    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}