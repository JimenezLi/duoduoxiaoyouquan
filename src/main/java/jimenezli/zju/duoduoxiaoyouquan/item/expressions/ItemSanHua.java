package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;

public class ItemSanHua extends Item {
    public ItemSanHua(){
        String name = "san_hua";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private static final double angleAddition = Math.PI / 4.0;
    private static final double ocelotSpawnDistance = 1.0;
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        Random random = new Random();
        ItemStack san_hua = playerIn.getHeldItem(handIn);
        san_hua.shrink(1);

        //The same as code of ItemGouTou
        for (int ocelotCount = 0; ocelotCount < 8; ocelotCount++) {
            EntityOcelot ocelot = new EntityOcelot(worldIn);
            ocelot.setTamedBy(playerIn);
            ocelot.setTameSkin(1 + random.nextInt(3));      //Only 3 kinds of cat in Minecraft 1.12.2
            ocelot.setSitting(false);
            ocelot.setHealth(ocelot.getMaxHealth());
            ocelot.setPositionAndRotation(
                    playerIn.posX + ocelotSpawnDistance * Math.cos(angleAddition * ocelotCount),
                    playerIn.posY,
                    playerIn.posZ + ocelotSpawnDistance * Math.sin(angleAddition * ocelotCount),
                    0.0F,
                    0.0F
            );
            if (!worldIn.isRemote) {
                worldIn.spawnEntity(ocelot);
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, san_hua);
    }
}
