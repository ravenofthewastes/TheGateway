package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.registries.*;

public class RegistryHandler {

	
	public static void init() {
		RegistryItems.registerItems();
		RegistryBlocks.registerBlocks();
		RegistryDims.registerDims();
		RegistryBiomes.registerBiomes();
		RegistryFeatures.registerFeatures();
		RegistryProviderTypes.registerProviderTypes();
		RegistryChunkGenerators.registerChunkGen();
		RegistryWorldCarvers.registerCarvers();
	}
	
}
