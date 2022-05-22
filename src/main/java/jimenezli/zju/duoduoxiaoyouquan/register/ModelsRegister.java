package jimenezli.zju.duoduoxiaoyouquan.register;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelsRegister {
    public ModelsRegister() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        registerModel(ItemsRegister.ironPlate);
        registerModel(ItemsRegister.yunduoduo_core);
        registerModel(ItemsRegister.yunduoduo);

        registerModel(ItemsRegister.bai_yan);
        registerModel(ItemsRegister.chi_gua);
        registerModel(ItemsRegister.ci_ya);
        registerModel(ItemsRegister.dian_zan);
        registerModel(ItemsRegister.fen);
        registerModel(ItemsRegister.fen_nu);
        registerModel(ItemsRegister.gan_ga);
        registerModel(ItemsRegister.gou_tou);
        registerModel(ItemsRegister.heng);
        registerModel(ItemsRegister.he_kuo_luo);
        registerModel(ItemsRegister.hua_ji);
        registerModel(ItemsRegister.jia_you);
        registerModel(ItemsRegister.jing_dai);
        registerModel(ItemsRegister.kai_xin);
        registerModel(ItemsRegister.ke_lian);
        registerModel(ItemsRegister.ma_le);
        registerModel(ItemsRegister.mei_yan_kan);
        registerModel(ItemsRegister.mo_tou);
        registerModel(ItemsRegister.qing_zhu);
        registerModel(ItemsRegister.qin_qin);
        registerModel(ItemsRegister.qi_fu);
        registerModel(ItemsRegister.ren_pin);
        registerModel(ItemsRegister.san_hua);
        registerModel(ItemsRegister.shang_xin);
        registerModel(ItemsRegister.tan_qi);
        registerModel(ItemsRegister.tou_tu);
        registerModel(ItemsRegister.tui_yan_jing);
        registerModel(ItemsRegister.tu_xie);
        registerModel(ItemsRegister.xiao_chou);
        registerModel(ItemsRegister.xiao_ku);
        registerModel(ItemsRegister.yi_wen);

        registerModel(ItemsRegister.charged_xiao_ku);
    }

    private void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
