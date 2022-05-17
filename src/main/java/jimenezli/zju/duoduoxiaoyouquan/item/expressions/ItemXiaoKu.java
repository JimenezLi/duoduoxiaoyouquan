package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import ibxm.Player;
import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class ItemXiaoKu extends Item {
    public ItemXiaoKu(){
        String name = "xiao_ku";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    //Bad in efficiency
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        Vector<PotionEffect> goodEffects = new Vector<>();
        Vector<PotionEffect> badEffects = new Vector<>();

        for (int potionID = 1; potionID <= 27; potionID++){
            Potion potion = Objects.requireNonNull(Potion.getPotionById(potionID));
            boolean isBadEffect = potion.isBadEffect();
            PotionEffect effect;
            if (potionID == 6 || potionID == 7) {       // Instant health and damage
                effect = new PotionEffect(potion);
            } else {
                effect = new PotionEffect(potion, 200);
            }
            if (isBadEffect){
                badEffects.add(effect);
            } else {
                goodEffects.add(effect);
            }
        }

        int goodEffectNumber = goodEffects.size();
        int badEffectNumber = badEffects.size();
        Random random = new Random();
        PotionEffect goodEffect = goodEffects.get(random.nextInt(goodEffectNumber));
        PotionEffect badEffect = badEffects.get(random.nextInt(badEffectNumber));

        ItemStack xiao_ku = playerIn.getHeldItem(handIn);
        xiao_ku.shrink(1);

        //Copied from code of ItemJingDai
        if (!worldIn.isRemote) {
            playerIn.addPotionEffect(goodEffect);
            playerIn.addPotionEffect(badEffect);
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, xiao_ku);
    }
}
