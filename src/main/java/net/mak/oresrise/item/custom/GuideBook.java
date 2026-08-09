package net.mak.oresrise.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class GuideBook {

    public static ItemStack createBook() {

        ItemStack book = new ItemStack(Items.WRITTEN_BOOK);

        CompoundTag tag = book.getOrCreateTag();

        tag.putString("title", "Ore Guide");
        tag.putString("author", "_bosnianguy");

        ListTag pages = new ListTag();

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Introduction\n\n" +
                                "Welcome to Ores Rise!\n\n" +
                                        "This guide will help you discover the new ores, armors, and weapons."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Chapter 1: Early Alloys\n\n" +
                                        "Rose Gold:\n" +
                                        "Rose Gold is an alloy of gold and copper.\n" +
                                        "It combines gold's speed with improved durability, creating a fast but reliable material."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Steel:\n" +
                                        "Steel is an alloy created from iron and coal.\n" +
                                        "It is faster and more durable than normal iron equipment.\n"

                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Rosite:\n" +
                                        "Rosite is an alloy created using iron and redstone.\n" +
                                        "It combines the strength of iron with the energy of redstone.\n"

                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Chapter 2: Ores\n\n" +
                                        "Ruby:\n" +
                                        "Ruby is a rare gemstone with strength comparable to diamond.\n" +
                                        "Tools and armor made from Ruby have the same durability and effectiveness as diamond equipment.\n" +
                                        "Ruby armor grants the wearer regeneration."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Sapphire:\n" +
                                        "Sapphire is a rare blue gemstone with power comparable to diamond.\n" +
                                        "Tools and armor crafted from Sapphire are equal in strength to diamond equipment, offering excellent durability and performance.\n" +
                                        "Sapphire armor grants the wearer the ability to breathe underwater, making it useful for exploring oceans, rivers, and underwater structures.\n"

                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Aquamarine:\n" +
                                        "Aquamarine is a rare ocean gemstone.\n" +
                                        "Aquamarine equipment is useful for exploring underwater areas.\n" +
                                        "Aquamarine armor grants the wearer dolphins grace."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Platinum:\n" +
                                        "Platinum is a rare metal with strength comparable to diamond.\n" +
                                        "Tools and armor made from Platinum have the same durability and effectiveness as diamond equipment.\n" +
                                        "Platinum armor grants the wearer resistance."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Fluxite:\n" +
                                        "Fluxite is a powerful energy crystal.\n" +
                                        "It is used to create an advanced alloy, Voltium."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Spectral Fragment:\n" +
                                        "Spectral Fragments are pieces of condensed soul energy.\n" +
                                        "They can be combined to create Spectral Gems."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Chapter 3: Enhanced Materials\n\n" +
                                        "Keyolite:\n" +
                                        "Keyolite is created by combining Rosite Ingots with Ender Pearls and Amethyst.\n" +
                                        "Keyolite armor grants the wearer slow falling."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Chapter 4: Advanced Recipes\n\n" +
                                        "Spectral Gem:\n" +
                                        "Spectral Gems are created by combining multiple Spectral Fragments.\n" +
                                        "They are used to create Spectral Essences."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Spectral Essence:\n" +
                                        "Spectral Essence is the refined form of soul energy.\n" +
                                        "It is used to create Soulforged armor and tools."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Chapter 5: Advanced Materials\n\n" +
                                        "Voltium:\n" +
                                        "Voltium is a powerful alloy created from Fluxite, Steel, and Quartz.\n" +
                                        "It combines the strength of metal with the power of electricity."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Dreadsteel:\n" +
                                        "Dreadsteel is a powerful material created using Soul Essence and Netherite.\n" +
                                        "Dreadsteel equipment is stronger than netherite.\n" +
                                        "Dreadsteel armor grants the wearer Soul Speed III while wearing the full set."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Chapter 6: Rare Ores\n\n" +
                                "Lunaris:\n" +
                                        "Lunaris is a rare crystal used to create advanced equipment.\n" +
                                        "Lunaris swords can launch enemies into the air with their special ability."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Onyx:\n" +
                                        "Onyx is a dark gemstone used to create powerful weapons and armor.\n" +
                                        "Onyx swords can perform backstabs, dealing extra damage and applying blindness to enemies."
                        )
                )
        ));

        pages.add(StringTag.valueOf(
                Component.Serializer.toJson(
                        Component.literal(
                                "Crypton:\n" +
                                        "Crypton is a rare material used to create advanced equipment.\n" +
                                        "Its unique properties make it valuable for powerful tools and armor."
                        )
                )
        ));

        tag.put("pages", pages);

        return book;
    }
}