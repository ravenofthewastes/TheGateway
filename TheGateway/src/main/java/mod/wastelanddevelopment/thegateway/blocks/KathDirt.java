package mod.wastelanddevelopment.thegateway.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowyDirtBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class KathDirt extends Block {

    public KathDirt() {
        super(Block.Properties.create(Material.EARTH)
        		.hardnessAndResistance(0.5f)
        		.sound(SoundType.GROUND)
        		.harvestLevel(0)       		
        		
        		);	
    }
}
