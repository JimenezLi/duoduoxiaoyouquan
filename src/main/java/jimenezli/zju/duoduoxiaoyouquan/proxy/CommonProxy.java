package jimenezli.zju.duoduoxiaoyouquan.proxy;

import jimenezli.zju.duoduoxiaoyouquan.common.Recipes;
import jimenezli.zju.duoduoxiaoyouquan.register.ItemsRegister;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new ItemsRegister();
        OreDictionary.registerOre("plateIron", ItemsRegister.ironPlate);
        for (Item expression: ItemsRegister.expressionList){
            OreDictionary.registerOre("listAllExpression", expression);
        }
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        new Recipes();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // TODO
    }
}

