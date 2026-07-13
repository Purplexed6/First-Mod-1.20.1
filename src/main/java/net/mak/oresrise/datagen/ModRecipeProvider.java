package net.mak.oresrise.datagen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.ModFoods;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static org.antlr.v4.gui.Trees.save;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> WITHERITE_SMELTABLES = List.of(
            WitheriteSet.RAW_WITHERITE.get(),
            ModBlocks.WITHERITE_ORE.get());

    private static final List<ItemLike> COBALT_SMELTABLES = List.of(
            CobaltSet.RAW_COBALT.get());

    private static final List<ItemLike> PLATINUM_SMELTABLES = List.of(
            PlatinumSet.RAW_PLATINUM.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                        ModItems.CHEESE.get(), 0.35f, 200)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(pWriter, new ResourceLocation("oresrise", "cheese_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                        ModItems.CHEESE.get(), 0.35f, 100)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(pWriter, new ResourceLocation("oresrise", "cheese_smoking"));

        oreSmelting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 0.25f, 200, "cobalt_ingot");
        oreBlasting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 0.25f, 100, "cobalt_ingot");

        oreSmelting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, PlatinumSet.PLATINUM_INGOT.get(), 0.25f, 200, "platinum_ingot");
        oreBlasting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, PlatinumSet.PLATINUM_INGOT.get(), 0.25f, 100, "platinum_ingot");

        oreSmelting(pWriter, WITHERITE_SMELTABLES, RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 0.25f, 200, "witherite_ingot");
        oreBlasting(pWriter, WITHERITE_SMELTABLES, RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 0.25f, 100, "witherite_ingot");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.ROTTEN_FLESH), RecipeCategory.MISC,
                        Items.LEATHER, 0.35f, 200)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(pWriter, new ResourceLocation("oresrise", "leather_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.ROTTEN_FLESH), RecipeCategory.MISC,
                        Items.LEATHER, 0.35f, 100)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(pWriter, new ResourceLocation("oresrise", "leather_smoking"));



        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BREAD), RecipeCategory.FOOD,
                        ModItems.TOASTED_BREAD.get(), 0.35f, 200)
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(pWriter, new ResourceLocation("oresrise", "toast_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.BREAD), RecipeCategory.FOOD,
                        ModItems.TOASTED_BREAD.get(), 0.35f, 100)
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(pWriter, new ResourceLocation("oresrise", "toast_smoking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CHEESE_SANDWICH.get()), RecipeCategory.FOOD,
                        ModItems.GRILLED_CHEESE.get(), 0.35f, 200)
                .unlockedBy("has_cheese_sandwich", has(ModItems.CHEESE_SANDWICH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "grilled_cheese_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.CHEESE_SANDWICH.get()), RecipeCategory.FOOD,
                        ModItems.GRILLED_CHEESE.get(), 0.35f, 100)
                .unlockedBy("has_cheese_sandwich", has(ModItems.CHEESE_SANDWICH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "grilled_cheese_smoking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Misc.DOUGH.get()), RecipeCategory.FOOD,
                        Items.BREAD, 0.35f, 200)
                .unlockedBy("has_dough", has(Misc.DOUGH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "dough_to_bread_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Misc.DOUGH.get()), RecipeCategory.FOOD,
                        Items.BREAD, 0.35f, 100)
                .unlockedBy("has_dough", has(Misc.DOUGH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "dough_to_bread_smoking"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.IRON_STICK.get())
                .pattern("S")
                .pattern("S")
                .define('S', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.OBSIDIAN_STICK.get())
                .pattern("S")
                .pattern("S")
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(ObsidianSet.OBSIDIAN_SHARD.get()), has(ObsidianSet.OBSIDIAN_SHARD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.NETHERITE_STICK.get(), 4)
                .pattern("S")
                .pattern("S")
                .define('S', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.STARDUST.get(), 3)
                .requires(Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RoseGoldSet.ROSE_GOLD_INGOT.get(), 2)
                .requires(Items.GOLD_INGOT) 
                .requires(Items.COPPER_INGOT)
                .unlockedBy("gold_ingot", has(Items.GOLD_INGOT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get(), 2)
                .requires(Items.IRON_INGOT, 2) 
                .requires(Items.REDSTONE, 2)
                .unlockedBy("redstone", has(Items.REDSTONE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FireiteSet.PYROGEL.get(), 2)
                .requires(Items.BLAZE_POWDER) 
                .requires(Items.MAGMA_CREAM)
                .unlockedBy("magma_cream", has(Items.MAGMA_CREAM))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FireiteSet.FIREITE_INGOT.get(), 1)
                .requires(FireiteSet.PYROGEL.get()) 
                .requires(Items.NETHERITE_INGOT)
                .unlockedBy("pyrogel", has(FireiteSet.PYROGEL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, StarPlatinumSet.STAR_PLATINUM_INGOT.get(), 1)
                .requires(PlatinumSet.PLATINUM_INGOT.get()) 
                .requires(StarriteSet.STARRITE.get())
                .unlockedBy("platinum_ingot", has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSteelSet.SOUL_STEEL_INGOT.get(), 2)
                .requires(SoulSet.SOUL_CRYSTAL.get(), 4) 
                .requires(Items.NETHERITE_INGOT, 4)        
                .requires(Misc.STARDUST.get()) 
                .unlockedBy("has_soul_crystal", has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter, new ResourceLocation("oresrise", "soul_steel_craft"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLAMING_RABBIT.get(), 1)
                .requires(Items.COOKED_RABBIT) 
                .requires(Items.BLAZE_POWDER)
                .requires(ModItems.PEPPER.get())
                .unlockedBy("blaze_powder", has(Items.BLAZE_POWDER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLAMING_STEAK.get(), 1)
                .requires(Items.COOKED_BEEF) 
                .requires(Items.BLAZE_POWDER)
                .requires(ModItems.PEPPER.get())
                .unlockedBy("blaze_powder", has(Items.BLAZE_POWDER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLAMING_CHICKEN.get(), 1)
                .requires(Items.COOKED_CHICKEN) 
                .requires(Items.BLAZE_POWDER)
                .requires(ModItems.PEPPER.get())
                .unlockedBy("blaze_powder", has(Items.BLAZE_POWDER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLAMING_MUTTON.get(), 1)
                .requires(Items.COOKED_MUTTON) 
                .requires(Items.BLAZE_POWDER)
                .requires(ModItems.PEPPER.get())
                .unlockedBy("blaze_powder", has(Items.BLAZE_POWDER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLAMING_PORKCHOP.get(), 1)
                .requires(Items.COOKED_PORKCHOP) 
                .requires(Items.BLAZE_POWDER)
                .requires(ModItems.PEPPER.get())
                .unlockedBy("blaze_powder", has(Items.BLAZE_POWDER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHEESE_SANDWICH.get(), 1)
                .requires(ModItems.BREAD_SLICE.get(), 2) 
                .requires(ModItems.CHEESE_SLICE.get())
                .unlockedBy("has_bread", has(ModItems.BREAD_SLICE.get()))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SOUL_COOKIE.get())
                .pattern(" S ")
                .pattern("ECE")
                .pattern(" S ")
                .define('S', SoulSet.SOUL_POWDER.get())
                .define('E', Items.NETHERRACK)
                .define('C', Items.COOKIE)
                .unlockedBy(getHasName(SoulSet.SOUL_POWDER.get()), has(SoulSet.SOUL_POWDER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CryptonSet.CRYPTON.get())
                .pattern(" S ")
                .pattern("ECE")
                .pattern(" S ")
                .define('S', CryptonSet.CRYPTON_SHARD.get())
                .define('E', Items.ECHO_SHARD)
                .define('C', Items.NETHER_STAR)
                .unlockedBy(getHasName(SoulSet.SOUL_POWDER.get()), has(SoulSet.SOUL_POWDER.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_echo_star");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHEESE_SLICE.get(), 4)
                .requires(ModItems.CHEESE.get())
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BREAD_SLICE.get(), 2)
                .requires(Items.BREAD)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBSIDIAN_COOKIE.get())
                .pattern(" S ")
                .pattern("SCS")
                .pattern(" S ")
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())
                .define('C', Items.COOKIE)
                .unlockedBy(getHasName(ObsidianSet.OBSIDIAN_SHARD.get()), has(ObsidianSet.OBSIDIAN_SHARD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_APPLE.get())
                .pattern(" S ")
                .pattern("SAS")
                .pattern(" S ")
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('A', Items.APPLE)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get(), 9)
                .requires(ModBlocks.ROSITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROSITE_BLOCK.get()), has(ModBlocks.ROSITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SapphireSet.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROUGH_SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SapphireSet.ROUGH_SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.ROUGH_SAPPHIRE.get()), has(SapphireSet.ROUGH_SAPPHIRE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SapphireSet.ROUGH_SAPPHIRE.get(), 9)
                .requires(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get()), has(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RubySet.RUBY.get()) 
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubySet.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROUGH_RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RubySet.ROUGH_RUBY.get())  
                .unlockedBy(getHasName(RubySet.ROUGH_RUBY.get()), has(RubySet.ROUGH_RUBY.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubySet.ROUGH_RUBY.get(), 9)
                .requires(ModBlocks.ROUGH_RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROUGH_RUBY_BLOCK.get()), has(ModBlocks.ROUGH_RUBY_BLOCK.get()))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WITHERITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 9)
                .requires(ModBlocks.WITHERITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.WITHERITE_BLOCK.get()), has(ModBlocks.WITHERITE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_WITHERITE_BLOCK.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', WitheriteSet.RAW_WITHERITE.get())
                .unlockedBy(getHasName(WitheriteSet.RAW_WITHERITE.get()), has(WitheriteSet.RAW_WITHERITE.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WitheriteSet.RAW_WITHERITE.get(), 9)
                .requires(ModBlocks.RAW_WITHERITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_WITHERITE_BLOCK.get()), has(ModBlocks.RAW_WITHERITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_witherite_from_block");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBLIVIONITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', OblivioniteSet.OBLIVIONITE_CRYSTAL.get())  
                .unlockedBy(getHasName(OblivioniteSet.OBLIVIONITE_CRYSTAL.get()), has(OblivioniteSet.OBLIVIONITE_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OblivioniteSet.OBLIVIONITE_CRYSTAL.get(), 9)
                .requires(ModBlocks.OBLIVIONITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OBLIVIONITE_BLOCK.get()), has(ModBlocks.OBLIVIONITE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SoulSet.SOUL_CRYSTAL.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', SoulSet.SOUL_FRAGMENT.get())
                .unlockedBy(getHasName(SoulSet.SOUL_FRAGMENT.get()), has(SoulSet.SOUL_FRAGMENT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSet.SOUL_FRAGMENT.get(), 4)
                .requires(SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSet.SOUL_CRYSTAL.get(), 9)
                .requires(ModBlocks.SOUL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_BLOCK.get()), has(ModBlocks.SOUL_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_crystal_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":azurite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":azurite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":azurite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AzuriteSet.AZURITE.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":azurite_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())  
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":sapphire_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":sapphire_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":sapphire_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SapphireSet.SAPPHIRE.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":sapphire_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_HELMET.get())
                .pattern("SSS")  
                .pattern("S S")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_CHESTPLATE.get())
                .pattern("S S")  
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_LEGGINGS.get())
                .pattern("SSS")  
                .pattern("S S")
                .pattern("S S")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SapphireSet.SAPPHIRE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', SapphireSet.SAPPHIRE.get())
                .unlockedBy(getHasName(SapphireSet.SAPPHIRE.get()), has(SapphireSet.SAPPHIRE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', AzuriteSet.AZURITE.get())
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', AzuriteSet.AZURITE.get())
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', AzuriteSet.AZURITE.get())
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AzuriteSet.AZURITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', AzuriteSet.AZURITE.get())
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_HELMET.get())
                .pattern("SAS")
                .pattern("S S")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SAS")
                .pattern("SSS")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_LEGGINGS.get())
                .pattern("SAS")
                .pattern("S S")
                .pattern("S S")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_BOOTS.get())
                .pattern("A A")
                .pattern("S S")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_PICKAXE.get())
                .pattern("SAS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_SWORD.get())
                .pattern(" S ")  
                .pattern(" A ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_AXE.get())
                .pattern("SA ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_AXE.get())
                .pattern(" AS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_SHOVEL.get())
                .pattern(" A ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_HOE.get())
                .pattern("SA ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidianSet.OBSIDIAN_HOE.get())
                .pattern(" AS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidianSet.OBSIDIAN_SHARD.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_PICKAXE.get())
                .pattern("AAA")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_SWORD.get())
                .pattern(" A ")  
                .pattern(" A ")
                .pattern(" # ") 
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_AXE.get())
                .pattern("AA ")  
                .pattern("A# ")
                .pattern(" # ") 
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUGILITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SugiliteSet.SUGILITE.get())
                .unlockedBy(getHasName(SugiliteSet.SUGILITE.get()), has(SugiliteSet.SUGILITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SugiliteSet.SUGILITE.get(), 9)
                .requires(ModBlocks.SUGILITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SUGILITE_BLOCK.get()), has(ModBlocks.SUGILITE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', AlexandriteSet.ALEXANDRITE.get())
                .unlockedBy(getHasName(AlexandriteSet.ALEXANDRITE.get()), has(AlexandriteSet.ALEXANDRITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AlexandriteSet.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
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
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEMOGEM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HemoSet.HEMOGEM.get(), 9)
                .requires(ModBlocks.HEMOGEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMOGEM_BLOCK.get()), has(ModBlocks.HEMOGEM_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSteelSet.SOUL_STEEL_INGOT.get(), 9)
                .requires(ModBlocks.SOUL_STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STEEL_BLOCK.get()), has(ModBlocks.SOUL_STEEL_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYPTON_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CryptonSet.CRYPTON.get())
                .unlockedBy(getHasName(CryptonSet.CRYPTON.get()), has(CryptonSet.CRYPTON.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_block_from_item");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CryptonSet.CRYPTON.get(), 9)
                .requires(ModBlocks.CRYPTON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CRYPTON_BLOCK.get()), has(ModBlocks.CRYPTON_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_from_block");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', AzuriteSet.AZURITE.get())
                .unlockedBy(getHasName(AzuriteSet.AZURITE.get()), has(AzuriteSet.AZURITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AzuriteSet.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ONYX_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OnyxSet.ONYX.get(), 9)
                .requires(ModBlocks.ONYX_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ONYX_BLOCK.get()), has(ModBlocks.ONYX_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STARRITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', StarriteSet.STARRITE.get())
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, StarriteSet.STARRITE.get(), 9)
                .requires(ModBlocks.STARRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STARRITE_BLOCK.get()), has(ModBlocks.STARRITE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBALT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CobaltSet.COBALT_INGOT.get())
                .unlockedBy(getHasName(CobaltSet.COBALT_INGOT.get()), has(CobaltSet.COBALT_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 9)
                .requires(ModBlocks.COBALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COBALT_BLOCK.get()), has(ModBlocks.COBALT_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_ingot_from_block");


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RoseGoldSet.ROSE_GOLD_INGOT.get(), 9)
                .requires(ModBlocks.ROSE_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ROSE_GOLD_BLOCK.get()), has(ModBlocks.ROSE_GOLD_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_ingot_from_block");


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLATINUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PlatinumSet.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":platinum_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PlatinumSet.PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PLATINUM_BLOCK.get()), has(ModBlocks.PLATINUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":platinum_ingot_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAR_PLATINUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, StarPlatinumSet.STAR_PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.STAR_PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STAR_PLATINUM_BLOCK.get()), has(ModBlocks.STAR_PLATINUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_ingot_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_COBALT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', CobaltSet.RAW_COBALT.get())
                .unlockedBy(getHasName(CobaltSet.RAW_COBALT.get()), has(CobaltSet.RAW_COBALT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_cobalt_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CobaltSet.RAW_COBALT.get(), 9)
                .requires(ModBlocks.RAW_COBALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_COBALT_BLOCK.get()), has(ModBlocks.RAW_COBALT_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_cobalt_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PLATINUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PlatinumSet.RAW_PLATINUM.get())
                .unlockedBy(getHasName(PlatinumSet.RAW_PLATINUM.get()), has(PlatinumSet.RAW_PLATINUM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_platinum_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PlatinumSet.RAW_PLATINUM.get(), 9)
                .requires(ModBlocks.RAW_PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_PLATINUM_BLOCK.get()), has(ModBlocks.RAW_PLATINUM_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":raw_platinum_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MALACHITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', MalachiteSet.MALACHITE.get())
                .unlockedBy(getHasName(MalachiteSet.MALACHITE.get()), has(MalachiteSet.MALACHITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":malachite_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MalachiteSet.MALACHITE.get(), 9)
                .requires(ModBlocks.MALACHITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MALACHITE_BLOCK.get()), has(ModBlocks.MALACHITE_BLOCK.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":malachite_from_block");




        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)               
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)                  
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)                   
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter, ExampleMod.MOD_ID + ":amethyst_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter, ExampleMod.MOD_ID + ":amethyst_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)                
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter, ExampleMod.MOD_ID + ":amethyst_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.AMETHYST_SHARD)  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter, ExampleMod.MOD_ID + ":amethyst_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmethystSet.AMETHYST_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);







        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)               
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)                  
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)                   
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)                
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', RositeSet.ROSITE_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rosite_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RositeSet.ROSITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', RositeSet.ROSITE_INGOT.get())
                .unlockedBy(getHasName(RositeSet.ROSITE_INGOT.get()), has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);








        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)               
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)                  
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)                   
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter, ExampleMod.MOD_ID + ":emerald_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter, ExampleMod.MOD_ID + ":emerald_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)                
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter, ExampleMod.MOD_ID + ":emerald_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', Items.EMERALD)  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter, ExampleMod.MOD_ID + ":emerald_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EmeraldSet.EMERALD_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(pWriter);







        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSet.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_CRYSTAL.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(SoulSet.SOUL_CRYSTAL.get()), has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_hoe_2");








        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', WitheriteSet.WITHERITE_INGOT.get())
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":witherite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":witherite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":witherite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, WitheriteSet.WITHERITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', WitheriteSet.WITHERITE_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(WitheriteSet.WITHERITE_INGOT.get()), has(WitheriteSet.WITHERITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":witherite_hoe_2");







        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CobaltSet.COBALT_HELMET.get())
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
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_axe_1");

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
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_hoe_2");






        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                        
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                  
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                         
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                   
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                      
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_hoe_2");











        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', PlatinumSet.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PlatinumSet.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', PlatinumSet.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', PlatinumSet.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":platinum_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                   
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":platinum_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                  
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":platinum_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PlatinumSet.PLATINUM_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', PlatinumSet.PLATINUM_INGOT.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(PlatinumSet.PLATINUM_INGOT.get()), has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":platinum_hoe_2");












        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', StarriteSet.STARRITE.get())
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', StarriteSet.STARRITE.get())
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', StarriteSet.STARRITE.get())
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', StarriteSet.STARRITE.get())
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                 
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                   
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                  
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                     
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Items.STICK)                    
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_hoe_2");












        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                        
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                  
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                         
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                   
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                      
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarPlatinumSet.STAR_PLATINUM_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":star_platinum_hoe_2");








        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', HemoSet.HEMOGEM.get())
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                        
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                  
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                         
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                   
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                      
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HemoSet.HEMOGEM_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', HemoSet.HEMOGEM.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(HemoSet.HEMOGEM.get()), has(HemoSet.HEMOGEM.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":hemogem_hoe_2");










        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', LunarisSet.LUNARIS.get())
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', LunarisSet.LUNARIS.get())
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', LunarisSet.LUNARIS.get())
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', LunarisSet.LUNARIS.get())
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                        
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                  
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":lunaris_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                         
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":lunaris_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                   
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                      
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":lunaris_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LunarisSet.LUNARIS_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', LunarisSet.LUNARIS.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(LunarisSet.LUNARIS.get()), has(LunarisSet.LUNARIS.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":lunaris_hoe_2");










        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', AmberSet.AMBER.get())
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', AmberSet.AMBER.get())
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', AmberSet.AMBER.get())
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', AmberSet.AMBER.get())
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                        
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                  
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":amber_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                         
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":amber_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                   
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                      
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":amber_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AmberSet.AMBER_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', AmberSet.AMBER.get())  
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(AmberSet.AMBER.get()), has(AmberSet.AMBER.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":amber_hoe_2");








        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', OnyxSet.ONYX.get())
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                        
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                  
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                    
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":onyx_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                         
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":onyx_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                   
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                      
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":onyx_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, OnyxSet.ONYX_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', OnyxSet.ONYX.get())  
                .define('#', Misc.NETHERITE_STICK.get())                    
                .unlockedBy(getHasName(OnyxSet.ONYX.get()), has(OnyxSet.ONYX.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":onyx_hoe_2");











        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, QuintessiteSet.QUINTESSITE_HELMET.get())
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
                .save(pWriter, ExampleMod.MOD_ID + ":quintessite_axe_1");

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
                .save(pWriter, ExampleMod.MOD_ID + ":quintessite_hoe_2");








        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STAR_STAFF.get())
                .pattern("ASA")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())
                .define('#', Items.STICK)
                .define('A', Items.SPECTRAL_ARROW)
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);


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