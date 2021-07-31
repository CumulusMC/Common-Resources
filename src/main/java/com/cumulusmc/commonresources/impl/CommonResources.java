package com.cumulusmc.commonresources.impl;

import com.cumulusmc.commonresources.api.FormProducer;
import com.cumulusmc.commonresources.api.Material;
import com.cumulusmc.commonresources.api.ResourceEntrypoint;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.entrypoint.minecraft.hooks.EntrypointUtils;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class CommonResources implements ModInitializer {
	
	@Override
	public void onInitialize() {
		EntrypointUtils.invoke("common_resource", ResourceEntrypoint.class, ResourceEntrypoint::initializeResources);
		FormProducer.PRODUCERS.values().forEach((producer) -> Material.MATERIALS.values().forEach(producer));
	}

	public static Identifier id(String s) {
		return new Identifier("c", s);
	}
}
