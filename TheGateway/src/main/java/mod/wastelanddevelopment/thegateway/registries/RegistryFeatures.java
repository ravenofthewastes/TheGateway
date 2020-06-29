package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryFeatures {
	public static final DeferredRegister<Feature<?>> BIOME_FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, TheGateway.MOD_ID);
	
	
	
	
	
	
	
	
	
	
	
	public static void registerFeatures(){
		BIOME_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
