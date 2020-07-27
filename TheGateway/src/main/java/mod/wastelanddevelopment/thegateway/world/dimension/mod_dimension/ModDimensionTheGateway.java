package mod.wastelanddevelopment.thegateway.world.dimension.mod_dimension;

import mod.wastelanddevelopment.thegateway.world.dimension.DimensionKath;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.BiFunction;

public class ModDimensionTheGateway extends ModDimension {

    @Override
    public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
        return DimensionKath::new;
    }
}
