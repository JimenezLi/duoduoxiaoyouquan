package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemKaiXin extends Item {
    public ItemKaiXin(){
        String name = "kai_xin";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand handIn, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack hua_ji = playerIn.getHeldItem(handIn);
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, hua_ji))
        {
            return EnumActionResult.FAIL;
        }

        if (!playerIn.capabilities.isCreativeMode) {
            hua_ji.shrink(1);
        }

        //Copied from ItemMonsterPlacer
        BlockPos blockpos = pos.offset(facing);
        double posX = (double)blockpos.getX() + 0.5D;
        double posY = (double)blockpos.getY();
        double posZ = (double)blockpos.getZ() + 0.5D;

        EntitySkeleton skeleton = new EntitySkeleton(worldIn);
        EntityZombie zombie = new EntityZombie(worldIn);
        EntityCreeper creeper = new EntityCreeper(worldIn);
        EntityCaveSpider caveSpider = new EntityCaveSpider(worldIn);
        EntitySpider spider = new EntitySpider(worldIn);

        skeleton.setPosition(posX, posY, posZ);
        zombie.setPosition(posX, posY, posZ);
        creeper.setPosition(posX, posY, posZ);
        caveSpider.setPosition(posX, posY, posZ);
        spider.setPosition(posX, posY, posZ);

        if (!worldIn.isRemote) {
            worldIn.spawnEntity(skeleton);
            worldIn.spawnEntity(zombie);
            worldIn.spawnEntity(creeper);
            worldIn.spawnEntity(caveSpider);
            worldIn.spawnEntity(spider);
        }

        skeleton.startRiding(zombie);
        zombie.startRiding(creeper);
        creeper.startRiding(caveSpider);
        caveSpider.startRiding(spider);

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return EnumActionResult.SUCCESS;
    }
}
