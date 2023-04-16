package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemGanGa extends Item {
    public ItemGanGa(){
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack gan_ga = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            gan_ga.shrink(1);
        }

        if (!worldIn.isRemote) {
            for (Entity entity: worldIn.loadedEntityList) {
                if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer)) {
                    if (entity.getDistance(playerIn) < 20.0F) {
                        ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 1));
                    }
                }
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, gan_ga);
    }
}
