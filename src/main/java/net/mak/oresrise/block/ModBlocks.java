package net.mak.oresrise.block;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.custom.*;
import net.mak.oresrise.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ROUGH_SAPPHIRE_BLOCK = registerBlock("rough_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ROUGH_RUBY_BLOCK = registerBlock("rough_ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                        .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> ROSITE_BLOCK = registerBlock("rosite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SCOURIUM_BLOCK = registerBlock("scourium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCOUROUS_ORE = registerBlock("scourous_ore",
            () -> new PhasmicOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3,  7)));

    /* public static final RegistryObject<Block> OBLIVIONITE_BLOCK = registerBlock("oblivionite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> OBLIVIONITE_ORE = registerBlock("oblivionite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(15, 20))); */

    public static final RegistryObject<Block> WITHERITE_BLOCK = registerBlock("witherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> RAW_WITHERITE_BLOCK = registerBlock("raw_witherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));

    public static final RegistryObject<Block> SOUL_ORE = registerBlock("soul_ore",
            () -> new SoulOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> SOUL_BLOCK = registerBlock("soul_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> HEMOGEM_BLOCK = registerBlock("hemogem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> SANGUINE_ORE = registerBlock("sanguine_ore",
            () -> new HemogemOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> HYDROGEM_BLOCK = registerBlock("hydrogem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> HYDRIC_ORE = registerBlock("hydric_ore",
            () -> new HydrogemOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    /* public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> JADE_ORE = registerBlock("jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8))); */

    /*public static final RegistryObject<Block> QUINTESSITE_BLOCK = registerBlock("quintessite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> QUINTESSITE_ORE = registerBlock("quintessite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));*/

    public static final RegistryObject<Block> DREADSTEEL_BLOCK = registerBlock("dreadsteel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> LUNARIS_BLOCK = registerBlock("lunaris_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> LUNARIS_ORE = registerBlock("lunaris_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> COLLOSITE_BLOCK = registerBlock("colossite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> COLOSSAL_ORE = registerBlock("colossal_ore",
            () -> new ColossalOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> FLUXITE_BLOCK = registerBlock("fluxite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> VOLTIUM_BLOCK = registerBlock("voltium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> FLUXITE_ORE = registerBlock("fluxite_ore",
            () -> new FluxiteOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> ONYX_BLOCK = registerBlock("onyx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ONYX_ORE = registerBlock("onyx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> PHASMIC_ORE = registerBlock("phasmic_ore",
            () -> new PhasmicOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(10, 15)));
    public static final RegistryObject<Block> PHASMITE_BLOCK = registerBlock("phasmite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAGING_ORE = registerBlock("raging_ore",
            () -> new RagingOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> RAGEITE_BLOCK = registerBlock("rageite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));

    /* public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 7)));

    public static final RegistryObject<Block> MALACHITE_BLOCK = registerBlock("malachite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MALACHITE_ORE = registerBlock("malachite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 9)));
    public static final RegistryObject<Block> DEEPSLATE_MALACHITE_ORE = registerBlock("deepslate_malachite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 9)));*/

    public static final RegistryObject<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> KEYOLITE_BLOCK = registerBlock("keyolite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> OBSIDIUM_BLOCK = registerBlock("obsidium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.STONE)));

    public static final RegistryObject<Block> WAILING_ORE = registerBlock("wailing_ore",
            () -> new WailingOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 9)));
    public static final RegistryObject<Block> STARDUST_ORE = registerBlock("stardust_ore",
            () -> new StardustOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(10, 15)));





    public static final RegistryObject<Block> RUGITE_BLOCK = registerBlock("rugite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> POLISHED_RUGITE = registerBlock("polished_rugite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> RUGITE_BRICKS = registerBlock("rugite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.DEEPSLATE_TILES)));

   /* public static final RegistryObject<Block> RUGITE_STAIRS = registerBlock("rugite_stairs",
            () -> new StairBlock(() -> ModBlocks.RUGITE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> RUGITE_SLAB = registerBlock("rugite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> RUGITE_WALL = registerBlock("rugite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.TUFF)));

    public static final RegistryObject<Block> POLISHED_RUGITE_STAIRS = registerBlock("polished_rugite_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_RUGITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> POLISHED_RUGITE_SLAB = registerBlock("polished_rugite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> POLISHED_RUGITE_WALL = registerBlock("polished_rugite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.POLISHED_DEEPSLATE)));

    public static final RegistryObject<Block> RUGITE_BRICK_STAIRS = registerBlock("rugite_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.RUGITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> RUGITE_BRICK_SLAB = registerBlock("rugite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> RUGITE_BRICK_WALL = registerBlock("rugite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));*/





    public static final RegistryObject<Block> SOULSTONE_BLOCK = registerBlock("soulstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> POLISHED_SOULSTONE = registerBlock("polished_soulstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> SOULSTONE_BRICKS = registerBlock("soulstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.NETHER_BRICKS)));

    /*public static final RegistryObject<Block> SOULSTONE_STAIRS = registerBlock("soulstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SOULSTONE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> SOULSTONE_SLAB = registerBlock("soulstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> SOULSTONE_WALL = registerBlock("soulstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).sound(SoundType.CALCITE)));

    public static final RegistryObject<Block> POLISHED_SOULSTONE_STAIRS = registerBlock("polished_soulstone_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_SOULSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> POLISHED_SOULSTONE_SLAB = registerBlock("polished_soulstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> POLISHED_SOULSTONE_WALL = registerBlock("polished_soulstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.CALCITE)));

    public static final RegistryObject<Block> SOULSTONE_BRICK_STAIRS = registerBlock("soulstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SOULSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> SOULSTONE_BRICK_SLAB = registerBlock("soulstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> SOULSTONE_BRICK_WALL = registerBlock("soulstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.NETHER_BRICKS)));*/





    public static final RegistryObject<Block> ASTRALITE_BLOCK = registerBlock("astralite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> POLISHED_ASTRALITE = registerBlock("polished_astralite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> ASTRALITE_BRICKS = registerBlock("astralite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS).sound(SoundType.DEEPSLATE_BRICKS)));





    public static final RegistryObject<Block> ECHOROCK_BLOCK = registerBlock("echorock_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> POLISHED_ECHOROCK = registerBlock("polished_echorock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE).sound(SoundType.SCULK_CATALYST)));
    public static final RegistryObject<Block> ECHOROCK_BRICKS = registerBlock("echorock_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.SCULK_CATALYST)));





    public static final RegistryObject<Block> VOIDSTONE_BLOCK = registerBlock("voidstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> POLISHED_VOIDSTONE = registerBlock("polished_voidstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VOIDSTONE_BRICKS = registerBlock("voidstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).sound(SoundType.STONE)));






    public static final RegistryObject<Block> SOUL_MAGMA = registerBlock("soul_magma",
            () -> new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SOUL_GRAVEL = registerBlock("soul_gravel",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> SOULSTONE_QUARTZ_ORE = registerBlock("soulstone_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 7)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
