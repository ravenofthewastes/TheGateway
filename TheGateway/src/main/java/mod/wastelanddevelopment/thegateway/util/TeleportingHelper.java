package mod.wastelanddevelopment.thegateway.util;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.registries.RegistryDims;
import mod.wastelanddevelopment.thegateway.world.dimension.teleporting.TeleporterTheGateway;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheGateway.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TeleportingHelper {


    //Author Krevik
    //Why do we need to split between ServerPlayerEntity teleportation method and entitiy's one?
    //Because they have different teleportation method just check ServerPlayerEntity#changeDimension and Entity#changeDimension
    //timeUntilPortal field adds teleportation cooldown
    //we also need to check if entity is not riding on sth or is not ridden by sth. Why? Probably if we try to teleport
    //such entity, minecraft would potentially crash or teleportation can get bugged
    public static void teleportEntity(Entity entity){
        if(!entity.isBeingRidden() && entity.getRidingEntity()==null){
            if(!entity.world.isRemote && (entity instanceof ServerPlayerEntity)) {
                ServerPlayerEntity playerEntity = (ServerPlayerEntity) entity;
                if(playerEntity.timeUntilPortal<=0){
                    playerEntity.timeUntilPortal = 10;
                    playerEntity.changeDimension(getDestination(entity),new TeleporterTheGateway(entity.getServer().getWorld(getDestination(entity))));
                    playerEntity.timeUntilPortal = 10;
                }
            }
            if(!entity.world.isRemote && !(entity instanceof ServerPlayerEntity)){
                if(entity.timeUntilPortal<=0){
                    entity.timeUntilPortal = 10;
                    entity.changeDimension(getDestination(entity),new TeleporterTheGateway(entity.getServer().getWorld(getDestination(entity))));
                    entity.timeUntilPortal = 10;
                }
            }
        }

    }

    private static DimensionType getDestination(Entity entity) {
        if(entity.dimension == DimensionType.OVERWORLD){
            return DimensionManager.registerOrGetDimension(RegistryDims.DIMENSION_TYPE_THE_GATEWAY_LOC,RegistryDims.MOD_DIMENSION_THE_GATEWAY.get(),null,true);
        }else{
            return DimensionType.OVERWORLD;
        }
    }

}
