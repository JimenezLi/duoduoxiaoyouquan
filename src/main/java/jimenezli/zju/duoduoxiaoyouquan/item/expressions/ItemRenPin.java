package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemRenPin extends Item {
    public static final DamageSource DEATH_REN_PIN = new DamageSource("ren_pin").setDamageBypassesArmor();

    public ItemRenPin(){
        String name = "ren_pin";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    Block[] givenBlocks = {
        Blocks.COAL_BLOCK,
        Blocks.IRON_BLOCK,
        Blocks.GOLD_BLOCK,
        Blocks.DIAMOND_BLOCK,
        Blocks.REDSTONE_BLOCK,
        Blocks.LAPIS_BLOCK,
        Blocks.EMERALD_BLOCK
    };
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack ren_pin = playerIn.getHeldItem(handIn);

        for (Block block: givenBlocks) {
            playerIn.dropItem(new ItemStack(block), false);
        }

        if (!playerIn.capabilities.isCreativeMode) {
            ren_pin.shrink(1);
        }

        playerIn.attackEntityFrom(DEATH_REN_PIN, 2.0F);

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, ren_pin);
    }
}
