package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.features.ore.TheGatewayOreFeature;
import mod.wastelanddevelopment.thegateway.world.dimension.features.ore.TheGatewayOreFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryFeatures {
	public static final DeferredRegister<Feature<?>> BIOME_FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, TheGateway.MOD_ID);



	public static final RegistryObject<Feature<TheGatewayOreFeatureConfig>> ORE = BIOME_FEATURES.register("ore", ()->new TheGatewayOreFeature(TheGatewayOreFeatureConfig::deserialize));








	public static void registerFeatures(){
		BIOME_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
