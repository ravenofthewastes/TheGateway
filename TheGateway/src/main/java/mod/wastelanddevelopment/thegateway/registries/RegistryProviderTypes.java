package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryProviderTypes {
	public static final DeferredRegister<BiomeProviderType<?,?>> BIOME_PROVIDER_TYPES = new DeferredRegister<>(ForgeRegistries.BIOME_PROVIDER_TYPES, TheGateway.MOD_ID);
	
	
	
	
	
	
	
	
	
	
	public static void registerProviderTypes(){
		BIOME_PROVIDER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
