package mod.wastelanddevelopment.thegateway.world.dimension.settings;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class BiomeProviderSettingsTheGateway implements IBiomeProviderSettings {
    private final long seed;
    private final WorldType worldType;
    private GenSettingsTheGateway generatorSettings = new GenSettingsTheGateway();

    public BiomeProviderSettingsTheGateway(WorldInfo p_i225751_1_) {
        this.seed = p_i225751_1_.getSeed();
        this.worldType = p_i225751_1_.getGenerator();
    }

    public BiomeProviderSettingsTheGateway setGeneratorSettings(GenSettingsTheGateway p_205441_1_) {
        this.generatorSettings = p_205441_1_;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public GenSettingsTheGateway getGeneratorSettings() {
        return this.generatorSettings;
    }
}