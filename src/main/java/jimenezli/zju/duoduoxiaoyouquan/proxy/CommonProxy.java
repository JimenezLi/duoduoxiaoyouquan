package jimenezli.zju.duoduoxiaoyouquan.proxy;

import jimenezli.zju.duoduoxiaoyouquan.common.Recipes;
import jimenezli.zju.duoduoxiaoyouquan.register.ItemsRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ItemsRegister items = new ItemsRegister();
        OreDictionary.registerOre("plateIron", items.ironPlate);
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

