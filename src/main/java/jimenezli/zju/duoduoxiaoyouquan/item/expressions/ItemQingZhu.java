package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemQingZhu extends Item {
    public ItemQingZhu(){
        String name = "qing_zhu";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private static final double rocketAngleAddition = Math.PI / 12.0;

    private static final double creeperAngleAddition = Math.PI / 2.0;

    private static final double creeperSpawnDistance = 6.0;
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack qing_zhu = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            qing_zhu.shrink(1);
        }

        //Copied from code of ItemGouTou
        for (int creeperCount = 0; creeperCount < 4; creeperCount++) {
            EntityCreeper creeper = new EntityCreeper(worldIn);
            creeper.setPosition(
                    playerIn.posX + creeperSpawnDistance * Math.cos(creeperAngleAddition * creeperCount),
                    playerIn.posY,
                    playerIn.posZ + creeperSpawnDistance * Math.sin(creeperAngleAddition * creeperCount)
            );
            if (!worldIn.isRemote) {
                worldIn.spawnEntity(creeper);
            }
        }

        for (double rocketSpawnDistance = 1.0; rocketSpawnDistance < 5.0; rocketSpawnDistance += 1.0) {
            for (int rocketCount = 0; rocketCount < 24; rocketCount++) {
                EntityFireworkRocket rocket = new EntityFireworkRocket(worldIn);
                rocket.setPosition(
                        playerIn.posX + rocketSpawnDistance * Math.cos(rocketAngleAddition * rocketCount),
                        playerIn.posY,
                        playerIn.posZ + rocketSpawnDistance * Math.sin(rocketAngleAddition * rocketCount)
                );
                worldIn.spawnEntity(rocket);
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, qing_zhu);
    }
}
