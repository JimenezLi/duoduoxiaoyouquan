package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import java.util.ArrayList;
import java.util.List;
import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityOcelot;
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

public class ItemMeiYanKan extends Item {
    public ItemMeiYanKan(){
        this.setMaxStackSize(1);        //Do not cheat on your partner!
    }

    private final Random random = new Random();
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack mei_yan_kan = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            mei_yan_kan.shrink(1);
        }

        boolean notCheated = true;
        EntityOcelot lover = new EntityOcelot(worldIn);
        lover.setCustomNameTag(I18n.format("item.duoduoxiaoyouquan.mei_yan_kan.lover_name"));
        lover.setTamedBy(playerIn);
        lover.setSitting(false);
        lover.setTameSkin(1 + random.nextInt(3));
        lover.setHealth(lover.getMaxHealth());
        lover.setPositionAndRotation(playerIn.posX, playerIn.posY, playerIn.posZ, 0.0F, 0.0F);
        List<Entity> worldEntities = new ArrayList<>(worldIn.loadedEntityList);
        for (Entity entity: worldEntities) {
            if (entity instanceof EntityOcelot) {
                if (((EntityOcelot) entity).getOwner() == playerIn
                        && entity.getName().equals(I18n.format("item.duoduoxiaoyouquan.mei_yan_kan.lover_name"))) {
                    notCheated = false;
                    for (int lightningCount = 0; lightningCount < 16; lightningCount++) {
                        worldIn.spawnEntity(new EntityLightningBolt(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, false));
                    }
                    break;
                }
            }
        }
        if (!worldIn.isRemote && notCheated) {
            worldIn.spawnEntity(lover);
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, mei_yan_kan);
    }
}
