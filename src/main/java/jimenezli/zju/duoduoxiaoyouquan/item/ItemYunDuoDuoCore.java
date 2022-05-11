package jimenezli.zju.duoduoxiaoyouquan.item;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.item.Item;

public class ItemYunDuoDuoCore extends Item {
    private static String name = "yunduoduo_core";
    public ItemYunDuoDuoCore(){
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }
}
