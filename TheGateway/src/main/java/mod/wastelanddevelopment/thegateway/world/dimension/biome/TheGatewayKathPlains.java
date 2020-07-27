package mod.wastelanddevelopment.thegateway.world.dimension.biome;

import mod.wastelanddevelopment.thegateway.registries.RegistryBlocks;
import mod.wastelanddevelopment.thegateway.util.TheGatewayDefaultBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.PlainsBiome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public final class TheGatewayKathPlains extends Biome {
    public static final SurfaceBuilderConfig GRASS_DIRT_DIRT_CONFIG = new SurfaceBuilderConfig(RegistryBlocks.KATH_GRASS.get().getDefaultState(), RegistryBlocks.KATH_DIRT.get().getDefaultState(), RegistryBlocks.KATH_DIRT.get().getDefaultState());

    public TheGatewayKathPlains() {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, GRASS_DIRT_DIRT_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).waterColor(4159204).waterFogColor(329011).parent((String)null));
        DefaultBiomeFeatures.addLakes(this);
        //DefaultBiomeFeatures.addSedimentDisks(this);
    }
}