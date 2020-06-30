package mod.wastelanddevelopment.thegateway.world.dimension.layer;

import mod.wastelanddevelopment.thegateway.world.dimension.settings.GenSettingsTheGateway;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

import java.util.function.LongFunction;

public class LayerUtilTheGateway extends LayerUtil {
    protected static final int WARM_OCEAN = Registry.BIOME.getId(Biomes.WARM_OCEAN);
    protected static final int LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.LUKEWARM_OCEAN);
    protected static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);
    protected static final int COLD_OCEAN = Registry.BIOME.getId(Biomes.COLD_OCEAN);
    protected static final int FROZEN_OCEAN = Registry.BIOME.getId(Biomes.FROZEN_OCEAN);
    protected static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_WARM_OCEAN);
    protected static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_LUKEWARM_OCEAN);
    protected static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
    protected static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(Biomes.DEEP_COLD_OCEAN);
    protected static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(Biomes.DEEP_FROZEN_OCEAN);

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<T> p_202829_3_, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> iareafactory = p_202829_3_;

        for(int i = 0; i < count; ++i) {
            iareafactory = parent.apply(contextFactory.apply(seed + (long)i), iareafactory);
        }

        return iareafactory;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> func_227475_a_(WorldType worldTypeIn, GenSettingsTheGateway settings, LongFunction<C> contextFactory) {
        IAreaFactory<T> iareafactory = IslandLayer.INSTANCE.apply(contextFactory.apply(1L));
        iareafactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), iareafactory);
        iareafactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), iareafactory);
        iareafactory = RemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        iareafactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), iareafactory);
        iareafactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), iareafactory);
        //iareafactory = GenLayerEdge.HeatIce.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        iareafactory = repeat(1000L, ZoomLayer.NORMAL, iareafactory, 0, contextFactory);

        int i = 8;
        int j = i;
        if (settings != null) {
            j = settings.getRiverSize();
        }

        i = 3;

        IAreaFactory<T> layer1 = repeat(1000L, ZoomLayer.NORMAL, iareafactory, 0, contextFactory);
        layer1 = StartRiverLayer.INSTANCE.apply(contextFactory.apply(100L), layer1);
        IAreaFactory<T> layer2 = getBiomeLayer(iareafactory, settings, contextFactory);
        layer1 = repeat(1000L, ZoomLayer.NORMAL, layer1, 2, contextFactory);
        layer1 = repeat(1000L, ZoomLayer.NORMAL, layer1, j, contextFactory);
        layer1 = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), layer1);

        for(int k = 0; k < i; ++k) {
            layer2 = ZoomLayer.NORMAL.apply(contextFactory.apply((long)(1000 + k)), layer2);

            if (k == 1 || i == 1) {
                layer2 = ZoomLayer.NORMAL.apply(contextFactory.apply((long)(1000L)), layer2);
            }
        }
        layer2 = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), layer2);

        IAreaFactory<T> iareafactory5 = ZoomLayer.NORMAL.apply(contextFactory.apply(10L), layer2);

        return iareafactory5;
    }


    private static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> getBiomeLayer(IAreaFactory<T> parentLayer,
                                                                                                      GenSettingsTheGateway chunkSettings, LongFunction<C> contextFactory)
    {
        parentLayer = (new BiomeLayerTheGateway(chunkSettings)).apply(contextFactory.apply(200L), parentLayer);
        parentLayer = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, parentLayer, 2, contextFactory);
        parentLayer = EdgeBiomeLayer.INSTANCE.apply(contextFactory.apply(1000L), parentLayer);
        return parentLayer;
    }

    public static Layer func_227474_a_(long p_227474_0_, WorldType p_227474_2_, GenSettingsTheGateway p_227474_3_) {
        int i = 25;
        IAreaFactory<LazyArea> iareafactory = func_227475_a_(p_227474_2_, p_227474_3_, (p_227473_2_) -> {
            return new LazyAreaLayerContext(25, p_227474_0_, p_227473_2_);
        });
        return new Layer(iareafactory);
    }

    public static int getModdedBiomeSize(WorldType worldType, int original)
    {
        net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize event = new net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize(worldType, original);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        return event.getNewSize();
    }
}
