package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryDims {
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, TheGateway.MOD_ID);
	
	
	
    public static void registerDims(){
        MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());}
}