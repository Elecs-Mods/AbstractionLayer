package elec332.abstraction.impl;

import com.google.common.io.ByteStreams;
import elec332.core.world.IElecWorldEventListener;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Elec332 on 30-1-2017.
 */
@SuppressWarnings("all")
enum WorldEventListener implements IWorldEventListener {

    INSTANCE;

    @Override
    public void notifyBlockUpdate(World worldIn, BlockPos pos, IBlockState oldState, IBlockState newState, int flags) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners) {
            l.notifyBlockUpdate(worldIn, pos, oldState, newState, flags);
        }
    }

    @Override
    public void notifyLightSet(BlockPos pos) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.notifyLightSet(pos);
        }
    }

    @Override
    public void markBlockRangeForRenderUpdate(int x1, int y1, int z1, int x2, int y2, int z2) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.markBlockRangeForRenderUpdate(x1, y1, z1, x2, y2, z2);
        }
    }

    @Override
    public void playSoundToAllNearExcept(@Nullable EntityPlayer player, SoundEvent soundIn, SoundCategory category, double x, double y, double z, float volume, float pitch) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.playSoundToAllNearExcept(player, soundIn, category, x, y, z, volume, pitch);
        }
    }

    @Override
    public void playRecord(SoundEvent soundIn, BlockPos pos) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.playRecord(soundIn, pos);
        }
    }

    @Override
    public void spawnParticle(int particleID, boolean ignoreRange, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... parameters) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.spawnParticle(particleID, ignoreRange, false, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, parameters);
        }
    }

    @Override
    public void onEntityAdded(Entity entityIn) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.onEntityAdded(entityIn);
        }
    }

    @Override
    public void onEntityRemoved(Entity entityIn) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.onEntityRemoved(entityIn);
        }
    }

    @Override
    public void broadcastSound(int soundID, BlockPos pos, int data) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.broadcastSound(soundID, pos, data);
        }
    }

    @Override
    public void playEvent(EntityPlayer player, int type, BlockPos blockPosIn, int data) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.playEvent(player, type, blockPosIn, data);
        }
    }

    @Override
    public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {
        for (IElecWorldEventListener l : MCAbstractionHandler.listeners){
            l.sendBlockBreakProgress(breakerId, pos, progress);
        }
    }

}
