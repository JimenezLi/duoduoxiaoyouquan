package jimenezli.zju.duoduoxiaoyouquan.common;

import jimenezli.zju.duoduoxiaoyouquan.register.ItemsRegister;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
    public Recipes(){
        GameRegistry.addSmelting(ItemsRegister.shang_xin, new ItemStack(ItemsRegister.tan_qi), 10.0f);
        GameRegistry.addSmelting(ItemsRegister.chi_gua, new ItemStack(ItemsRegister.jing_dai), 10.0f);
        GameRegistry.addSmelting(ItemsRegister.qin_qin, new ItemStack(ItemsRegister.heng), 10.0f);
        GameRegistry.addSmelting(ItemsRegister.xiao_chou, new ItemStack(ItemsRegister.ma_le), 10.0f);
        GameRegistry.addSmelting(ItemsRegister.kai_xin, new ItemStack(ItemsRegister.ci_ya), 10.0f);
        GameRegistry.addSmelting(ItemsRegister.jia_you, new ItemStack(ItemsRegister.dian_zan), 10.0f);
    }
}
