package mod.wastelanddevelopment.thegateway.init;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.KathStone;
import mod.wastelanddevelopment.thegateway.blocks.SpariteOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TheGateway.MOD_ID);

    //BLOCKS
    public static final RegistryObject<Block> SPARITE_ORE_BLOCK = BLOCKS.register("sparite_ore", SpariteOre::new);
    public static final RegistryObject<Block> KATH_STONE_BLOCK = BLOCKS.register("kath_stone", KathStone::new);

    public static void registerBlocks(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}