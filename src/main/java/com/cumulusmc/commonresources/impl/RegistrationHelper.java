package com.cumulusmc.commonresources.impl;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistrationHelper {
    public static void makeItem(String s, Item i) {
        Registry.register(Registry.ITEM, CommonResources.id(s), i);
    }

    public static void makeBlock(String s, Block b, Item.Settings settings) {
        Identifier id = CommonResources.id(s);
        Registry.register(Registry.BLOCK, id, b);
        Registry.register(Registry.ITEM, id, new BlockItem(b, settings));
    }
}
