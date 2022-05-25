package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class ItemJiaYou extends Item {
    public ItemJiaYou(){
        String name = "jia_you";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack xiao_ku = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            xiao_ku.shrink(1);
        }

        if (!worldIn.isRemote) {
            playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 72000, 1));
            playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 72000, 1));
            playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 72000, 1));
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, xiao_ku);
    }
}
