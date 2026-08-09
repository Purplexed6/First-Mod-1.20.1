package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.ObsidiumSet;
import net.mak.oresrise.item.custom.Misc;
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

public class ObsidiumRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ObsidiumSet.OBSIDIUM_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ObsidiumSet.OBSIDIUM_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ObsidiumSet.OBSIDIUM_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ObsidiumSet.OBSIDIUM_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_PICKAXE.get())
                .pattern("PPP")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ObsidiumSet.OBSIDIUM_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" # ")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_AXE.get())
                .pattern("PP ")
                .pattern("P# ")
                .pattern(" # ")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidium_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_AXE.get())
                .pattern(" PP")
                .pattern(" #P")
                .pattern(" # ")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidium_axe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_SHOVEL.get())
                .pattern(" P ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_HOE.get())
                .pattern("PP ")
                .pattern(" # ")
                .pattern(" # ")
                .define('P', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIUM_INGOT.get()), has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ObsidiumSet.OBSIDIAN_ALLOY.get(), 2)
                .requires(SteelSet.STEEL_INGOT.get())
                .requires(ObsidiumSet.OBSIDIAN_SHARD.get(), 2)
                .requires(Items.DIAMOND)
                .unlockedBy("has_steel_ingot", has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ObsidiumSet.OBSIDIUM_INGOT.get())
                .requires(ObsidiumSet.OBSIDIUM_NUGGET.get(), 9)
                .unlockedBy("obsidium_nugget", has(ObsidiumSet.OBSIDIUM_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "obsidium_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ObsidiumSet.OBSIDIUM_NUGGET.get(), 9)
                .requires(ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy("has_obsidium_ingot", has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.OBSIDIUM_BLOCK.get())
                .requires(ObsidiumSet.OBSIDIUM_INGOT.get(), 9)
                .unlockedBy("obsidium_ingot", has(ObsidiumSet.OBSIDIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ObsidiumSet.OBSIDIUM_INGOT.get(), 9)
                .requires(ModBlocks.OBSIDIUM_BLOCK.get())
                .unlockedBy("has_obsidium_block", has(ModBlocks.OBSIDIUM_BLOCK.get()))
                .save(pWriter, new ResourceLocation("oresrise", "obsidium_from_block"));

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}