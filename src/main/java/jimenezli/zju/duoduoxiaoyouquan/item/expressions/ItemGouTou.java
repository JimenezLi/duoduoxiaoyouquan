package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.effect.EntityLightningBolt;
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

public class ItemGouTou extends Item {
    public ItemGouTou(){
        String name = "gou_tou";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private static final double angleAddition = Math.PI / 4.0;
    private static final double wolfSpawnDistance = 1.0;
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack gou_tou = playerIn.getHeldItem(handIn);
        gou_tou.shrink(1);

        //Copied from code of ItemJingDai
        for (int wolfCount = 0; wolfCount < 8; wolfCount++) {
            EntityWolf wolf = new EntityWolf(worldIn);
            wolf.setTamedBy(playerIn);
            wolf.setSitting(false);
            wolf.setHealth(wolf.getMaxHealth());
            wolf.setPositionAndRotation(
                    playerIn.posX + wolfSpawnDistance * Math.cos(angleAddition * wolfCount),
                    playerIn.posY,
                    playerIn.posZ + wolfSpawnDistance * Math.sin(angleAddition * wolfCount),
                    0.0F,
                    0.0F
            );
            if (!worldIn.isRemote) {
                worldIn.spawnEntity(wolf);
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, gou_tou);
    }
}
