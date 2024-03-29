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
        for (Item item: ItemsRegister.ITEM_LIST) {
            registerModel(item);
        }
    }

    private void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
