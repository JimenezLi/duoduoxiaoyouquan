package jimenezli.zju.duoduoxiaoyouquan.item;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.item.Item;

public class ItemYunDuoDuo extends Item {
    private static String name = "yunduoduo";
    public ItemYunDuoDuo(){
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }
}
