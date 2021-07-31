package com.cumulusmc.commonresources.api;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class FormProducer implements Consumer<Material> {
    public static final HashMap<String, FormProducer> PRODUCERS = new HashMap<>();

    private String name;

    private FormProducer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private static FormProducer add(FormProducer producer) {
        return PRODUCERS.putIfAbsent(producer.getName(), producer);
    }

    public static Supplier<FormProducer> of(String s, Consumer<Material> consumer) {
        return () -> add(new FormProducer(s) {
            @Override
            public void accept(Material material) {
                consumer.accept(material);
            }
        });
    }
}
