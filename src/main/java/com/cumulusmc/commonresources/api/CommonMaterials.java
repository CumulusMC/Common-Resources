package com.cumulusmc.commonresources.api;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.registry.Registry;

public class CommonMaterials {
    public static final Material WOOD = Material.Builder.of("wood")
            .putBool("vanilla", true)
            .putBool("wood", true)
            .putInt("tool_mining_level", ToolMaterials.WOOD.getMiningLevel())
            .putInt("tool_durability", ToolMaterials.WOOD.getDurability())
            .putFloat("mining_speed", ToolMaterials.WOOD.getMiningSpeedMultiplier())
            .putFloat("attack_damage", ToolMaterials.WOOD.getAttackDamage())
            .putInt("tool_enchantability", ToolMaterials.WOOD.getEnchantability())
            .putIngredient("tool_repair_item", ToolMaterials.WOOD.getRepairIngredient())
            .putString("tool_prefix", "wooden")
            .putBool("tools", true)
            .build();
    
    public static final Material STONE = Material.Builder.of("stone")
            .putBool("vanilla", true)
            .putBool("stone", true)
            .putInt("tool_mining_level", ToolMaterials.STONE.getMiningLevel())
            .putInt("tool_durability", ToolMaterials.STONE.getDurability())
            .putFloat("mining_speed", ToolMaterials.STONE.getMiningSpeedMultiplier())
            .putFloat("attack_damage", ToolMaterials.STONE.getAttackDamage())
            .putInt("tool_enchantability", ToolMaterials.STONE.getEnchantability())
            .putIngredient("tool_repair_item", ToolMaterials.STONE.getRepairIngredient())
            .putBool("tools", true)
            .build();

    public static final Material OBSIDIAN = Material.Builder.of("obsidian")
            .putBool("vanilla", true)
            .putBool("stone", true)
            .build();
    
    // TODO: Define obsidian tools and armor values

    public static final Material IRON = Material.Builder.of("iron")
            .putBool("vanilla", true)
            .putBool("metal", true)
            .putInt("tool_mining_level", ToolMaterials.IRON.getMiningLevel())
            .putInt("tool_durability", ToolMaterials.IRON.getDurability())
            .putFloat("mining_speed", ToolMaterials.IRON.getMiningSpeedMultiplier())
            .putFloat("attack_damage", ToolMaterials.IRON.getAttackDamage())
            .putInt("tool_enchantability", ToolMaterials.IRON.getEnchantability())
            .putIngredient("tool_repair_item", ToolMaterials.IRON.getRepairIngredient())
            .putBool("tools", true)
            .putInt("helmet_protection", ArmorMaterials.IRON.getProtectionAmount(EquipmentSlot.HEAD))
            .putInt("chestplate_protection", ArmorMaterials.IRON.getProtectionAmount(EquipmentSlot.CHEST))
            .putInt("leggings_protection", ArmorMaterials.IRON.getProtectionAmount(EquipmentSlot.LEGS))
            .putInt("boots_protection", ArmorMaterials.IRON.getProtectionAmount(EquipmentSlot.FEET))
            .putInt("armor_durability", 15)
            .putInt("armor_enchantability", ArmorMaterials.IRON.getEnchantability())
            .putFloat("armor_toughness", ArmorMaterials.IRON.getToughness())
            .putFloat("armor_knockback_resistance", ArmorMaterials.IRON.getKnockbackResistance())
            .putRegistryBacked("armor_sound_event", Registry.SOUND_EVENT.getKey(ArmorMaterials.IRON.getEquipSound()).get())
            .putIngredient("armor_repair_ingredient", ToolMaterials.IRON.getRepairIngredient())
            .putBool("armor", true)
            .putInt("ore_mining_level", MiningLevels.STONE)
            .build();

    public static final Material GOLD = Material.Builder.of("gold")
            .putBool("vanilla", true)
            .putBool("metal", true)
            .putInt("tool_mining_level", ToolMaterials.GOLD.getMiningLevel())
            .putInt("tool_durability", ToolMaterials.GOLD.getDurability())
            .putFloat("mining_speed", ToolMaterials.GOLD.getMiningSpeedMultiplier())
            .putFloat("attack_damage", ToolMaterials.GOLD.getAttackDamage())
            .putInt("tool_enchantability", ToolMaterials.GOLD.getEnchantability())
            .putIngredient("tool_repair_item", ToolMaterials.GOLD.getRepairIngredient())
            .putBool("tools", true)
            .putString("tool_prefix", "golden")
            .putInt("helmet_protection", ArmorMaterials.GOLD.getProtectionAmount(EquipmentSlot.HEAD))
            .putInt("chestplate_protection", ArmorMaterials.GOLD.getProtectionAmount(EquipmentSlot.CHEST))
            .putInt("leggings_protection", ArmorMaterials.GOLD.getProtectionAmount(EquipmentSlot.LEGS))
            .putInt("boots_protection", ArmorMaterials.GOLD.getProtectionAmount(EquipmentSlot.FEET))
            .putInt("armor_durability", 7)
            .putInt("armor_enchantability", ArmorMaterials.GOLD.getEnchantability())
            .putFloat("armor_toughness", ArmorMaterials.GOLD.getToughness())
            .putFloat("armor_knockback_resistance", ArmorMaterials.GOLD.getKnockbackResistance())
            .putRegistryBacked("armor_sound_event", Registry.SOUND_EVENT.getKey(ArmorMaterials.GOLD.getEquipSound()).get())
            .putIngredient("armor_repair_ingredient", ToolMaterials.GOLD.getRepairIngredient())
            .putString("armor_prefix", "golden")
            .putBool("armor", true)
            .putInt("nether_ore_max_exp", 1)
            .putInt("ore_mining_level", MiningLevels.IRON)
            .build();

    public static final Material DIAMOND = Material.Builder.of("diamond")
            .putBool("vanilla", true)
            .putBool("gem", true)
            .putInt("tool_mining_level", ToolMaterials.DIAMOND.getMiningLevel())
            .putInt("tool_durability", ToolMaterials.DIAMOND.getDurability())
            .putFloat("mining_speed", ToolMaterials.DIAMOND.getMiningSpeedMultiplier())
            .putFloat("attack_damage", ToolMaterials.DIAMOND.getAttackDamage())
            .putInt("tool_enchantability", ToolMaterials.DIAMOND.getEnchantability())
            .putIngredient("tool_repair_item", ToolMaterials.DIAMOND.getRepairIngredient())
            .putBool("tools", true)
            .putInt("helmet_protection", ArmorMaterials.DIAMOND.getProtectionAmount(EquipmentSlot.HEAD))
            .putInt("chestplate_protection", ArmorMaterials.DIAMOND.getProtectionAmount(EquipmentSlot.CHEST))
            .putInt("leggings_protection", ArmorMaterials.DIAMOND.getProtectionAmount(EquipmentSlot.LEGS))
            .putInt("boots_protection", ArmorMaterials.DIAMOND.getProtectionAmount(EquipmentSlot.FEET))
            .putInt("armor_durability", 33)
            .putInt("armor_enchantability", ArmorMaterials.DIAMOND.getEnchantability())
            .putFloat("armor_toughness", ArmorMaterials.DIAMOND.getToughness())
            .putFloat("armor_knockback_resistance", ArmorMaterials.DIAMOND.getKnockbackResistance())
            .putRegistryBacked("armor_sound_event", Registry.SOUND_EVENT.getKey(ArmorMaterials.DIAMOND.getEquipSound()).get())
            .putIngredient("armor_repair_ingredient", ToolMaterials.DIAMOND.getRepairIngredient())
            .putBool("armor", true)
            .putInt("ore_mining_level", MiningLevels.IRON)
            .putInt("ore_min_exp", 3)
            .putInt("ore_max_exp", 7)
            .build();

    public static final Material NETHERITE = Material.Builder.of("netherite")
            .putBool("vanilla", true)
            .putBool("metal", true)
            .putInt("tool_mining_level", ToolMaterials.NETHERITE.getMiningLevel())
            .putInt("tool_durability", ToolMaterials.NETHERITE.getDurability())
            .putFloat("mining_speed", ToolMaterials.NETHERITE.getMiningSpeedMultiplier())
            .putFloat("attack_damage", ToolMaterials.NETHERITE.getAttackDamage())
            .putInt("tool_enchantability", ToolMaterials.NETHERITE.getEnchantability())
            .putIngredient("tool_repair_item", ToolMaterials.NETHERITE.getRepairIngredient())
            .putBool("tools", true)
            .putInt("helmet_protection", ArmorMaterials.NETHERITE.getProtectionAmount(EquipmentSlot.HEAD))
            .putInt("chestplate_protection", ArmorMaterials.NETHERITE.getProtectionAmount(EquipmentSlot.CHEST))
            .putInt("leggings_protection", ArmorMaterials.NETHERITE.getProtectionAmount(EquipmentSlot.LEGS))
            .putInt("boots_protection", ArmorMaterials.NETHERITE.getProtectionAmount(EquipmentSlot.FEET))
            .putInt("armor_durability", 37)
            .putInt("armor_enchantability", ArmorMaterials.NETHERITE.getEnchantability())
            .putFloat("armor_toughness", ArmorMaterials.NETHERITE.getToughness())
            .putFloat("armor_knockback_resistance", ArmorMaterials.NETHERITE.getKnockbackResistance())
            .putRegistryBacked("armor_sound_event", Registry.SOUND_EVENT.getKey(ArmorMaterials.NETHERITE.getEquipSound()).get())
            .putIngredient("armor_repair_ingredient", ToolMaterials.NETHERITE.getRepairIngredient())
            .putInt("ore_mining_level", MiningLevels.DIAMOND)
            .putBool("armor", true)
            .build();
    
    // TODO: Emerald, Amethyst, Quartz, Copper

    // TODO: Aluminum, Brass, Bronze, Chrome, Electrum, Invar, Iridium, Lead, Nickel, Platinum, Silver, Steel, Tin
    //  Titanium, Tungsten, Zinc, Metite, Stellum, Univite, Pyrite, Ruby, Sapphire, Peridot, Red Garnet, Yellow Garnet,
    //  Asterite, Galaxium

    public static void onInitialize() { }
}
