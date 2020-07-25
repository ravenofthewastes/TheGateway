package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.registries.RegistryBiomes;
import mod.wastelanddevelopment.thegateway.registries.RegistryBlocks;
import mod.wastelanddevelopment.thegateway.registries.RegistryFeatures;
import mod.wastelanddevelopment.thegateway.registries.RegistryWorldCarvers;
import mod.wastelanddevelopment.thegateway.world.dimension.features.ore.TheGatewayOreFeature;
import mod.wastelanddevelopment.thegateway.world.dimension.features.ore.TheGatewayOreFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
//import org.graalvm.compiler.nodes.NodeView;

public class TheGatewayDefaultBiomeFeatures {

    public static void addCarvers(Biome biomeIn) {
        biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(RegistryWorldCarvers.CAVE_WORLD_CARVER.get(), new ProbabilityConfig(0.14285715F)));
    }

    public static void addStoneVariants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RegistryFeatures.ORE.get().withConfiguration(new TheGatewayOreFeatureConfig(TheGatewayOreFeatureConfig.FillerBlockType.THE_GATEWAY_STONE, Blocks.DIRT.getDefaultState(),33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RegistryFeatures.ORE.get().withConfiguration(new TheGatewayOreFeatureConfig(TheGatewayOreFeatureConfig.FillerBlockType.THE_GATEWAY_STONE, Blocks.GRAVEL.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RegistryFeatures.ORE.get().withConfiguration(new TheGatewayOreFeatureConfig(TheGatewayOreFeatureConfig.FillerBlockType.THE_GATEWAY_STONE, Blocks.GRANITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RegistryFeatures.ORE.get().withConfiguration(new TheGatewayOreFeatureConfig(TheGatewayOreFeatureConfig.FillerBlockType.THE_GATEWAY_STONE, Blocks.DIORITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RegistryFeatures.ORE.get().withConfiguration(new TheGatewayOreFeatureConfig(TheGatewayOreFeatureConfig.FillerBlockType.THE_GATEWAY_STONE, Blocks.ANDESITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
    }

    public static void addDefaultOres(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, RegistryFeatures.ORE.get().withConfiguration(new TheGatewayOreFeatureConfig(TheGatewayOreFeatureConfig.FillerBlockType.THE_GATEWAY_STONE, RegistryBlocks.SPARITE_ORE_BLOCK.get().getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
    }

}
