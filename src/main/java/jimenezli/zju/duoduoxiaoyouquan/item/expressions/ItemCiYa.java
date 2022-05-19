package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemCiYa extends Item {
    public ItemCiYa(){
        String name = "ci_ya";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private static final double skeletonAngleAddition = Math.PI / 2.0;
    private static final double skeletonSpawnDistance = 6.0;
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack ci_ya = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            ci_ya.shrink(1);
        }

        //Copied from code of ItemQingZhu
        for (int skeletonCount = 0; skeletonCount < 4; skeletonCount++) {
            EntitySkeleton skeleton = new EntitySkeleton(worldIn);
            skeleton.setPosition(
                    playerIn.posX + skeletonSpawnDistance * Math.cos(skeletonAngleAddition * skeletonCount),
                    playerIn.posY,
                    playerIn.posZ + skeletonSpawnDistance * Math.sin(skeletonAngleAddition * skeletonCount)
            );
            if (!worldIn.isRemote) {
                worldIn.spawnEntity(skeleton);
            }
        }

        playerIn.dropItem(new ItemStack(Items.BEETROOT_SOUP), false);
        playerIn.dropItem(new ItemStack(Items.MUSHROOM_STEW), false);
        playerIn.dropItem(new ItemStack(Items.RABBIT_STEW), false);

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, ci_ya);
    }
}
