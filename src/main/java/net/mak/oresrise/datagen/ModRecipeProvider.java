package net.mak.oresrise.datagen;

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

import javax.xml.stream.events.StartElement;
import java.util.List;
import java.util.function.Consumer;

import static org.antlr.v4.gui.Trees.save;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> WITHERITE_SMELTABLES = List.of(
            WitheriteSet.RAW_WITHERITE.get(),
            ModBlocks.WITHERITE_ORE.get());

    /* private static final List<ItemLike> COBALT_SMELTABLES = List.of(
            CobaltSet.RAW_COBALT.get(),
            ModBlocks.COBALT_ORE.get()); */

    private static final List<ItemLike> PLATINUM_SMELTABLES = List.of(
            PlatinumSet.RAW_PLATINUM.get(),
            ModBlocks.PLATINUM_ORE.get());

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
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                        ModItems.CHEESE.get(), 0.35f, 200)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(pWriter, new ResourceLocation("oresrise", "cheese_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                        ModItems.CHEESE.get(), 0.35f, 100)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(pWriter, new ResourceLocation("oresrise", "cheese_smoking"));

        // oreSmelting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 0.25f, 200, "cobalt_ingot");
      //  oreBlasting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, CobaltSet.COBALT_INGOT.get(), 0.25f, 100, "cobalt_ingot");

        oreSmelting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, PlatinumSet.PLATINUM_INGOT.get(), 0.25f, 200, "platinum_ingot");
        oreBlasting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, PlatinumSet.PLATINUM_INGOT.get(), 0.25f, 100, "platinum_ingot");

        oreSmelting(pWriter, WITHERITE_SMELTABLES, RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 0.25f, 200, "witherite_ingot");
        oreBlasting(pWriter, WITHERITE_SMELTABLES, RecipeCategory.MISC, WitheriteSet.WITHERITE_INGOT.get(), 0.25f, 100, "witherite_ingot");

        oreBlasting(pWriter, OBSIDIUM_SMELTABLES, RecipeCategory.MISC, ObsidiumSet.OBSIDIUM_INGOT.get(), 0.5f, 100, "obsidium_ingot");

        oreBlasting(pWriter, VOLTIUM_SMELTABLES, RecipeCategory.MISC, VoltiumSet.VOLTIUM_INGOT.get(), 0.5f, 100, "voltium_ingot");

        oreSmelting(pWriter, KEYOLITE_SMELTABLES, RecipeCategory.MISC, KeyoliteSet.KEYOLITE_INGOT.get(), 0.25f, 200, "keyolite_ingot");
        oreBlasting(pWriter, KEYOLITE_SMELTABLES, RecipeCategory.MISC, KeyoliteSet.KEYOLITE_INGOT.get(), 0.25f, 100, "keyolite_ingot");

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

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Misc.DOUGH.get()), RecipeCategory.FOOD,
                        Items.BREAD, 0.35f, 200)
                .unlockedBy("has_dough", has(Misc.DOUGH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "dough_to_bread_smelting"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Misc.DOUGH.get()), RecipeCategory.FOOD,
                        Items.BREAD, 0.35f, 100)
                .unlockedBy("has_dough", has(Misc.DOUGH.get()))
                .save(pWriter, new ResourceLocation("oresrise", "dough_to_bread_smoking"));

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.NETHERITE_NUGGET.get(), 9)
                .requires(Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Misc.NETHERITE_STICK.get(), 2)
                .pattern("  S")
                .pattern(" S ")
                .pattern("S  ")
                .define('S', Misc.NETHERITE_NUGGET.get())
                .unlockedBy(getHasName(Misc.NETHERITE_NUGGET.get()), has(Misc.NETHERITE_NUGGET.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Misc.STARDUST.get(), 4)
                .requires(Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RoseGoldSet.ROSE_GOLD_INGOT.get(), 2)
                .requires(Items.GOLD_INGOT) 
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get(), 2)
                .requires(Items.IRON_INGOT, 2) 
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(pWriter);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ObsidiumSet.OBSIDIAN_ALLOY.get(), 2)
                .requires(SteelSet.STEEL_INGOT.get())
                .requires(ObsidiumSet.OBSIDIAN_SHARD.get(), 2)
                .requires(Items.DIAMOND)
                .unlockedBy("has_steel_ingot", has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.ELECTRIC_MATTER.get(), 2)
                .requires(SteelSet.STEEL_INGOT.get(), 2)
                .requires(VoltiumSet.FLUXITE.get())
                .requires(Items.QUARTZ)
                .unlockedBy("has_fluxite", has(VoltiumSet.FLUXITE.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KeyoliteSet.ROSAL_COMPOUND.get(), 2)
                .requires(RositeSet.ROSITE_INGOT.get(), 2)
                .requires(Items.ENDER_PEARL)
                .requires(Items.AMETHYST_SHARD)
                .unlockedBy("has_rosite_ingot", has(RositeSet.ROSITE_INGOT.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_INGOT.get(), 2)
                .requires(Items.IRON_INGOT, 2)
                .requires(Items.COAL, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_INGOT.get())
                .requires(SteelSet.STEEL_NUGGET.get(), 9)
                .unlockedBy("steel_nugget", has(SteelSet.STEEL_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "steel_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_NUGGET.get(), 9)
                .requires(SteelSet.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .requires(SteelSet.STEEL_INGOT.get(), 9)
                .unlockedBy("steel_ingot", has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SteelSet.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter, new ResourceLocation("oresrise", "steel_from_block"));





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_INGOT.get())
                .requires(RositeSet.ROSITE_NUGGET.get(), 9)
                .unlockedBy("rosite_nugget", has(RositeSet.ROSITE_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "rosite_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RositeSet.ROSITE_NUGGET.get(), 9)
                .requires(RositeSet.ROSITE_INGOT.get())
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




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.VOLTIUM_INGOT.get())
                .requires(VoltiumSet.VOLTIUM_NUGGET.get(), 9)
                .unlockedBy("voltium_nugget", has(VoltiumSet.VOLTIUM_NUGGET.get()))
                .save(pWriter, new ResourceLocation("oresrise", "voltium_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.VOLTIUM_NUGGET.get(), 9)
                .requires(VoltiumSet.VOLTIUM_INGOT.get())
                .unlockedBy("has_voltium_ingot", has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.VOLTIUM_BLOCK.get())
                .requires(VoltiumSet.VOLTIUM_INGOT.get(), 9)
                .unlockedBy("voltium_ingot", has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.VOLTIUM_INGOT.get(), 9)
                .requires(ModBlocks.VOLTIUM_BLOCK.get())
                .unlockedBy("has_voltium_block", has(ModBlocks.VOLTIUM_BLOCK.get()))
                .save(pWriter, new ResourceLocation("oresrise", "voltium_from_block"));





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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSet.SOUL_ESSENCE.get(), 2)
                .requires(SoulSet.SOUL_CRYSTAL.get())
                .requires(SoulSet.SOUL_POWDER.get())
                .requires(Items.ECHO_SHARD)
                .requires(Items.GHAST_TEAR)
                .unlockedBy("soul_crystal", has(SoulSet.SOUL_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, StarPlatinumSet.STAR_PLATINUM_INGOT.get(), 1)
                .requires(PlatinumSet.PLATINUM_INGOT.get()) 
                .requires(StarriteSet.STARRITE.get())
                .unlockedBy("platinum_ingot", has(PlatinumSet.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoulSteelSet.SOUL_STEEL_INGOT.get(), 2)
                .requires(SoulSet.SOUL_CRYSTAL.get(), 1)
                .requires(SoulSet.SOUL_ESSENCE.get(), 2)
                .requires(Items.NETHERITE_INGOT, 1)
                .requires(Items.DIAMOND, 1)
                .requires(Items.NETHERITE_SCRAP, 3)
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
                .unlockedBy(getHasName(CryptonSet.CRYPTON_SHARD.get()), has(CryptonSet.CRYPTON_SHARD.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":crypton_echo_star");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBSIDIAN_COOKIE.get())
                .pattern(" S ")
                .pattern("SCS")
                .pattern(" S ")
                .define('S', ObsidiumSet.OBSIDIAN_SHARD.get())
                .define('C', Items.COOKIE)
                .unlockedBy(getHasName(ObsidiumSet.OBSIDIAN_SHARD.get()), has(ObsidiumSet.OBSIDIAN_SHARD.get()))
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
                .save(pWriter, ExampleMod.MOD_ID + ":voltium_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, VoltiumSet.VOLTIUM_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', VoltiumSet.VOLTIUM_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(VoltiumSet.VOLTIUM_INGOT.get()), has(VoltiumSet.VOLTIUM_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":voltium_hoe_2");
        
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














        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":aquamarine_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":aquamarine_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":aquamarine_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_HOE.get())
                .pattern(" SS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":aquamarine_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AquamarineSet.AQUAMARINE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);
        
        
        
        
        
        
        
        
        
        
        
        







        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":ruby_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_AXE.get())
                .pattern(" SS")
                .pattern(" #S")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":ruby_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":ruby_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_HOE.get())
                .pattern(" SS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', RubySet.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":ruby_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubySet.RUBY_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', RubySet.RUBY.get())
                .unlockedBy(getHasName(RubySet.RUBY.get()), has(RubySet.RUBY.get()))
                .save(pWriter);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

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

        
        
        
        
        
        
        
        

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_HELMET.get())
                .pattern("SAS")
                .pattern("S S")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SAS")
                .pattern("SSS")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_LEGGINGS.get())
                .pattern("SAS")
                .pattern("S S")
                .pattern("S S")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_BOOTS.get())
                .pattern("S S")
                .pattern("A A")
                .define('A', Items.OBSIDIAN)
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_PICKAXE.get())
                .pattern("SAS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_SWORD.get())
                .pattern(" S ")  
                .pattern(" A ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_AXE.get())
                .pattern("SA ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_AXE.get())
                .pattern(" AS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_SHOVEL.get())
                .pattern(" A ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_HOE.get())
                .pattern("SA ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())  
                .define('#', Misc.IRON_STICK.get())                     
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pWriter, ExampleMod.MOD_ID + ":obsidian_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ObsidiumSet.OBSIDIUM_HOE.get())
                .pattern(" AS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('A', Items.OBSIDIAN)  
                .define('S', ObsidiumSet.OBSIDIUM_INGOT.get())  
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
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_AXE.get())
                .pattern(" AA")
                .pattern(" #A")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_HOE.get())
                .pattern("AA ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_HOE.get())
                .pattern(" AA")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":rose_gold_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RoseGoldSet.ROSE_GOLD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', RoseGoldSet.ROSE_GOLD_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(RoseGoldSet.ROSE_GOLD_INGOT.get()), has(RoseGoldSet.ROSE_GOLD_INGOT.get()))
                .save(pWriter);











        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AQUAMARINE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', AquamarineSet.AQUAMARINE.get())
                .unlockedBy(getHasName(AquamarineSet.AQUAMARINE.get()), has(AquamarineSet.AQUAMARINE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AquamarineSet.AQUAMARINE.get(), 9)
                .requires(ModBlocks.AQUAMARINE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.AQUAMARINE_BLOCK.get()), has(ModBlocks.AQUAMARINE_BLOCK.get()))
                .save(pWriter);

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
                .save(pWriter); */

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUXITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', VoltiumSet.FLUXITE.get())
                .unlockedBy(getHasName(VoltiumSet.FLUXITE.get()), has(VoltiumSet.FLUXITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VoltiumSet.FLUXITE.get(), 9)
                .requires(ModBlocks.FLUXITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FLUXITE_BLOCK.get()), has(ModBlocks.FLUXITE_BLOCK.get()))
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
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_PICKAXE.get())
                .pattern("SSS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSet.SOULFORGED_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSet.SOUL_ESSENCE.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSet.SOUL_ESSENCE.get()), has(SoulSet.SOUL_ESSENCE.get()))
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
                .save(pWriter, ExampleMod.MOD_ID + ":cobalt_hoe_2"); */












        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
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
                .save(pWriter, ExampleMod.MOD_ID + ":keyolite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, KeyoliteSet.KEYOLITE_HOE.get())
                .pattern(" SS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', KeyoliteSet.KEYOLITE_INGOT.get())
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(KeyoliteSet.KEYOLITE_INGOT.get()), has(KeyoliteSet.KEYOLITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":keyolite_hoe_2");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


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
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
                .unlockedBy(getHasName(SoulSteelSet.SOUL_STEEL_INGOT.get()), has(SoulSteelSet.SOUL_STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":soul_steel_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SoulSteelSet.SOUL_STEEL_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', SoulSteelSet.SOUL_STEEL_INGOT.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())
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
                .define('#', Misc.OBSIDIAN_STICK.get())                     
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_SWORD.get())
                .pattern(" S ")  
                .pattern(" S ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())                 
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_AXE.get())
                .pattern("SS ")  
                .pattern("S# ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())                
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_AXE.get())
                .pattern(" SS")  
                .pattern(" #S")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())                   
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_SHOVEL.get())
                .pattern(" S ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())                  
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_HOE.get())
                .pattern("SS ")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())                     
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":starrite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, StarriteSet.STARRITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', StarriteSet.STARRITE.get())  
                .define('#', Misc.OBSIDIAN_STICK.get())                    
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

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, StarPlatinumSet.STAR_BREAKER.get())
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" # ")
                .define('B', ModBlocks.STAR_PLATINUM_BLOCK.get())
                .define('S', StarPlatinumSet.STAR_PLATINUM_INGOT.get())
                .define('#', Misc.IRON_STICK.get())
                .unlockedBy(getHasName(StarPlatinumSet.STAR_PLATINUM_INGOT.get()), has(StarPlatinumSet.STAR_PLATINUM_INGOT.get()))
                .save(pWriter);








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
                .save(pWriter, ExampleMod.MOD_ID + ":resonite_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ResoniteSet.RESONITE_HOE.get())
                .pattern(" SS")  
                .pattern(" # ")
                .pattern(" # ") 
                .define('S', ResoniteSet.RESONITE_INGOT.get())
                .define('#', Misc.IRON_STICK.get())                    
                .unlockedBy(getHasName(ResoniteSet.RESONITE_INGOT.get()), has(ResoniteSet.RESONITE_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":resonite_hoe_2");








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
                .define('#', Misc.OBSIDIAN_STICK.get())
                .define('A', Items.SPECTRAL_ARROW)
                .unlockedBy(getHasName(StarriteSet.STARRITE.get()), has(StarriteSet.STARRITE.get()))
                .save(pWriter);











        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', SteelSet.STEEL_INGOT.get())
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_PICKAXE.get())
                .pattern("AAA")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_AXE.get())
                .pattern("AA ")
                .pattern("A# ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":steel_axe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_AXE.get())
                .pattern(" AA")
                .pattern(" #A")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":steel_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_HOE.get())
                .pattern("AA ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":steel_hoe_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_HOE.get())
                .pattern(" AA")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter, ExampleMod.MOD_ID + ":steel_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SteelSet.STEEL_SHOVEL.get())
                .pattern(" A ")
                .pattern(" # ")
                .pattern(" # ")
                .define('A', SteelSet.STEEL_INGOT.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(SteelSet.STEEL_INGOT.get()), has(SteelSet.STEEL_INGOT.get()))
                .save(pWriter);





















        // 1. The Smithing Upgrade Recipe
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()), // Your template
                            Ingredient.of(KeyoliteSet.KEYOLITE_SWORD.get()),                    // Base item
                            Ingredient.of(LunarisSet.LUNARIS.get()),           // Upgrade material
                            RecipeCategory.COMBAT,
                            LunarisSet.LUNARIS_SWORD.get()                           // Resulting item
                    )
                    .unlocks("has_lunaris", has(LunarisSet.LUNARIS.get()))
                    .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_sword_smithing")); // Use pWriter here

            // 2. The Template Duplication Recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                    .pattern("D#D")
                    .pattern("DTD")
                    .pattern("DDD")
                    .define('D', Items.DIAMOND)
                    .define('T', LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get())
                    .define('#', Items.PURPUR_BLOCK) // Replace with your own block if desired
                    .unlockedBy("has_lunaris_upgrade_template", has(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get()))
                    .save(pWriter, new ResourceLocation(ExampleMod.MOD_ID, "lunaris_upgrade_template_duplication")); // Use pWriter here
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