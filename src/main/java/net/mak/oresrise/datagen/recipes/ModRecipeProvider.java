package net.mak.oresrise.datagen.recipes;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> WITHERITE_SMELTABLES = List.of(
            WitheriteSet.RAW_WITHERITE.get());

    /* private static final List<ItemLike> COBALT_SMELTABLES = List.of(
            CobaltSet.RAW_COBALT.get(),
            ModBlocks.COBALT_ORE.get()); */

    private static final List<ItemLike> RAGEITE_SMELTABLES = List.of(
            RageiteSet.RAGING_COMPOUND.get());

    private static final List<ItemLike> COLOSSITE_SMELTABLES = List.of(
            ColossiteSet.COLOSSAL_COMPOUND.get());

    private static final List<ItemLike> SCOURIUM_SMELTABLES = List.of(
            ScouriumSet.SCOUROUS_SUBSTANCE.get());

    private static final List<ItemLike> IRON_SMELTABLES = List.of(
            Items.IRON_INGOT);

    private static final List<ItemLike> NETHERITE_SMELTABLES = List.of(
            Items.NETHERITE_INGOT);

    private static final List<ItemLike> OBSIDIUM_SMELTABLES = List.of(
            ObsidiumSet.OBSIDIAN_ALLOY.get());

    private static final List<ItemLike> KEYOLITE_SMELTABLES = List.of(
            KeyoliteSet.ROSAL_COMPOUND.get());

    private static final List<ItemLike> VOLTIUM_SMELTABLES = List.of(
            VoltiumSet.ELECTRIC_MATTER.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }



    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        AmethystRecipes.build(pWriter);
        ColossiteRecipes.build(pWriter);
        DreadsteelRecipes.build(pWriter);
        EmeraldRecipes.build(pWriter);
        FluxiteRecipes.build(pWriter);
        HemogemRecipes.build(pWriter);
        HydrogemRecipes.build(pWriter);
        KeyoliteRecipes.build(pWriter);
        LunarisRecipes.build(pWriter);
        MiscRecipes.build(pWriter);
        ObsidiumRecipes.build(pWriter);
        OnyxRecipes.build(pWriter);
        RageiteRecipes.build(pWriter);
        ScouriumRecipes.build(pWriter);
        RoseGoldRecipes.build(pWriter);
        RositeRecipes.build(pWriter);
        RubyRecipes.build(pWriter);
        SapphireRecipes.build(pWriter);
        SoulForgedRecipes.build(pWriter);
        PhasmiteRecipes.build(pWriter);
        SteelRecipes.build(pWriter);
        VoltiumRecipes.build(pWriter);
        WitheriteRecipes.build(pWriter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD, ModItems.CHEESE.get(), 0.25f, 200).unlockedBy("has_milk", has(Items.MILK_BUCKET)).save(pWriter, new ResourceLocation("oresrise", "cheese_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD, ModItems.CHEESE.get(), 0.5f, 100).unlockedBy("has_milk", has(Items.MILK_BUCKET)).save(pWriter, new ResourceLocation("oresrise", "cheese_smoking"));

        // oreSmelting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 0.25f, 200, "cobalt_ingot");
        // oreBlasting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 0.25f, 100, "cobalt_ingot");

        oreSmelting(pWriter, RAGEITE_SMELTABLES, RecipeCategory.MISC, RageiteSet.RAGEITE_INGOT.get(), 0.25f, 200, "rageite_ingot");
        oreBlasting(pWriter, RAGEITE_SMELTABLES, RecipeCategory.MISC, RageiteSet.RAGEITE_INGOT.get(), 0.5f, 100, "rageite_ingot");

        oreSmelting(pWriter, WITHERITE_SMELTABLES, RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 0.25f, 200, "witherite_ingot");
        oreBlasting(pWriter, WITHERITE_SMELTABLES, RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 0.5f, 100, "witherite_ingot");

        oreSmelting(pWriter, IRON_SMELTABLES, RecipeCategory.MISC, Misc.MOLTEN_IRON_INGOT.get(), 0.25f, 200, "molten_iron_ingot");
        oreBlasting(pWriter, IRON_SMELTABLES, RecipeCategory.MISC, Misc.MOLTEN_IRON_INGOT.get(), 0.5f, 100, "molten_netherite_ingot");

        oreBlasting(pWriter, NETHERITE_SMELTABLES, RecipeCategory.MISC, Misc.MOLTEN_NETHERITE_INGOT.get(), 0.5f, 100, "molten_iron_ingot");

        oreBlasting(pWriter, OBSIDIUM_SMELTABLES, RecipeCategory.MISC, ObsidiumSet.OBSIDIUM_INGOT.get(), 0.5f, 100, "obsidium_ingot");

        oreBlasting(pWriter, COLOSSITE_SMELTABLES, RecipeCategory.MISC, ColossiteSet.COLOSSITE_INGOT.get(), 0.5f, 100, "colossite_ingot");

        oreBlasting(pWriter, VOLTIUM_SMELTABLES, RecipeCategory.MISC, VoltiumSet.VOLTIUM_INGOT.get(), 0.5f, 100, "voltium_ingot");

        oreSmelting(pWriter, KEYOLITE_SMELTABLES, RecipeCategory.MISC, KeyoliteSet.KEYOLITE_INGOT.get(), 0.25f, 200, "keyolite_ingot");
        oreBlasting(pWriter, KEYOLITE_SMELTABLES, RecipeCategory.MISC, KeyoliteSet.KEYOLITE_INGOT.get(), 0.5f, 100, "keyolite_ingot");

        oreSmelting(pWriter, SCOURIUM_SMELTABLES, RecipeCategory.MISC, ScouriumSet.SCOURIUM_INGOT.get(), 0.25f, 200, "scourium_ingot");
        oreBlasting(pWriter, SCOURIUM_SMELTABLES, RecipeCategory.MISC, ScouriumSet.SCOURIUM_INGOT.get(), 0.5f, 100, "scourium_ingot");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.ROTTEN_FLESH), RecipeCategory.MISC, Items.LEATHER, 0.25f, 200).unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH)).save(pWriter, new ResourceLocation("oresrise", "leather_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.ROTTEN_FLESH), RecipeCategory.MISC, Items.LEATHER, 0.5f, 100).unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH)).save(pWriter, new ResourceLocation("oresrise", "leather_smoking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BREAD), RecipeCategory.FOOD, ModItems.TOASTED_BREAD.get(), 0.25f, 200).unlockedBy("has_bread", has(Items.BREAD)).save(pWriter, new ResourceLocation("oresrise", "toast_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.BREAD), RecipeCategory.FOOD, ModItems.TOASTED_BREAD.get(), 0.5f, 100).unlockedBy("has_bread", has(Items.BREAD)).save(pWriter, new ResourceLocation("oresrise", "toast_smoking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Misc.DOUGH.get()), RecipeCategory.FOOD, Items.BREAD, 0.25f, 200).unlockedBy("has_dough", has(Misc.DOUGH.get())).save(pWriter, new ResourceLocation("oresrise", "dough_to_bread_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Misc.DOUGH.get()), RecipeCategory.FOOD, Items.BREAD, 0.5f, 100).unlockedBy("has_dough", has(Misc.DOUGH.get())).save(pWriter, new ResourceLocation("oresrise", "dough_to_bread_smoking"));








        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FireiteSet.PYROGEL.get(), 1)
                .pattern(" S ")
                .pattern("SCS")
                .pattern(" S ")
                .define('S', Items.BLAZE_POWDER)
                .define('C', Items.MAGMA_CREAM)
                .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FireiteSet.FIREITE_INGOT.get())
                .pattern(" S ")
                .pattern("ECE")
                .pattern(" S ")
                .define('S', FireiteSet.PYROGEL.get())
                .define('E', Items.MAGMA_BLOCK)
                .define('C', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(FireiteSet.PYROGEL.get()), has(FireiteSet.PYROGEL.get()))
                .save(pWriter);*/









        /* ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBLIVIONITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', OblivioniteSet.OBLIVIONITE_CRYSTAL.get())  
                .unlockedBy(getHasName(OblivioniteSet.OBLIVIONITE_CRYSTAL.get()), has(OblivioniteSet.OBLIVIONITE_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OblivioniteSet.OBLIVIONITE_CRYSTAL.get(), 9)
                .requires(ModBlocks.OBLIVIONITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OBLIVIONITE_BLOCK.get()), has(ModBlocks.OBLIVIONITE_BLOCK.get()))
                .save(pWriter);*/









      /*  ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', JadeSet.JADE.get())
                .unlockedBy(getHasName(JadeSet.JADE.get()), has(JadeSet.JADE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JadeSet.JADE.get(), 9)
                .requires(ModBlocks.JADE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.JADE_BLOCK.get()), has(ModBlocks.JADE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUINTESSITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', QuintessiteSet.QUINTESSITE.get())
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, QuintessiteSet.QUINTESSITE.get(), 9)
                .requires(ModBlocks.QUINTESSITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.QUINTESSITE_BLOCK.get()), has(ModBlocks.QUINTESSITE_BLOCK.get()))
                .save(pWriter);*/









       /* ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBALT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CobaltSet.COBALT_INGOT.get())
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 9)
                .requires(ModBlocks.COBALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COBALT_BLOCK.get()), has(ModBlocks.COBALT_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_ingot_from_block"); */







       /* ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_COBALT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CobaltSet.RAW_COBALT.get())
                .unlockedBy(getHasName(CobaltSet.RAW_COBALT.get()), has(CobaltSet.RAW_COBALT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_cobalt_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CobaltSet.RAW_COBALT.get(), 9)
                .requires(ModBlocks.RAW_COBALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_COBALT_BLOCK.get()), has(ModBlocks.RAW_COBALT_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_cobalt_from_block"); */



        /*ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MALACHITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', MalachiteSet.MALACHITE.get())
                .unlockedBy(getHasName(MalachiteSet.MALACHITE.get()), has(MalachiteSet.MALACHITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":malachite_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MalachiteSet.MALACHITE.get(), 9)
                .requires(ModBlocks.MALACHITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MALACHITE_BLOCK.get()), has(ModBlocks.MALACHITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":malachite_from_block");*/











        /* ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', CobaltSet.COBALT_INGOT.get())
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CobaltSet.COBALT_INGOT.get())
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', CobaltSet.COBALT_INGOT.get())
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', CobaltSet.COBALT_INGOT.get())
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                   
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                  
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', CobaltSet.COBALT_INGOT.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_hoe_2"); */










       /* ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', QuintessiteSet.QUINTESSITE.get())
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', QuintessiteSet.QUINTESSITE.get())
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', QuintessiteSet.QUINTESSITE.get())
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', QuintessiteSet.QUINTESSITE.get())
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                        
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                  
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                    
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":quintessite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                         
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":quintessite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                   
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                      
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":quintessite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', QuintessiteSet.QUINTESSITE.get())  
                .define('#', Misc.NETHERITE_STICK.get())                    
                .unlockedBy(getHasName(QuintessiteSet.QUINTESSITE.get()), has(QuintessiteSet.QUINTESSITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":quintessite_hoe_2");*/




    }







    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void foodCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  ExampleMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }


    }

}