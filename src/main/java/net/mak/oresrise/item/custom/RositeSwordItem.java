package net.mak.oresrise.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class RositeSwordItem extends SwordItem {

    public RositeSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.putAll(super.getDefaultAttributeModifiers(slot));

        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(
                    ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(
                            UUID.fromString("a1b2c3d4-e5f6-7890-abcd-123456789004"),
                            "Rosite Attack Reach",
                            2.0,
                            AttributeModifier.Operation.ADDITION
                    )
            );
        }

        return builder.build();
    }
}
