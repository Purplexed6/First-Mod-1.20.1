package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.ColossiteSet;
import net.mak.oresrise.item.custom.DreadsteelSet;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.SoulSet;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class DreadsteelRecipes {

    public static void build(Consumer<FinishedRecipe> pWriter) {


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_SWORD.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),             // Upgrade material
                        RecipeCategory.COMBAT,
                        DreadsteelSet.DREADSTEEL_SWORD.get()  )                          // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_sword_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_PICKAXE.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_PICKAXE.get()  )                         // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_pickaxe_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_AXE.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_AXE.get()  )                         // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_axe_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_SHOVEL.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_SHOVEL.get()   )                        // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_shovel_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_HOE.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_HOE.get() )                          // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_hoe_smithing")); // Use pWriter here



        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_HELMET.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_HELMET.get() )                          // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_helmet_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_CHESTPLATE.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_CHESTPLATE.get() )                          // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_chestplate_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_LEGGINGS.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_LEGGINGS.get() )                          // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_leggings_smithing")); // Use pWriter here

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                        Ingredient.of(SoulSet.SOULFORGED_BOOTS.get()),                    // Base item
                        Ingredient.of(DreadsteelSet.DREADSTEEL_INGOT.get()),           // Upgrade material
                        RecipeCategory.TOOLS,
                        DreadsteelSet.DREADSTEEL_BOOTS.get() )                          // Resulting item
                .unlocks("has_dreadsteel", has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_boots_smithing")); // Use pWriter here



        // 2. The Template Duplication Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("D#D")
                .pattern("DTD")
                .pattern("DDD")
                .define('D', Items.DIAMOND)
                .define('T', DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get())
                .define('#', Items.SOUL_SOIL) // Replace with your own block if desired
                .unlockedBy("has_dreadsteel_upgrade_template", has(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "dreadsteel_upgrade_template_duplication"));







        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DreadsteelSet.DREADSTEEL_INGOT.get(), 2)
                .requires(Misc.NETHERITE_MESH.get())
                .requires(SoulSet.SOUL_CRYSTAL.get())
                .requires(SoulSet.SOUL_PRISM.get())
                .requires(Misc.STARDUST.get())
                .requires(Items.GHAST_TEAR)
                .unlockedBy("has_netherite_mesh", has(Misc.NETHERITE_MESH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "dreadsteel_craft"));





        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DREADSTEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', DreadsteelSet.DREADSTEEL_INGOT.get())
                .unlockedBy(getHasName(DreadsteelSet.DREADSTEEL_INGOT.get()), has(DreadsteelSet.DREADSTEEL_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DreadsteelSet.DREADSTEEL_INGOT.get(), 9)
                .requires(ModBlocks.DREADSTEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.DREADSTEEL_BLOCK.get()), has(ModBlocks.DREADSTEEL_BLOCK.get()))
                .save(pWriter);

    }
    private static String getHasName(ItemLike item) {
        return item.asItem().toString();
    }


    private static CriterionTriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }
}