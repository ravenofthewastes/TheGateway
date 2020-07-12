package mod.wastelanddevelopment.thegateway.blocks;

import com.google.common.cache.LoadingCache;
import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.registries.RegistryBlocks;
import mod.wastelanddevelopment.thegateway.util.TeleportingHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;

public class KathPortal extends NetherPortalBlock {
    public KathPortal() {
        super(Block.Properties.create(Material.PORTAL).tickRandomly().sound(SoundType.GLASS).hardnessAndResistance(-1f));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
    }

    @Override
    public boolean trySpawnPortal(IWorld worldIn, BlockPos pos) {
        KathPortal.Size netherportalblock$size = this.isKathPortal(worldIn, pos);
        if (netherportalblock$size != null
                //&& !net.minecraftforge.event.ForgeEventFactory.onTrySpawnPortal(worldIn, pos, netherportalblock$size)
        ) {
            netherportalblock$size.placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    public KathPortal.Size isKathPortal(IWorld worldIn, BlockPos pos) {
        KathPortal.Size netherportalblock$size = new KathPortal.Size(worldIn, pos, Direction.Axis.X);
        if (netherportalblock$size.isValid() && netherportalblock$size.portalBlockCount == 0) {
            return netherportalblock$size;
        } else {
            KathPortal.Size netherportalblock$size1 = new KathPortal.Size(worldIn, pos, Direction.Axis.Z);
            return netherportalblock$size1.isValid() && netherportalblock$size1.portalBlockCount == 0 ? netherportalblock$size1 : null;
        }
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis direction$axis = facing.getAxis();
        Direction.Axis direction$axis1 = stateIn.get(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new KathPortal.Size(worldIn, currentPos, direction$axis1)).func_208508_f() ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn!=null && !entityIn.isBeingRidden() && entityIn.getRidingEntity() == null){
            TeleportingHelper.teleportEntity(entityIn);
            entityIn.timeUntilPortal=10;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) {
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
            double d0 = (double)pos.getX() + (double)rand.nextFloat();
            double d1 = (double)pos.getY() + (double)rand.nextFloat();
            double d2 = (double)pos.getZ() + (double)rand.nextFloat();
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this) {
                d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
            } else {
                d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }

            worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }

    }

    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }


    public static BlockPattern.PatternHelper createPatternHelper(IWorld p_181089_0_, BlockPos worldIn) {
        Direction.Axis direction$axis = Direction.Axis.Z;
        KathPortal.Size netherportalblock$size = new KathPortal.Size(p_181089_0_, worldIn, Direction.Axis.X);
        LoadingCache<BlockPos, CachedBlockInfo> loadingcache = BlockPattern.createLoadingCache(p_181089_0_, true);
        if (!netherportalblock$size.isValid()) {
            direction$axis = Direction.Axis.X;
            netherportalblock$size = new KathPortal.Size(p_181089_0_, worldIn, Direction.Axis.Z);
        }

        if (!netherportalblock$size.isValid()) {
            return new BlockPattern.PatternHelper(worldIn, Direction.NORTH, Direction.UP, loadingcache, 1, 1, 1);
        } else {
            int[] aint = new int[Direction.AxisDirection.values().length];
            Direction direction = netherportalblock$size.rightDir.rotateYCCW();
            BlockPos blockpos = netherportalblock$size.bottomLeft.up(netherportalblock$size.getHeight() - 1);

            for(Direction.AxisDirection direction$axisdirection : Direction.AxisDirection.values()) {
                BlockPattern.PatternHelper blockpattern$patternhelper = new BlockPattern.PatternHelper(direction.getAxisDirection() == direction$axisdirection ? blockpos : blockpos.offset(netherportalblock$size.rightDir, netherportalblock$size.getWidth() - 1), Direction.getFacingFromAxis(direction$axisdirection, direction$axis), Direction.UP, loadingcache, netherportalblock$size.getWidth(), netherportalblock$size.getHeight(), 1);

                for(int i = 0; i < netherportalblock$size.getWidth(); ++i) {
                    for(int j = 0; j < netherportalblock$size.getHeight(); ++j) {
                        CachedBlockInfo cachedblockinfo = blockpattern$patternhelper.translateOffset(i, j, 1);
                        if (!cachedblockinfo.getBlockState().isAir()) {
                            ++aint[direction$axisdirection.ordinal()];
                        }
                    }
                }
            }

            Direction.AxisDirection direction$axisdirection1 = Direction.AxisDirection.POSITIVE;

            for(Direction.AxisDirection direction$axisdirection2 : Direction.AxisDirection.values()) {
                if (aint[direction$axisdirection2.ordinal()] < aint[direction$axisdirection1.ordinal()]) {
                    direction$axisdirection1 = direction$axisdirection2;
                }
            }

            return new BlockPattern.PatternHelper(direction.getAxisDirection() == direction$axisdirection1 ? blockpos : blockpos.offset(netherportalblock$size.rightDir, netherportalblock$size.getWidth() - 1), Direction.getFacingFromAxis(direction$axisdirection1, direction$axis), Direction.UP, loadingcache, netherportalblock$size.getWidth(), netherportalblock$size.getHeight(), 1);
        }
    }

    public static class Size {
        private final IWorld world;
        private final Direction.Axis axis;
        public final Direction rightDir;
        public final Direction leftDir;
        private int portalBlockCount;
        @Nullable
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
            this.world = worldIn;
            this.axis = axisIn;
            if (axisIn == Direction.Axis.X) {
                this.leftDir = Direction.EAST;
                this.rightDir = Direction.WEST;
            } else {
                this.leftDir = Direction.NORTH;
                this.rightDir = Direction.SOUTH;
            }

            for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.func_196900_a(worldIn.getBlockState(pos.down())); pos = pos.down()) {
                ;
            }

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
            if (i >= 0) {
                this.bottomLeft = pos.offset(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }

        }

        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
            int i;
            for(i = 0; i < 22; ++i) {
                BlockPos blockpos = pos.offset(directionIn, i);
                if (!isKathairianPortalFrameBlock(world.getBlockState(blockpos.down()).getBlock())) {
                    break;
                }
            }

            BlockPos framePos = pos.offset(directionIn, i);
            return isKathairianPortalFrameBlock(world.getBlockState(framePos).getBlock()) ? i : 0;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        protected int calculatePortalHeight() {
            label56:
            for(this.height = 0; this.height < 21; ++this.height) {
                for(int i = 0; i < this.width; ++i) {
                    BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
                    BlockState blockstate = this.world.getBlockState(blockpos);
                    if (!this.func_196900_a(blockstate)) {
                        break label56;
                    }

                    Block block = blockstate.getBlock();
                    if (block == RegistryBlocks.KATH_PORTAL.get()) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        BlockPos framePos = blockpos.offset(this.leftDir);
                        if (!isKathairianPortalFrameBlock(world.getBlockState(framePos).getBlock())) {
                            break label56;
                        }
                    } else if (i == this.width - 1) {
                        BlockPos framePos = blockpos.offset(this.rightDir);
                        if (!isKathairianPortalFrameBlock(world.getBlockState(framePos).getBlock())) {
                            break label56;
                        }
                    }
                }
            }

            for(int j = 0; j < this.width; ++j) {
                BlockPos framePos = this.bottomLeft.offset(this.rightDir, j).up(this.height);
                if (!isKathairianPortalFrameBlock(world.getBlockState(framePos).getBlock())) {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected boolean func_196900_a(BlockState pos) {
            Block block = pos.getBlock();
            return pos.isAir() || block == Blocks.FIRE || block == RegistryBlocks.KATH_PORTAL.get();
        }

        public boolean isValid() {
            boolean b1=this.bottomLeft!=null;
            boolean b2=this.width>=2;
            boolean b3=this.width<=21;
            boolean b4=this.height>=3;
            boolean b5=this.height<=21;
            return b1 && b2 && b3 && b4 && b5;
        }

        public void placePortalBlocks() {
            for(int i = 0; i < this.width; ++i) {
                BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);

                for(int j = 0; j < this.height; ++j) {
                    this.world.setBlockState(blockpos.up(j), RegistryBlocks.KATH_PORTAL.get().getDefaultState().with(KathPortal.AXIS, this.axis), 18);
                }
            }

        }


        private boolean isKathairianPortalFrameBlock(Block block){
            ArrayList<Block> portalFrameBlocks = new ArrayList<>();
            portalFrameBlocks.add(Blocks.STONE);
            portalFrameBlocks.add(RegistryBlocks.KATH_STONE_BLOCK.get());
            return portalFrameBlocks.contains(block);
        }

        private boolean func_196899_f() {
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean func_208508_f() {
            return this.isValid() && this.func_196899_f();
        }
    }
}
