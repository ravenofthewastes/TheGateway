package mod.wastelanddevelopment.thegateway.registries;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.carvers.TheGatewayWorldCaveCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryWorldCarvers {
    public static final DeferredRegister<WorldCarver<?>> CARVERS = new DeferredRegister<>(ForgeRegistries.WORLD_CARVERS, TheGateway.MOD_ID);

    public static final RegistryObject<WorldCarver<ProbabilityConfig>> CAVE_WORLD_CARVER = CARVERS.register("the_gateway_cave_world_carver", ()->new TheGatewayWorldCaveCarver(ProbabilityConfig::deserialize, 256));








    public static void registerCarvers(){
        CARVERS.register(FMLJavaModLoadingContext.get().getModEventBus());}
}
