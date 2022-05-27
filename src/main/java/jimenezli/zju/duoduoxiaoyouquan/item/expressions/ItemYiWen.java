package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemYiWen extends Item {
    public ItemYiWen(){
        String name = "yi_wen";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private static final double angleAddition = Math.PI / 4.0;
    private static final double villagerSpawnDistance = 1.0;
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack yi_wen = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            yi_wen.shrink(1);
        }

        //Copied from code of ItemJingDai
        for (int villagerCount = 0; villagerCount < 8; villagerCount++) {
            EntityVillager villager = new EntityVillager(worldIn);
            villager.setProfession(1);
            villager.setPositionAndRotation(
                    playerIn.posX + villagerSpawnDistance * Math.cos(angleAddition * villagerCount),
                    playerIn.posY,
                    playerIn.posZ + villagerSpawnDistance * Math.sin(angleAddition * villagerCount),
                    0.0F,
                    0.0F
            );
            if (!worldIn.isRemote) {
                worldIn.spawnEntity(villager);
            }
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, yi_wen);
    }
}
