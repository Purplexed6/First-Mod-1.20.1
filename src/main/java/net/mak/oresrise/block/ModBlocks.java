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
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ROUGH_RUBY_BLOCK = registerBlock("rough_ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                        .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> ROSITE_BLOCK = registerBlock("rosite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ROUGH_VIBRANIUM_BLOCK = registerBlock("rough_vibranium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> VIBRANIUM_ORE = registerBlock("vibranium_ore",
            () -> new VibraniumOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    /* public static final RegistryObject<Block> OBLIVIONITE_BLOCK = registerBlock("oblivionite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> OBLIVIONITE_ORE = registerBlock("oblivionite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(15, 20))); */

    public static final RegistryObject<Block> WITHERITE_BLOCK = registerBlock("witherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WITHERITE_ORE = registerBlock("witherite_ore",
            () -> new WitheriteOreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(10, 15)));
    public static final RegistryObject<Block> RAW_WITHERITE_BLOCK = registerBlock("raw_witherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));

    public static final RegistryObject<Block> SOUL_ORE = registerBlock("soul_ore",
            () -> new SoulOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(7, 12)));
    public static final RegistryObject<Block> SOUL_BLOCK = registerBlock("soul_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> HEMOGEM_BLOCK = registerBlock("hemogem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> HEMOGEM_ORE = registerBlock("hemogem_ore",
            () -> new HemogemOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
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

    public static final RegistryObject<Block> CRYPTON_BLOCK = registerBlock("crypton_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CRYPTON_ORE = registerBlock("crypton_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
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

    public static final RegistryObject<Block> STARRITE_ORE = registerBlock("starrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 9)));
    public static final RegistryObject<Block> STARRITE_BLOCK = registerBlock("starrite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 9)));

    public static final RegistryObject<Block> STAR_PLATINUM_BLOCK = registerBlock("star_platinum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));

    /* public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 7))); */

    public static final RegistryObject<Block> MALACHITE_BLOCK = registerBlock("malachite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MALACHITE_ORE = registerBlock("malachite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 9)));
    public static final RegistryObject<Block> DEEPSLATE_MALACHITE_ORE = registerBlock("deepslate_malachite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 9)));

    public static final RegistryObject<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> KEYOLITE_BLOCK = registerBlock("keyolite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> OBSIDIUM_BLOCK = registerBlock("obsidium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.STONE)));


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
