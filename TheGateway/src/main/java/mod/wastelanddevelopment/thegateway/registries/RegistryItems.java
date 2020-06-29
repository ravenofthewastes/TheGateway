package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.BlockItemBase;
import mod.wastelanddevelopment.thegateway.items.ItemBase;
import mod.wastelanddevelopment.thegateway.items.ItemSpecial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TheGateway.MOD_ID);
    
    
    //Tools
    public static final RegistryObject<Item> KEVARGEM = ITEMS.register("kevar_gem", ItemBase::new);
    
    
    //Foodstuffs
    
    
    //Ores
    public static final RegistryObject<Item> RAWSPARITE = ITEMS.register("raw_sparite", ItemBase::new);
    
    
    //Materials
    public static final RegistryObject<Item> SPARITE = ITEMS.register("sparite", ItemBase::new);
    
    
    //Block Items
    public static final RegistryObject<Item> SPARITE_ORE_BLOCK_ITEM = ITEMS.register("sparite_ore", () -> new BlockItemBase(RegistryBlocks.SPARITE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> KATH_STONE_BLOCK_ITEM = ITEMS.register("kath_stone", () -> new BlockItemBase(RegistryBlocks.KATH_STONE_BLOCK.get()));

    
    //Misc
    public static final RegistryObject<Item> DEVSTONE = ITEMS.register("dev_stone", ItemSpecial::new);
    
    

    public static void registerItems(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
