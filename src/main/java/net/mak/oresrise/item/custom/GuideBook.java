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

        tag.put("pages", pages);

        return book;
    }
}