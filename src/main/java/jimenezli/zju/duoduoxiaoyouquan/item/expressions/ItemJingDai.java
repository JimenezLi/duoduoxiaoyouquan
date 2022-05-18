package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemJingDai extends Item {
    public ItemJingDai(){
        String name = "jing_dai";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }


    private static final double angleAddition = Math.PI / 6.0;
    private static final double maxAngle = Math.PI * 2.0;
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack jing_dai = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            jing_dai.shrink(1);
        }

        //Copied from code of ItemTouTu
        for (double lightningDistance = 5.0; lightningDistance < 8.0; lightningDistance += 1.0) {
            for (double lightningAngle = 0.0; lightningAngle < maxAngle; lightningAngle += angleAddition) {
                worldIn.spawnEntity(new EntityLightningBolt(
                        worldIn,
                        playerIn.posX + lightningDistance * Math.cos(lightningAngle),
                        playerIn.posY,
                        playerIn.posZ + lightningDistance * Math.sin(lightningAngle),
                        false)
                );
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, jing_dai);
    }
}
