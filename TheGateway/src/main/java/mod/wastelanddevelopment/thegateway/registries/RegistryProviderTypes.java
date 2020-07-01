package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.settings.BiomeProviderSettingsTheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.biome_providers.BiomeProviderTheGateway;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryProviderTypes {
	public static final DeferredRegister<BiomeProviderType<?,?>> BIOME_PROVIDER_TYPES = new DeferredRegister<>(ForgeRegistries.BIOME_PROVIDER_TYPES, TheGateway.MOD_ID);

	public static final RegistryObject<BiomeProviderType<BiomeProviderSettingsTheGateway, BiomeProviderTheGateway>> THE_GATEWAY = BIOME_PROVIDER_TYPES.register("biome_provider_type_the_gateway",
			() -> new BiomeProviderType<BiomeProviderSettingsTheGateway, BiomeProviderTheGateway>(BiomeProviderTheGateway::new, BiomeProviderSettingsTheGateway::new));







	public static void registerProviderTypes(){
		BIOME_PROVIDER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
