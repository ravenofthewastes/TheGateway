package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryChunkGenerators {
	public static final DeferredRegister<ChunkGeneratorType<?,?>> CHUNK_GENERATOR_TYPES = new DeferredRegister<>(ForgeRegistries.CHUNK_GENERATOR_TYPES, TheGateway.MOD_ID);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void registerChunkGen(){
		CHUNK_GENERATOR_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
