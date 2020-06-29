package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.BlockItemBase;
import mod.wastelanddevelopment.thegateway.blocks.KathStone;
import mod.wastelanddevelopment.thegateway.blocks.SpariteOre;
import mod.wastelanddevelopment.thegateway.init.ModBlocks;
import mod.wastelanddevelopment.thegateway.init.ModItems;
import mod.wastelanddevelopment.thegateway.items.ItemBase;
import mod.wastelanddevelopment.thegateway.items.ItemSpecial;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TheGateway.MOD_ID);
	public static final DeferredRegister<Feature<?>> BIOME_FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, TheGateway.MOD_ID);
	public static final DeferredRegister<BiomeProviderType<?,?>> BIOME_PROVIDER_TYPES = new DeferredRegister<>(ForgeRegistries.BIOME_PROVIDER_TYPES, TheGateway.MOD_ID);
	public static final DeferredRegister<ChunkGeneratorType<?,?>> CHUNK_GENERATOR_TYPES = new DeferredRegister<>(ForgeRegistries.CHUNK_GENERATOR_TYPES, TheGateway.MOD_ID);
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, TheGateway.MOD_ID);

	public static void init() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
		BIOME_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		BIOME_PROVIDER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		CHUNK_GENERATOR_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	

	
	

	


	//MOD DIMENSIONS

	//BIOME FEATURES

	//BIOMES

	//BIOME PROVIDER TYPES

	//CHUNK GENERATOR TYPES

}
