package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.registries.RegistryBiomes;

public class BiomeFeaturesHandler {

    public static void handleFeatures(){
        TheGatewayDefaultBiomeFeatures.addCarvers(RegistryBiomes.PLAINS_BIOME.get());
        TheGatewayDefaultBiomeFeatures.addStoneVariants(RegistryBiomes.PLAINS_BIOME.get());
        TheGatewayDefaultBiomeFeatures.addDefaultOres(RegistryBiomes.PLAINS_BIOME.get());
    }
}
