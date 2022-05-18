package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
import java.util.Random;

public class ItemQiFu extends Item {
    private static final String name = "qi_fu";
    public ItemQiFu(){
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private final Random random = new Random();
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        double seed = random.nextDouble();
        ItemStack qi_fu = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            qi_fu.shrink(1);
        }

        //Copied from code of ItemTouTu
        //40% TNT, 50% golden_apple, 9% shulker_shell, 1% golden_apple(enchanted)
        if (!worldIn.isRemote) {
            if (seed < 0.4) {
                worldIn.spawnEntity(new EntityTNTPrimed(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, playerIn));
            } else if (seed < 0.9) {
                playerIn.dropItem(new ItemStack(Items.GOLDEN_APPLE, 1, 0), false);  //golden_apple
            } else if (seed < 0.99) {
                playerIn.dropItem(new ItemStack(Items.SHULKER_SHELL), false);  //shulker_shell
            } else {
                playerIn.dropItem(new ItemStack(Items.GOLDEN_APPLE, 1, 1), false);  //golden_apple(enchanted)
            }
        }
        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, qi_fu);
    }
}
