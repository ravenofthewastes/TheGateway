package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.registries.RegistryDims;
import mod.wastelanddevelopment.thegateway.world.dimension.mod_dimension.ModDimensionTheGateway;
import mod.wastelanddevelopment.thegateway.world.dimension.teleporting.TeleporterTheGateway;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = TheGateway.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TeleportingHelper {

    public static void teleportEntity(Entity entity){
        if(!entity.world.isRemote && (entity instanceof ServerPlayerEntity)) {
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) entity;
            if(playerEntity.timeUntilPortal<=0){
                playerEntity.timeUntilPortal = 10;
                playerEntity.changeDimension(getDestination(entity),new TeleporterTheGateway(entity.getServer().getWorld(getDestination(entity))));
                playerEntity.timeUntilPortal = 10;
            }
        }
    }

    private static DimensionType getDestination(Entity entity) {
        if(entity.dimension == DimensionType.OVERWORLD){
            return DimensionManager.registerOrGetDimension(RegistryDims.DIMENSION_TYPE_BEYOND_END,RegistryDims.MOD_DIMENSION_THE_GATEWAY.get(),null,true);
        }else{
            return DimensionType.OVERWORLD;
        }
    }


    @Nullable
    public static Entity changeDimensionEntity(Entity entity, DimensionType destination, net.minecraftforge.common.util.ITeleporter teleporter) {
        if (!net.minecraftforge.common.ForgeHooks.onTravelToDimension(entity, destination)) return null;
        if (!entity.world.isRemote && !entity.removed) {
            entity.world.getProfiler().startSection("changeDimension");
            MinecraftServer minecraftserver = entity.getServer();
            DimensionType dimensiontype = entity.dimension;
            ServerWorld serverworld = minecraftserver.getWorld(dimensiontype);
            ServerWorld serverworld1 = minecraftserver.getWorld(destination);
            entity.dimension = destination;
            entity.detach();
            entity.world.getProfiler().startSection("reposition");
            Entity transportedEntity = teleporter.placeEntity(entity, serverworld, serverworld1, entity.rotationYaw, spawnPortal -> { //Forge: Start vanilla logic
                Vec3d vec3d = entity.getMotion();
                float f = 0.0F;
                BlockPos blockpos;
                if (dimensiontype == DimensionType.THE_END && destination == DimensionType.OVERWORLD) {
                    blockpos = serverworld1.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, serverworld1.getSpawnPoint());
                } else if (destination == DimensionType.THE_END) {
                    blockpos = serverworld1.getSpawnCoordinate();
                } else {
                    double movementFactor = serverworld.getDimension().getMovementFactor() / serverworld1.getDimension().getMovementFactor();
                    double d0 = entity.getPosX() * movementFactor;
                    double d1 = entity.getPosZ() * movementFactor;

                    double d3 = Math.min(-2.9999872E7D, serverworld1.getWorldBorder().minX() + 16.0D);
                    double d4 = Math.min(-2.9999872E7D, serverworld1.getWorldBorder().minZ() + 16.0D);
                    double d5 = Math.min(2.9999872E7D, serverworld1.getWorldBorder().maxX() - 16.0D);
                    double d6 = Math.min(2.9999872E7D, serverworld1.getWorldBorder().maxZ() - 16.0D);
                    d0 = MathHelper.clamp(d0, d3, d5);
                    d1 = MathHelper.clamp(d1, d4, d6);
                    Vec3d vec3d1 = entity.getLastPortalVec();
                    blockpos = new BlockPos(d0, entity.getPosY(), d1);
                    if (spawnPortal) {
                        BlockPattern.PortalInfo blockpattern$portalinfo = new TeleporterTheGateway(serverworld1).placeInExistingPortal(blockpos, vec3d, entity.getTeleportDirection(), vec3d1.x, vec3d1.y, entity instanceof PlayerEntity);
                        if (blockpattern$portalinfo == null) {
                            return null;
                        }

                        blockpos = new BlockPos(blockpattern$portalinfo.pos);
                        vec3d = blockpattern$portalinfo.motion;
                        f = (float)blockpattern$portalinfo.rotation;
                    }
                }

                entity.world.getProfiler().endStartSection("reloading");
                Entity entity1 = entity.getType().create(serverworld1);
                if (entity1 != null) {
                    entity1.copyDataFromOld(entity);
                    entity1.moveToBlockPosAndAngles(blockpos, entity1.rotationYaw + f, entity1.rotationPitch);
                    entity1.setMotion(vec3d);
                    serverworld1.addFromAnotherDimension(entity1);
                }
                return entity1;
            });//Forge: End vanilla logic

            entity.remove(false);
            entity.world.getProfiler().endSection();
            serverworld.resetUpdateEntityTick();
            serverworld1.resetUpdateEntityTick();
            entity.world.getProfiler().endSection();
            return transportedEntity;
        } else {
            return null;
        }
    }

    private static void triggerDimensionChange(ServerPlayerEntity playerEntity, ServerWorld p_213846_1_) {
        DimensionType dimensiontype = p_213846_1_.dimension.getType();
        DimensionType dimensiontype1 = playerEntity.world.dimension.getType();
        CriteriaTriggers.CHANGED_DIMENSION.trigger(playerEntity, dimensiontype, dimensiontype1);
    }
}
