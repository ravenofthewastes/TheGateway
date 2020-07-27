package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.biome.TheGatewayPlainsBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryBiomes {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TheGateway.MOD_ID);



	public static final RegistryObject<Biome> PLAINS_BIOME = BIOMES.register("plains_biome", TheGatewayPlainsBiome::new);





	public static void registerBiomes(){
    	BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
