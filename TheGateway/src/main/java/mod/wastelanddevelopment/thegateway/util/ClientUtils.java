package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.registries.RegistryBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class ClientUtils {

    public static void registerRenderTypes(){
        //it was supossed to fix the problem with rendering grass block texture but apparently it is not working...
        //Maybe the problem is caused because we're using DeferredRegistry instead of standard events?............ TODO
        RenderTypeLookup.setRenderLayer(RegistryBlocks.KATH_GRASS_BLOCK.get(), RenderType.getCutoutMipped());
    }
}
