package jimenezli.zju.duoduoxiaoyouquan.register;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import jimenezli.zju.duoduoxiaoyouquan.item.expressions.*;
import jimenezli.zju.duoduoxiaoyouquan.item.hidden.ItemChargedXiaoKu;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ItemsRegister {
    //Learnt from code of Twilight Forest
    public static Item.ToolMaterial DUODUOXIAOYOUQUAN_TU_XIE = EnumHelper.addToolMaterial("DUODUOXIAOYOUQUAN_TU_XIE", 0, 1, 1.0F, 1000.0F, 1);

    public static final List<Item> EXPRESSION_LIST = new ArrayList<>();
    public static final List<Item> ITEM_LIST = new ArrayList<>();

    public static final Item ironPlate = buildItem(new Item(),"iron_plate");
    public static final Item yunduoduo =buildItem(new Item(),"yunduoduo");
    public static final Item yunduoduo_core =buildItem(new Item(),"yunduoduo_core");

    public static final Item bai_yan =buildExpression(new ItemBaiYan(),"bai_yan");
    public static final Item chi_gua =buildExpression(new ItemChiGua(20,1.0F,false),"chi_gua");
    public static final Item ci_ya =buildExpression(new ItemCiYa(),"ci_ya");
    public static final Item dian_zan =buildExpression(new ItemDianZan(),"dian_zan");
    public static final Item fen =buildExpression(new ItemFen(),"fen");
    public static final Item fen_nu =buildExpression(new ItemFenNu(),"fen_nu");
    public static final Item gan_ga =buildExpression(new ItemGanGa(),"gan_ga");
    public static final Item gou_tou =buildExpression(new ItemGouTou(),"gou_tou");
    public static final Item heng =buildExpression(new ItemHeng(),"heng");
    public static final Item he_kuo_luo =buildExpression(new ItemHeKuoLuo(6,0.2F,false),  "he_kuo_luo");
    public static final Item hua_ji =buildExpression(new ItemHuaJi(),"hua_ji");
    public static final Item jia_you =buildExpression(new ItemJiaYou(),"jia_you");
    public static final Item jing_dai =buildExpression(new ItemJingDai(),"jing_dai");
    public static final Item kai_xin =buildExpression(new ItemKaiXin(),"kai_xin");
    public static final Item ke_lian =buildExpression(new ItemKeLian(),"ke_lian");
    public static final Item ma_le =buildExpression(new ItemMaLe(),"ma_le");
    public static final Item mei_yan_kan =buildExpression(new ItemMeiYanKan(),"mei_yan_kan");
    public static final Item mo_tou =buildExpression(new ItemMoTou(),"mo_tou");
    public static final Item qing_zhu =buildExpression(new ItemQingZhu(),"qing_zhu");
    public static final Item qin_qin =buildExpression(new ItemQinQin(),"qin_qin");
    public static final Item qi_fu =buildExpression(new ItemQiFu(),"qi_fu");
    public static final Item ren_pin =buildExpression(new ItemRenPin(),"ren_pin");
    public static final Item san_hua =buildExpression(new ItemSanHua(),"san_hua");
    public static final Item shang_xin =buildExpression(new ItemShangXin(),"shang_xin");
    public static final Item tan_qi =buildExpression(new ItemTanQi(),"tan_qi");
    public static final Item tou_tu =buildExpression(new ItemTouTu(),"tou_tu");
    public static final Item tui_yan_jing =buildExpression(new ItemTuiYanJing(),"tui_yan_jing");
    public static final Item tu_xie =buildExpression(new ItemTuXie(DUODUOXIAOYOUQUAN_TU_XIE),"tu_xie");
    public static final Item xiao_chou =buildExpression(new ItemXiaoChou(),"xiao_chou");
    public static final Item xiao_ku =buildExpression(new ItemXiaoKu(),"xiao_ku");
    public static final Item yi_wen =buildExpression(new ItemYiWen(),"yi_wen");
    public static final Item charged_xiao_ku =buildExpression(new ItemChargedXiaoKu(),"charged_xiao_ku");

    public ItemsRegister() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Item item: ITEM_LIST){
            event.getRegistry().register(item);
        }
    }

    private static Item buildItem(Item item, String name) {
        item.setRegistryName(name);
        item.setUnlocalizedName(Reference.MODID + "." + name);
        item.setCreativeTab(duoduoxiaoyouquan.DUODUO);
        ITEM_LIST.add(item);
        return item;
    }

    private static Item buildExpression(Item item, String name) {
        EXPRESSION_LIST.add(item);
        return buildItem(item, name);
    }
}