package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.SpariteOre;
import mod.wastelanddevelopment.thegateway.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TheGateway.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TheGateway.MOD_ID);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	
	//ITEMS
	public static final RegistryObject<Item> RAWSPARITE = ITEMS.register("raw_sparite", ItemBase::new);
	public static final RegistryObject<Item> KEVARGEM = ITEMS.register("kevar_gem", ItemBase::new);
	public static final RegistryObject<Item> SPARITE = ITEMS.register("sparite", ItemBase::new);
	
	
	//BLOCKS
	public static final RegistryObject<Block> SPARITE_ORE_BLOCK = BLOCKS.register("sparite_ore", SpariteOre::new);
	
	//BLOCK ITEMS
	public static final RegistryObject<Item> SPARITE_ORE_BLOCK_ITEM = ITEMS.register("sparite_ore", () -> new BlockItemBase(SPARITE_ORE_BLOCK.get()));
	
}
