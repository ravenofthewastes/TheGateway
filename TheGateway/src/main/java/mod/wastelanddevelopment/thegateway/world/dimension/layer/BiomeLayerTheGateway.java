package mod.wastelanddevelopment.thegateway.world.dimension.layer;

import com.google.common.collect.ImmutableList;
import mod.wastelanddevelopment.thegateway.registries.RegistryBiomes;
import mod.wastelanddevelopment.thegateway.world.dimension.settings.GenSettingsTheGateway;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public class BiomeLayerTheGateway implements IC0Transformer {


    public static ImmutableList<BiomeManager.BiomeEntry> getBiomesToGeneration(){
        ArrayList<BiomeManager.BiomeEntry> list = new ArrayList<>();
        list.add(new BiomeManager.BiomeEntry(RegistryBiomes.PLAINS_BIOME.get(),10));
        return ImmutableList.copyOf(list);
    }


    @SuppressWarnings("unchecked")
    private java.util.List<BiomeManager.BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];
    private final GenSettingsTheGateway settings;

    public BiomeLayerTheGateway(GenSettingsTheGateway p_i48641_2_) {
        for (BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
            ImmutableList<BiomeManager.BiomeEntry> biomesToAdd = getBiomesToGeneration();
            int idx = type.ordinal();

            if (biomes[idx] == null) biomes[idx] = new ArrayList<BiomeManager.BiomeEntry>();
            if (biomesToAdd != null) biomes[idx].addAll(biomesToAdd);
        }

        this.settings = p_i48641_2_;

    }


    protected BiomeManager.BiomeEntry getWeightedBiomeEntry(BiomeManager.BiomeType type, INoiseRandom iNoiseRandom) {
        java.util.List<BiomeManager.BiomeEntry> biomeList = getBiomesToGeneration();
        int totalWeight = net.minecraft.util.WeightedRandom.getTotalWeight(biomeList);
        int weight = BiomeManager.isTypeListModded(type)?iNoiseRandom.random(totalWeight):iNoiseRandom.random(totalWeight / 10) * 10;
        return (BiomeManager.BiomeEntry)net.minecraft.util.WeightedRandom.getRandomItem(biomeList, weight);
    }

    @Override
    public int apply(INoiseRandom iNoiseRandom, int i) {
        if (this.settings != null && this.settings.getBiomeId() >= 0) {
            return this.settings.getBiomeId();
        } else {
            return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeManager.BiomeType.COOL, iNoiseRandom).biome);
        }
    }
}
