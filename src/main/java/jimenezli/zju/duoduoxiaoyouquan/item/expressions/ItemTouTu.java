package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import mcp.MethodsReturnNonnullByDefault;
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

public class ItemTouTu extends Item {
    public ItemTouTu(){
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
    }

    private final Random random = new Random();

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack;
        double seed = random.nextDouble();

        // web: 10%; lead: 10%; string: 80%
        if (seed < 0.1) {
            itemstack = new ItemStack(Blocks.WEB);                  //minecraft:web
        } else if (seed >= 0.9) {
            itemstack = new ItemStack(Items.LEAD);                  //minecraft:lead
        } else {
            itemstack = new ItemStack(Items.STRING);                //minecraft:string
        }

        ItemStack tou_tu = playerIn.getHeldItem(handIn);

        //Copied from code of ItemEmptyMap
        if (tou_tu.isEmpty())
        {
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            if (!playerIn.inventory.addItemStackToInventory(itemstack.copy()))
            {
                playerIn.dropItem(itemstack, false);
            }

            if (!playerIn.capabilities.isCreativeMode) {
                tou_tu.damageItem(1, playerIn);
            }
            playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, tou_tu);
        }
    }
}
