package jimenezli.zju.duoduoxiaoyouquan.register;

import jimenezli.zju.duoduoxiaoyouquan.item.ItemIronPlate;
import jimenezli.zju.duoduoxiaoyouquan.item.ItemYunDuoDuo;
import jimenezli.zju.duoduoxiaoyouquan.item.ItemYunDuoDuoCore;
import jimenezli.zju.duoduoxiaoyouquan.item.expressions.*;
import jimenezli.zju.duoduoxiaoyouquan.item.hidden.ItemChargedXiaoKu;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemsRegister {
    //Learnt from code of Twilight Forest
    public static Item.ToolMaterial DUODUOXIAOYOUQUAN_TU_XIE = EnumHelper.addToolMaterial("DUODUOXIAOYOUQUAN_TU_XIE", 0, 1, 1.0F, 1000.0F, 1);


    public static final ItemIronPlate ironPlate = new ItemIronPlate();
    public static final ItemYunDuoDuo yunduoduo = new ItemYunDuoDuo();
    public static final ItemYunDuoDuoCore yunduoduo_core = new ItemYunDuoDuoCore();

    public static final ItemBaiYan bai_yan = new ItemBaiYan();
    public static final ItemChiGua chi_gua = new ItemChiGua(20, 1.0F, false);
    public static final ItemCiYa ci_ya = new ItemCiYa();
    public static final ItemDianZan dian_zan = new ItemDianZan();
    public static final ItemFen fen = new ItemFen();
    public static final ItemFenNu fen_nu = new ItemFenNu();
    public static final ItemGanGa gan_ga = new ItemGanGa();
    public static final ItemGouTou gou_tou = new ItemGouTou();
    public static final ItemHeng heng = new ItemHeng();
    public static final ItemHeKuoLuo he_kuo_luo = new ItemHeKuoLuo(6, 0.2F, false);
    public static final ItemHuaJi hua_ji = new ItemHuaJi();
    public static final ItemJiaYou jia_you = new ItemJiaYou();
    public static final ItemJingDai jing_dai = new ItemJingDai();
    public static final ItemKaiXin kai_xin = new ItemKaiXin();
    public static final ItemKeLian ke_lian = new ItemKeLian();
    public static final ItemMaLe ma_le = new ItemMaLe();
    public static final ItemMeiYanKan mei_yan_kan = new ItemMeiYanKan();
    public static final ItemMoTou mo_tou = new ItemMoTou();
    public static final ItemQingZhu qing_zhu = new ItemQingZhu();
    public static final ItemQinQin qin_qin = new ItemQinQin();
    public static final ItemQiFu qi_fu = new ItemQiFu();
    public static final ItemRenPin ren_pin = new ItemRenPin();
    public static final ItemSanHua san_hua = new ItemSanHua();
    public static final ItemShangXin shang_xin = new ItemShangXin();
    public static final ItemTanQi tan_qi = new ItemTanQi();
    public static final ItemTouTu tou_tu = new ItemTouTu();
    public static final ItemTuiYanJing tui_yan_jing = new ItemTuiYanJing();
    public static final ItemTuXie tu_xie = new ItemTuXie(DUODUOXIAOYOUQUAN_TU_XIE);
    public static final ItemXiaoChou xiao_chou = new ItemXiaoChou();
    public static final ItemXiaoKu xiao_ku = new ItemXiaoKu();
    public static final ItemYiWen yi_wen = new ItemYiWen();

    public static final ItemChargedXiaoKu charged_xiao_ku = new ItemChargedXiaoKu();

    public static Item[] expressionList = {
            bai_yan, chi_gua, ci_ya, dian_zan, fen, fen_nu, gan_ga, gou_tou, heng, he_kuo_luo, hua_ji, jia_you, jing_dai, kai_xin, ke_lian, ma_le, mei_yan_kan, mo_tou, qing_zhu, qin_qin, qi_fu, ren_pin, san_hua, shang_xin, tan_qi, tou_tu, tui_yan_jing, tu_xie, xiao_chou, xiao_ku, yi_wen
    };

    public ItemsRegister() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ironPlate);
        event.getRegistry().register(yunduoduo_core);
        event.getRegistry().register(yunduoduo);
//        event.getRegistry().registerAll(
//                bai_yan, chi_gua, ci_ya, dian_zan, fen, fen_nu, gan_ga, gou_tou, heng, he_kuo_luo, hua_ji, jia_you, jing_dai, kai_xin, ke_lian, ma_le, mei_yan_kan, mo_tou, qing_zhu, qin_qin, qi_fu, ren_pin, san_hua, shang_xin, tan_qi, tou_tu, tui_yan_jing, tu_xie, xiao_chou, xiao_ku, yi_wen
//        );
        for (Item expression: expressionList){
            event.getRegistry().register(expression);
        }

        event.getRegistry().register(charged_xiao_ku);
    }
}