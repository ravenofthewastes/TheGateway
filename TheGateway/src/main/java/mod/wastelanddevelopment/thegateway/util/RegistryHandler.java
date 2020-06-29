package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.registries.RegistryBiomes;
import mod.wastelanddevelopment.thegateway.registries.RegistryBlocks;
import mod.wastelanddevelopment.thegateway.registries.RegistryChunkGenerators;
import mod.wastelanddevelopment.thegateway.registries.RegistryDims;
import mod.wastelanddevelopment.thegateway.registries.RegistryFeatures;
import mod.wastelanddevelopment.thegateway.registries.RegistryItems;
import mod.wastelanddevelopment.thegateway.registries.RegistryProviderTypes;

public class RegistryHandler {

	
	public static void init() {
		RegistryItems.registerItems();
		RegistryBlocks.registerBlocks();
		RegistryDims.registerDims();
		RegistryBiomes.registerBiomes();
		RegistryFeatures.registerFeatures();
		RegistryProviderTypes.registerProviderTypes();
		RegistryChunkGenerators.registerChunkGen();
	}
	
}
