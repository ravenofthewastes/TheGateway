package mod.wastelanddevelopment.thegateway;

import mod.wastelanddevelopment.thegateway.registries.RegistryBiomes;
import mod.wastelanddevelopment.thegateway.util.BiomeFeaturesHandler;
import mod.wastelanddevelopment.thegateway.util.TheGatewayDefaultBiomeFeatures;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.wastelanddevelopment.thegateway.registries.RegistryItems;
import mod.wastelanddevelopment.thegateway.util.RegistryHandler;

@Mod("thegateway_wd")
public class TheGateway
{
    //RANDOM COMMIT FOR RAVEN
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "thegateway_wd";

    public TheGateway() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //why here? ask forge...Because we cannot add things directly in biome class...
        BiomeFeaturesHandler.handleFeatures();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    
    public static final ItemGroup TAB = new ItemGroup("The_Gateway") {
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(RegistryItems.DEVSTONE.get());
    	}
    	
    };

}
