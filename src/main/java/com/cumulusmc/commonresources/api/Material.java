package com.cumulusmc.commonresources.api;

import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.registry.RegistryKey;

import java.util.HashMap;
import java.util.Optional;

public class Material {
    public static final HashMap<String, Material> MATERIALS = new HashMap<>();

    private final HashMap<String, Object> PROPERTIES;

    private Material(HashMap<String, Object> properties) {
        this.PROPERTIES = properties;
    }

    public Material putInt(String key, Integer property) {
        PROPERTIES.putIfAbsent(key, property);
        return this;
    }

    public Material putFloat(String key, Float property) {
        PROPERTIES.putIfAbsent(key, property);
        return this;
    }

    public Material putBool(String key, Boolean property) {
        PROPERTIES.putIfAbsent(key, property);
        return this;
    }

    public Material putString(String key, String property) {
        PROPERTIES.putIfAbsent(key, property);
        return this;
    }

    public Material putIngredient(String key, Ingredient property) {
        PROPERTIES.putIfAbsent(key, property);
        return this;
    }

    public <T> Material putRegistryBacked(String key, RegistryKey<T> property) {
        PROPERTIES.putIfAbsent(key, property);
        return this;
    }

    public Boolean getBool(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof Boolean) {
            return (Boolean) property;
        }
        return false;
    }

    public Integer getInt(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof Integer) {
            return (Integer) property;
        }
        return 0;
    }

    public String getString(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof String) {
            return (String) property;
        }
        return "";
    }

    public Float getFloat(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof Float) {
            return (Float) property;
        }
        return 0.0f;
    }

    public Ingredient getIngredient(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof Ingredient) {
            return (Ingredient) property;
        }
        return Ingredient.empty();
    }

    public <T> Optional<RegistryKey<T>> getRegistryBacked(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof RegistryKey) {
            return Optional.of((RegistryKey<T>) property);
        }
        return Optional.empty();
    }

    public TriState getTriState(String key) {
        Object property = PROPERTIES.get(key);
        if (property instanceof Boolean) {
            return TriState.of((Boolean) property);
        }
        return TriState.DEFAULT;
    }

    private static Material add(Material material) {
        if (MATERIALS.containsKey(material.getName())) {
            return MATERIALS.get(material.getName());
        } else {
            MATERIALS.put(material.getName(), material);
            return material;
        }
    }

    public String getName() {
        return this.getString("name");
    }

    public static class Builder {
        private final HashMap<String, Object> PROPERTIES = new HashMap<>();

        public Builder(String name) {
            this.putString("name", name);
        }

        public static Material.Builder of(String name) {
            return new Material.Builder(name);
        }

        public Material.Builder putInt(String key, Integer property) {
            this.putProperly(key, property);
            return this;
        }

        public Material.Builder putFloat(String key, Float property) {
            this.putProperly(key, property);
            return this;
        }

        public Material.Builder putBool(String key, Boolean property) {
            this.putProperly(key, property);
            return this;
        }

        public Material.Builder putString(String key, String property) {
            this.putProperly(key, property);
            return this;
        }

        public Material.Builder putIngredient(String key, Ingredient property) {
            this.putProperly(key, property);
            return this;
        }

        public <T> Material.Builder putRegistryBacked(String key, RegistryKey<T> property) {
            this.putProperly(key, property);
            return this;
        }

        private void putProperly(String key, Object property) {
            if (Material.MATERIALS.containsKey(this.getName())) {
                Material.MATERIALS.get(this.getName()).PROPERTIES.putIfAbsent(key, property);
                return;
            }
            this.PROPERTIES.putIfAbsent(key, property);
        }

        public String getName() {
            return this.getString("name");
        }

        private String getString(String key) {
            Object property = PROPERTIES.get(key);
            if (property instanceof String) {
                return (String) property;
            }
            return "";
        }

        public Material build() {
            return Material.add(new Material(this.PROPERTIES));
        }
    }
}
