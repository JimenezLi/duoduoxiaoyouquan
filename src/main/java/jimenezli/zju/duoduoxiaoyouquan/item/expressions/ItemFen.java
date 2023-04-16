package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemFen extends Item {
    public ItemFen(){
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack fen = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            fen.shrink(1);
        }

        for (Entity entity: worldIn.loadedEntityList) {
            if (!entity.equals(playerIn)) {
                float distance = entity.getDistance(playerIn);
                double pushSpeed = (distance < 10.0F) ? (10.0 - (double) distance) : 0.0;
                Vec3d vec3d = new Vec3d(
                        entity.posX - playerIn.posX,
                        entity.posY - playerIn.posY,
                        entity.posZ - playerIn.posZ
                ).normalize();
                entity.addVelocity(
                        vec3d.x * pushSpeed,
                        vec3d.y * pushSpeed,
                        vec3d.z * pushSpeed
                );
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, fen);
    }
}
