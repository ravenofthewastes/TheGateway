package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TheGateway.MOD_ID);

    //Basic Blocks
    public static final RegistryObject<Block> KATH_STONE_BLOCK = BLOCKS.register("kath_stone", KathStone::new);
    public static final RegistryObject<Block> KATH_GRASS = BLOCKS.register("kath_grass", KathGrass::new);
    public static final RegistryObject<Block> KATH_DIRT = BLOCKS.register("kath_dirt", KathDirt::new);

    
    //Ores
    public static final RegistryObject<Block> SPARITE_ORE_BLOCK = BLOCKS.register("sparite_ore", SpariteOre::new);
    
    
    //Deco
    
    
    //Interactable
    
    
    //Misc
    public static final RegistryObject<Block> KATH_PORTAL = BLOCKS.register("kath_portal", KathPortal::new);
    
    
    public static void registerBlocks(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
