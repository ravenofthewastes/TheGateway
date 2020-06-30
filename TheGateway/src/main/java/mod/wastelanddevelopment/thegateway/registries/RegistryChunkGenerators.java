package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.chunk_generators.ChunkGeneratorTheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.settings.GenSettingsTheGateway;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryChunkGenerators {
	public static final DeferredRegister<ChunkGeneratorType<?,?>> CHUNK_GENERATOR_TYPES = new DeferredRegister<>(ForgeRegistries.CHUNK_GENERATOR_TYPES, TheGateway.MOD_ID);




	public static final RegistryObject<ChunkGeneratorType<GenSettingsTheGateway, ChunkGeneratorTheGateway>> THE_GATEWAY = CHUNK_GENERATOR_TYPES.register("chunk_generator_type_the_gateway",
			() -> new ChunkGeneratorType<GenSettingsTheGateway, ChunkGeneratorTheGateway>(ChunkGeneratorTheGateway::new,true, GenSettingsTheGateway::new));












	public static void registerChunkGen(){
		CHUNK_GENERATOR_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
