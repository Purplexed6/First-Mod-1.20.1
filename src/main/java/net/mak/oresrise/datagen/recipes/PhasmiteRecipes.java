package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.PhasmiteSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class PhasmiteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', PhasmiteSet.PHASMITE.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PhasmiteSet.PHASMITE.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', PhasmiteSet.PHASMITE.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', PhasmiteSet.PHASMITE.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":phasmite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":phasmite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.PHASMITE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);





        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PHASMITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PhasmiteSet.PHASMITE.get())
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PhasmiteSet.PHASMITE.get(), 9)
                .requires(ModBlocks.PHASMITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PHASMITE_BLOCK.get()), has(ModBlocks.PHASMITE_BLOCK.get()))
                .save(pWriter);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PhasmiteSet.PHASMITE.get(), 1)
                .requires(PhasmiteSet.PHASMIC_SHARD.get())
                .requires(Misc.WEEPING_BIT.get())
                .requires(Items.PHANTOM_MEMBRANE)
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_phasmic_fragment", has(PhasmiteSet.PHASMIC_SHARD.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":phasmite_craft");




        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PhasmiteSet.STAR_STAFF.get())
                .pattern("ASA")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', PhasmiteSet.PHASMITE.get())
                .define('#', Misc.NETHERITE_STICK.get())
                .define('A', Items.SPECTRAL_ARROW)
                .unlockedBy(getHasName(PhasmiteSet.PHASMITE.get()), has(PhasmiteSet.PHASMITE.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}