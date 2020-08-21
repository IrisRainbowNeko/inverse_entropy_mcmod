package com.qtransfer.mod7e.blocks;

import com.qtransfer.mod7e.Constant;
import com.qtransfer.mod7e.QuantumTransfer;
import com.qtransfer.mod7e.gui.GuiElementLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class QuantumChest extends QTransBlock{

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new QuantumChestEntity();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tile = world.getTileEntity(pos);
        if (!world.isRemote) {
            if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().getRegistryName().toString().equals(Constant.item("wave_analyzer")))
                player.openGui(QuantumTransfer.instance, GuiElementLoader.GUI_QSTORAGE, world, pos.getX(), pos.getY(), pos.getZ());
            else
                player.openGui(QuantumTransfer.instance, GuiElementLoader.GUI_Q_CHEST, world, pos.getX(), pos.getY(), pos.getZ());
            tile.markDirty();
        }
        return true;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
