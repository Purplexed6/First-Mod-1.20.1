package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.LunarisSet;
import net.mak.oresrise.item.custom.KeyoliteSet;
import net.mak.oresrise.item.custom.LunarisSet;
import net.mak.oresrise.item.custom.SoulSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class LunarisRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_SWORD.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),             // Upgrade material
                        RecipeCategory.COMBAT,
                        LunarisSet.LUNARIS_SWORD.get()  )                          // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_sword_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_PICKAXE.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_PICKAXE.get()  )                         // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_pickaxe_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_AXE.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_AXE.get()  )                         // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_axe_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_SHOVEL.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_SHOVEL.get()   )                        // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_shovel_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_HOE.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_HOE.get() )                          // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_hoe_smithing")); // Use pWriter here



        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_HELMET.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_HELMET.get() )                          // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_helmet_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_CHESTPLATE.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_CHESTPLATE.get() )                          // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_chestplate_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_LEGGINGS.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_LEGGINGS.get() )                          // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_leggings_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(KeyoliteSet.KEYOLITE_BOOTS.get()),                    // Base item
                        Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        LunarisSet.LUNARIS_BOOTS.get() )                          // Resulting item
                .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_boots_smithing")); // Use pWriter here



        // 2. The Template Duplication Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("D#D")
                .pattern("DTD")
                .pattern("DDD")
                .define('D', Items.DIAMOND)
                .define('T', LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get())
                .define('#', Items.PURPUR_BLOCK) // Replace with your own block if desired
                .unlockedBy("has_lunaris_upgrade_template", has(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_upgrade_template_duplication"));










        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LUNARIS_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', LunarisSet.LUNARIS.get())
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LunarisSet.LUNARIS.get(), 9)
                .requires(ModBlocks.LUNARIS_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LUNARIS_BLOCK.get()), has(ModBlocks.LUNARIS_BLOCK.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}