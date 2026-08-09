package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.ObsidiumSet;
import net.mak.oresrise.item.custom.SapphireSet;
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

public class MiscRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GHAST_TEAR)
                .pattern("SS")
                .pattern("SS")
                .define('S', Misc.WEEPING_BIT.get())
                .unlockedBy(getHasName(Misc.WEEPING_BIT.get()), has(Misc.WEEPING_BIT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.IRON_STICK.get(), 2)
                .pattern("S")
                .pattern("S")
                .define('S', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.DIAMOND_STICK.get(), 2)
                .pattern("S")
                .pattern("S")
                .define('S', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.OBSIDIAN_STICK.get(), 2)
                .pattern("  S")
                .pattern(" S ")
                .pattern("S  ")
                .define('S', ObsidiumSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIAN_SHARD.get()), has(ObsidiumSet.OBSIDIAN_SHARD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.NETHERITE_MESH.get(), 1)
                .requires(Items.NETHERITE_SCRAP, 2)
                .requires(Items.GOLD_INGOT, 2)
                .unlockedBy("has_netherite_scrap", has(Items.NETHERITE_SCRAP))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.NETHERITE_NUGGET.get(), 9)
                .requires(Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(pWriter, new ResourceLocation("oresrise", "netherite_nugget_from_ingot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.NETHERITE_NUGGET.get(), 4)
                .requires(Misc.NETHERITE_MESH.get())
                .unlockedBy(getHasName(Misc.NETHERITE_MESH.get()), has(Misc.NETHERITE_MESH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "netherite_nugget_from_mesh"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.NETHERITE_STICK.get(), 2)
                .pattern("  S")
                .pattern(" S ")
                .pattern("S  ")
                .define('S', Misc.NETHERITE_NUGGET.get())
                .unlockedBy(getHasName(Misc.NETHERITE_NUGGET.get()), has(Misc.NETHERITE_NUGGET.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.STARDUST.get(), 9)
                .requires(Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.DOUGH.get(), 2)
                .requires(Items.WHEAT, 3)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_bread", has(Items.WHEAT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.BLAZE_SLAG.get(), 1)
                .requires(Misc.NETHER_SLAG.get())
                .requires(Items.BLAZE_POWDER)
                .unlockedBy("has_nether_slag", has(Misc.NETHER_SLAG.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COAL, 3)
                .requires(Misc.WITHERED_BONE.get())
                .unlockedBy("has_withered_bone", has(Misc.WITHERED_BONE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_APPLE.get())
                .pattern(" S ")
                .pattern(" A ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('A', Items.APPLE)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);







        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHEESE_WHEEL.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.CHEESE.get())
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHEESE.get(), 4)
                .requires(ModItems.CHEESE_WHEEL.get())
                .unlockedBy(getHasName(ModItems.CHEESE_WHEEL.get()), has(ModItems.CHEESE_WHEEL.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}