package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class ItemHeKuoLuo extends ItemFood {
    public ItemHeKuoLuo(int hungerHeal, float saturation, boolean isWolfFood) {
        super(hungerHeal, saturation, isWolfFood);

        String name = "he_kuo_luo";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);

        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        Vector<PotionEffect> effects = new Vector<>();

        for (int potionID = 1; potionID <= 27; potionID++){
            Potion potion = Objects.requireNonNull(Potion.getPotionById(potionID));
            PotionEffect effect;
            if (potionID == 6 || potionID == 7) {       // Instant health and damage
                effect = new PotionEffect(potion);
            } else {
                effect = new PotionEffect(potion, 200);
            }
            effects.add(effect);
        }

        Random random = new Random();
        if (!world.isRemote) {
            for (int i = 0; i < 3; i++) {
                player.addPotionEffect(effects.remove(random.nextInt(effects.size())));
            }
        }
    }
}
