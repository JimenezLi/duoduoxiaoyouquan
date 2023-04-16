package jimenezli.zju.duoduoxiaoyouquan.item.hidden;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.player.EntityPlayer;
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
import java.util.Vector;

public class ItemChargedXiaoKu extends Item {
    public ItemChargedXiaoKu() {
    }

    //Bad in efficiency
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Vector<PotionEffect> allEffects = new Vector<>();

        for (int potionID = 1; potionID <= 27; potionID++) {
            Potion potion = Objects.requireNonNull(Potion.getPotionById(potionID));
            PotionEffect effect;
            if (potionID == 6 || potionID == 7) {       // Instant health and damage
                effect = new PotionEffect(potion);
            } else {
                effect = new PotionEffect(potion, 200);
            }
            allEffects.add(effect);
        }

        ItemStack charged_xiao_ku = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            charged_xiao_ku.shrink(1);
        }

        //Copied from code of ItemJingDai
        if (!worldIn.isRemote) {
            for (PotionEffect effect : allEffects) {
                playerIn.addPotionEffect(effect);
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, charged_xiao_ku);
    }
}