package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.KeyoliteSet;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.ObsidiumSet;
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

public class KeyoliteRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_HELMET.get())
                .pattern("OSO")
                .pattern("S S")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('O', ObsidiumSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SOS")
                .pattern("OSO")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('O', ObsidiumSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("O O")
                .pattern("S S")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('O', ObsidiumSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_BOOTS.get())
                .pattern("S S")
                .pattern("O O")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('O', ObsidiumSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":keyolite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":keyolite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KeyoliteSet.ROSAL_COMPOUND.get(), 2)
                .requires(RositeSet.ROSITE_INGOT.get(), 2)
                .requires(Items.ENDER_PEARL)
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_rosite_ingot", has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KeyoliteSet.KEYOLITE_INGOT.get())
                .requires(KeyoliteSet.KEYOLITE_NUGGET.get(), 9)
                .unlockedBy("keyolite_nugget", has(KeyoliteSet.KEYOLITE_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "keyolite_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KeyoliteSet.KEYOLITE_NUGGET.get(), 9)
                .requires(KeyoliteSet.KEYOLITE_INGOT.get())
                .unlockedBy("has_keyolite_ingot", has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KEYOLITE_BLOCK.get())
                .requires(KeyoliteSet.KEYOLITE_INGOT.get(), 9)
                .unlockedBy("keyolite_ingot", has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KeyoliteSet.KEYOLITE_INGOT.get(), 9)
                .requires(ModBlocks.KEYOLITE_BLOCK.get())
                .unlockedBy("has_keyolite_block", has(ModBlocks.KEYOLITE_BLOCK.get()))
                .save(pWriter, new ResourceLocation("oresrise", "keyolite_from_block"));

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}