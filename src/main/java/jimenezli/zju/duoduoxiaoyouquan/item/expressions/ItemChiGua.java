package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemChiGua extends ItemFood {
    private static String name = "chi_gua";
    public ItemChiGua(int hungerHeal, float saturation, boolean isWolfFood){
        super(hungerHeal, saturation, isWolfFood);

        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);

        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {

    }
}
