package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.BlockItemMain;
import mod.wastelanddevelopment.thegateway.items.ItemKevarGem;
import mod.wastelanddevelopment.thegateway.items.ItemMain;
import mod.wastelanddevelopment.thegateway.items.ItemTabless;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TheGateway.MOD_ID);
    
    
    //Tools
    public static final RegistryObject<Item> KEVARGEM = ITEMS.register("kevar_gem", ItemKevarGem::new);

    
    //Foodstuffs
    
    
    //Ores
    public static final RegistryObject<Item> RAWSPARITE = ITEMS.register("raw_sparite", ItemMain::new);
    public static final RegistryObject<Item> RAWKREVISINE = ITEMS.register("raw_krevisine", ItemMain::new);

    
    //Materials
    public static final RegistryObject<Item> SPARITE = ITEMS.register("sparite", ItemMain::new);
    public static final RegistryObject<Item> KREVISINE = ITEMS.register("krevisine", ItemMain::new);
    public static final RegistryObject<Item> ROJA = ITEMS.register("roja", ItemMain::new);
    public static final RegistryObject<Item> JASPER = ITEMS.register("jasper", ItemMain::new);
    

    //Block Items
    public static final RegistryObject<Item> KATH_STONE_BLOCK_ITEM = ITEMS.register("kath_stone", () -> new BlockItemMain(RegistryBlocks.KATH_STONE_BLOCK.get()));
    public static final RegistryObject<Item> KATH_RUBBLE_BLOCK_ITEM = ITEMS.register("kath_rubble", () -> new BlockItemMain(RegistryBlocks.KATH_RUBBLE_BLOCK.get()));
    //public static final RegistryObject<Item> KATH_GRASS_BLOCK_ITEM = ITEMS.register("kath_grass", () -> new BlockItemMain(RegistryBlocks.KATH_GRASS_BLOCK.get()));
    public static final RegistryObject<Item> ORE_SPARITE_BLOCK_ITEM = ITEMS.register("sparite_ore", () -> new BlockItemMain(RegistryBlocks.SPARITE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> ORE_JASPER_BLOCK_ITEM = ITEMS.register("jasper_ore", () -> new BlockItemMain(RegistryBlocks.JASPER_ORE_BLOCK.get()));
    public static final RegistryObject<Item> ORE_KREVISINE_BLOCK_ITEM = ITEMS.register("krevisine_ore", () -> new BlockItemMain(RegistryBlocks.KREVISINE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> ORE_ROJA_BLOCK_ITEM = ITEMS.register("roja_ore", () -> new BlockItemMain(RegistryBlocks.ROJA_ORE_BLOCK.get()));


    //public static final RegistryObject<Item> KATH_PORTAL_BLOCK_ITEM = ITEMS.register("kath_portal", () -> new BlockItemMain(RegistryBlocks.KATH_PORTAL.get()));

    //Misc
    public static final RegistryObject<Item> DEVSTONE = ITEMS.register("dev_stone", ItemTabless::new);


    public static void registerItems(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
