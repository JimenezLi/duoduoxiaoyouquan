package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.util.EnumHelper;

public class ItemTuXie extends ItemSword {
    public static final DamageSource DEATH_TU_XIE = new DamageSource("tu_xie").setDamageBypassesArmor();
    public ItemTuXie(Item.ToolMaterial material){
        super(material);
    }

    @Override
    public float getAttackDamage() {
        return 1000.0F;
    }
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        attacker.attackEntityFrom(DEATH_TU_XIE, 19.0F);
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return false;
    }
}
