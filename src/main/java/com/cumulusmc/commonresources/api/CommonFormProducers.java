package com.cumulusmc.commonresources.api;

import com.cumulusmc.commonresources.impl.*;
import com.cumulusmc.commonresources.impl.AxeItem;
import com.cumulusmc.commonresources.impl.HoeItem;
import com.cumulusmc.commonresources.impl.PickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.block.MapColor;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.Optional;
import java.util.function.Supplier;

public class CommonFormProducers {

    public static final Supplier<FormProducer> INGOT = FormProducer.of("ingot", (material) -> {
        if ((!material.getBool("vanilla") && material.getBool("metal")) || material.getBool("ingot")) {
            RegistrationHelper.makeItem(material.getName() + "_ingot", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        }
    });

    public static final Supplier<FormProducer> RAW_ORE = FormProducer.of("raw_ore", (material) -> {
        if ((!material.getBool("vanilla") && material.getBool("metal")) || material.getBool("raw_ore")) {
            RegistrationHelper.makeItem("raw_" + material.getName(), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        }
    });

    public static final Supplier<FormProducer> NUGGET = FormProducer.of("nugget", (material) -> {
        if ((!material.getBool("vanilla") && material.getBool("metal")) || material.getBool("nugget")) {
            RegistrationHelper.makeItem(material.getName() + "_nugget", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        }
    });

    public static final Supplier<FormProducer> TOOLS = FormProducer.of("tools", (material) -> {
        if ((!material.getBool("vanilla") && material.getBool("tools"))) {
            ToolMaterial toolMaterial = new SimpleToolMaterial(
                    material.getInt("tool_durability"),
                    material.getFloat("mining_speed"),
                    material.getFloat("attack_damage"),
                    material.getInt("tool_mining_level"),
                    material.getInt("tool_enchantability"),
                    material.getIngredient("tool_repair_item"));

            String name = material.getString("tool_prefix").equals("") ? material.getName() : material.getString("tool_prefix");

            RegistrationHelper.makeItem(name + "_sword", new SwordItem(toolMaterial, 3, -2.4f, new FabricItemSettings().group(ItemGroup.COMBAT)));
            RegistrationHelper.makeItem(name + "_shovel", new ShovelItem(toolMaterial, 1.5f, -3.0f, new FabricItemSettings().group(ItemGroup.TOOLS)));
            RegistrationHelper.makeItem(name + "_pickaxe", new PickaxeItem(toolMaterial, 1, -2.8F, new FabricItemSettings().group(ItemGroup.TOOLS)));
            RegistrationHelper.makeItem(name + "_axe", new AxeItem(toolMaterial, 6.0F, -3.2F, new FabricItemSettings().group(ItemGroup.TOOLS)));
            RegistrationHelper.makeItem(name + "_hoe", new HoeItem(toolMaterial, 0, -3.0F, new FabricItemSettings().group(ItemGroup.TOOLS)));
        }
    });

    public static final Supplier<FormProducer> ARMOR = FormProducer.of("armor", (material) -> {
        if ((!material.getBool("vanilla") && material.getBool("armor"))) {

            SoundEvent equipEvent;
            Optional<RegistryKey<SoundEvent>> eventKey = material.getRegistryBacked("armor_sound_event");
            if (eventKey.isPresent()) {
                if (Registry.SOUND_EVENT.contains(eventKey.get())) {
                    equipEvent = Registry.SOUND_EVENT.get(eventKey.get());
                } else {
                    equipEvent = SoundEvents.ITEM_ARMOR_EQUIP_IRON;
                }
            } else {
                equipEvent = SoundEvents.ITEM_ARMOR_EQUIP_IRON;
            }

            ArmorMaterial armorMaterial = new SimpleArmorMaterial(
                    material.getName(),
                    material.getInt("armor_durability"),
                    new int[]{material.getInt("boots_protection"), material.getInt("leggings_protection"), material.getInt("chestplate_protection"), material.getInt("helmet_protection")},
                    material.getInt("armor_enchantability"),
                    equipEvent,
                    material.getIngredient("armor_repair_item"),
                    material.getFloat("armor_toughness"),
                    material.getFloat("armor_knockback_resistance")
            );

            String name = material.getString("armor_prefix").equals("") ? material.getName() : material.getString("armor_prefix");

            RegistrationHelper.makeItem(name + "_helmet", new ArmorItem(armorMaterial, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT)));
            RegistrationHelper.makeItem(name + "_chestplate", new ArmorItem(armorMaterial, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT)));
            RegistrationHelper.makeItem(name + "_leggings", new ArmorItem(armorMaterial, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT)));
            RegistrationHelper.makeItem(name + "_boots", new ArmorItem(armorMaterial, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT)));
        }
    });

    public static final Supplier<FormProducer> ORE = FormProducer.of("ore", (material) -> {
        if (!material.getBool("vanilla") && !material.getTriState("overworld_ore").equals(TriState.FALSE) && (material.getBool("metal") || material.getBool("gem"))) {
            RegistrationHelper.makeBlock(material.getName() + "_ore", new OreBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES).strength(3.0F, 3.0F), UniformIntProvider.create(material.getInt("ore_min_exp"), material.getInt("ore_max_exp"))), new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
            RegistrationHelper.makeBlock("deepslate_" + material.getName() + "_ore", new OreBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(material.getInt("ore_min_exp"), material.getInt("ore_max_exp"))), new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        }
        if (material.getBool("nether_ore")) {
            RegistrationHelper.makeBlock("nether_" + material.getName() + "_ore", new OreBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE, MapColor.DARK_RED).requiresTool().breakByTool(FabricToolTags.PICKAXES).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE), UniformIntProvider.create(material.getInt("nether_ore_min_exp"), material.getInt("nether_ore_max_exp"))), new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        }
        if (material.getBool("end_ore")) {
            RegistrationHelper.makeBlock("end_" + material.getName() + "_ore", new OreBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE, MapColor.PALE_YELLOW).requiresTool().breakByTool(FabricToolTags.PICKAXES).strength(3.0F, 3.0F), UniformIntProvider.create(material.getInt("end_ore_min_exp"), material.getInt("end_ore_max_exp"))), new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        }

    });

    // TODO: Blocks
    // TODO: Proper mining levels for shit
    // TODO: Ore generation

    public static final Supplier<FormProducer> GEAR = FormProducer.of("gear", (material) -> {
        if (material.getBool("metal") || material.getBool("gear")) {
            RegistrationHelper.makeItem(material.getName() + "_gear", new Item(new FabricItemSettings()));
        }
    });

    public static final Supplier<FormProducer> PLATE = FormProducer.of("plate", (material) -> {
        if (material.getBool("metal") || material.getBool("plate")) {
            RegistrationHelper.makeItem(material.getName() + "_plate", new Item(new FabricItemSettings()));
        }
    });

    public static final Supplier<FormProducer> ROD = FormProducer.of("rod", (material) -> {
        if (material.getBool("metal") || material.getBool("rod")) {
            RegistrationHelper.makeItem(material.getName() + "_rod", new Item(new FabricItemSettings()));
        }
    });

    public static final Supplier<FormProducer> WIRE = FormProducer.of("wire", (material) -> {
        if (material.getBool("metal") || material.getBool("wire")) {
            RegistrationHelper.makeItem(material.getName() + "_wire", new Item(new FabricItemSettings()));
        }
    });

    public static final Supplier<FormProducer> DUST = FormProducer.of("dust", (material) -> {
        if (material.getBool("metal") || material.getBool("dust")) {
            RegistrationHelper.makeItem(material.getName() + "_dust", new Item(new FabricItemSettings()));
        }
    });

    public static void onInitialize() {
        INGOT.get();
        RAW_ORE.get();
        NUGGET.get();
        TOOLS.get();
        ARMOR.get();
        ORE.get();
    }
}
