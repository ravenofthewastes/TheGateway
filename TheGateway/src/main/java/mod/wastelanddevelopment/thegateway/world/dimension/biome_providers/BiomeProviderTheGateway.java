package mod.wastelanddevelopment.thegateway.world.dimension.biome_providers;

import com.google.common.collect.ImmutableSet;
import mod.wastelanddevelopment.thegateway.registries.RegistryBiomes;
import mod.wastelanddevelopment.thegateway.world.dimension.layer.LayerUtilTheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.settings.BiomeProviderSettingsTheGateway;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.Set;

public class BiomeProviderTheGateway extends BiomeProvider {
    private final Layer genBiomes;
    private static final Set<Biome> allowedBiomes = ImmutableSet.of(RegistryBiomes.PLAINS_BIOME.get());

    public BiomeProviderTheGateway(BiomeProviderSettingsTheGateway settingsProvider) {
        super(allowedBiomes);
        this.genBiomes = LayerUtilTheGateway.func_227474_a_(settingsProvider.getSeed(), settingsProvider.getWorldType(), settingsProvider.getGeneratorSettings());
    }


    public Biome getNoiseBiome(int x, int y, int z) {
        return this.genBiomes.func_215738_a(x, z);
    }
}