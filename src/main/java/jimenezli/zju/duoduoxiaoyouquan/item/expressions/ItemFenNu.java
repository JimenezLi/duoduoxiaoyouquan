package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemFenNu extends Item {
    public ItemFenNu(){
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
    }

    private final int explosionStrength = 1;

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack fen_nu = playerIn.getHeldItem(handIn);
        worldIn.playSound(null , playerIn.posX, playerIn.posY, playerIn.posZ,
                SoundEvents.ENTITY_ENDERDRAGON_SHOOT, SoundCategory.NEUTRAL,
                0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            //This part is directly copied from EntityGhast
            Vec3d vec3d = playerIn.getLookVec().normalize();
            double distanceRate = 1.0D;
            double accelerationRate = 1.0D;
            EntityLargeFireball entitylargefireball = new EntityLargeFireball(worldIn, playerIn, 0, 0, 0);
            entitylargefireball.explosionPower = this.explosionStrength;
            entitylargefireball.posX = playerIn.posX + vec3d.x * distanceRate;
            entitylargefireball.posY = playerIn.posY + (double)(playerIn.height / 2.0F) + distanceRate;
            entitylargefireball.posZ = playerIn.posZ + vec3d.z * distanceRate;
            entitylargefireball.accelerationX = vec3d.x * accelerationRate;
            entitylargefireball.accelerationY = vec3d.y * accelerationRate;
            entitylargefireball.accelerationZ = vec3d.z * accelerationRate;
            worldIn.spawnEntity(entitylargefireball);
        }

        if (!playerIn.capabilities.isCreativeMode) {
            fen_nu.damageItem(1, playerIn);
        }
        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, fen_nu);
    }
}
