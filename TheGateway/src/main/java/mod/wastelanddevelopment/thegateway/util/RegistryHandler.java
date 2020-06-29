package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.BlockItemBase;
import mod.wastelanddevelopment.thegateway.blocks.KathStone;
import mod.wastelanddevelopment.thegateway.blocks.SpariteOre;
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

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TheGateway.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TheGateway.MOD_ID);
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TheGateway.MOD_ID);
	public static final DeferredRegister<Feature<?>> BIOME_FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, TheGateway.MOD_ID);
	public static final DeferredRegister<BiomeProviderType<?,?>> BIOME_PROVIDER_TYPES = new DeferredRegister<>(ForgeRegistries.BIOME_PROVIDER_TYPES, TheGateway.MOD_ID);
	public static final DeferredRegister<ChunkGeneratorType<?,?>> CHUNK_GENERATOR_TYPES = new DeferredRegister<>(ForgeRegistries.CHUNK_GENERATOR_TYPES, TheGateway.MOD_ID);
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, TheGateway.MOD_ID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
		BIOME_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		BIOME_PROVIDER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		CHUNK_GENERATOR_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	
	//ITEMS
	public static final RegistryObject<Item> DEVSTONE = ITEMS.register("dev_stone", ItemSpecial::new);
	public static final RegistryObject<Item> RAWSPARITE = ITEMS.register("raw_sparite", ItemBase::new);
	public static final RegistryObject<Item> KEVARGEM = ITEMS.register("kevar_gem", ItemBase::new);
	public static final RegistryObject<Item> SPARITE = ITEMS.register("sparite", ItemBase::new);
	
	
	//BLOCKS
	public static final RegistryObject<Block> SPARITE_ORE_BLOCK = BLOCKS.register("sparite_ore", SpariteOre::new);
	public static final RegistryObject<Block> KATH_STONE_BLOCK = BLOCKS.register("kath_stone", KathStone::new);
	
	//BLOCK ITEMS
	public static final RegistryObject<Item> SPARITE_ORE_BLOCK_ITEM = ITEMS.register("sparite_ore", () -> new BlockItemBase(SPARITE_ORE_BLOCK.get()));
	public static final RegistryObject<Item> KATH_STONE_BLOCK_ITEM = ITEMS.register("kath_stone", () -> new BlockItemBase(KATH_STONE_BLOCK.get()));

	//MOD DIMENSIONS

	//BIOME FEATURES

	//BIOMES

	//BIOME PROVIDER TYPES

	//CHUNK GENERATOR TYPES

}
