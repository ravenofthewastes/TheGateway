package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.mod_dimension.ModDimensionTheGateway;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryDims {

    public static final ResourceLocation DIMENSION_TYPE_THE_GATEWAY_LOC = new ResourceLocation(TheGateway.MOD_ID, "the_gateway");

    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, TheGateway.MOD_ID);

    public static final RegistryObject<ModDimension> MOD_DIMENSION_THE_GATEWAY = MOD_DIMENSIONS.register("mod_dimension_the_gateway",
            () -> new ModDimensionTheGateway());
	
    public static void registerDims(){
        MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());}

    @Mod.EventBusSubscriber(modid = TheGateway.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class DimensionRegistry{
        @SubscribeEvent
        public static void registerDimension(final RegisterDimensionsEvent event) {
            if(DimensionType.byName(DIMENSION_TYPE_THE_GATEWAY_LOC) == null) {
                DimensionManager.registerDimension(DIMENSION_TYPE_THE_GATEWAY_LOC, RegistryDims.MOD_DIMENSION_THE_GATEWAY.get(), null, true);
            }
        }
    }
}