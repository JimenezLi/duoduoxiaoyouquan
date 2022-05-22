package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
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

public class ItemXiaoChou extends Item {
    public ItemXiaoChou(){
        String name = "xiao_chou";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    private final Random random = new Random();

    public final double sheepSpawnDistance = 5.0;
    public final double sheepSpawnAngle = Math.PI / 8.0;

    enum ColorfulItems{
        WOOL,
        STAINED_GLASS,
        STAINED_HARDENED_CLAY,
        CONCRETE,
        CONCRETE_POWDER,
        STAINED_GLASS_PANE,
        CARPET,
        GLAZED_TERRACOTTA,
        BED,
        BANNER,
        DYE,
        SHEEP,
        SHULKER_BOX
    }
    ColorfulItems[] CItems = ColorfulItems.values();
    EnumDyeColor[] EDyeColor = EnumDyeColor.values();
    public final Block[] glazedTerracotta = {
        Blocks.WHITE_GLAZED_TERRACOTTA,
        Blocks.ORANGE_GLAZED_TERRACOTTA,
        Blocks.MAGENTA_GLAZED_TERRACOTTA,
        Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
        Blocks.YELLOW_GLAZED_TERRACOTTA,
        Blocks.LIME_GLAZED_TERRACOTTA,
        Blocks.PINK_GLAZED_TERRACOTTA,
        Blocks.GRAY_GLAZED_TERRACOTTA,
        Blocks.SILVER_GLAZED_TERRACOTTA,
        Blocks.CYAN_GLAZED_TERRACOTTA,
        Blocks.PURPLE_GLAZED_TERRACOTTA,
        Blocks.BLUE_GLAZED_TERRACOTTA,
        Blocks.BROWN_GLAZED_TERRACOTTA,
        Blocks.GREEN_GLAZED_TERRACOTTA,
        Blocks.RED_GLAZED_TERRACOTTA,
        Blocks.BLACK_GLAZED_TERRACOTTA
    };

    public final Block[] shulkerBox = {
        Blocks.WHITE_SHULKER_BOX,
        Blocks.ORANGE_SHULKER_BOX,
        Blocks.MAGENTA_SHULKER_BOX,
        Blocks.LIGHT_BLUE_SHULKER_BOX,
        Blocks.YELLOW_SHULKER_BOX,
        Blocks.LIME_SHULKER_BOX,
        Blocks.PINK_SHULKER_BOX,
        Blocks.GRAY_SHULKER_BOX,
        Blocks.SILVER_SHULKER_BOX,
        Blocks.CYAN_SHULKER_BOX,
        Blocks.PURPLE_SHULKER_BOX,
        Blocks.BLUE_SHULKER_BOX,
        Blocks.BROWN_SHULKER_BOX,
        Blocks.GREEN_SHULKER_BOX,
        Blocks.RED_SHULKER_BOX,
        Blocks.BLACK_SHULKER_BOX
    };

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack xiao_chou = playerIn.getHeldItem(handIn);
        ColorfulItems colorfulItem;
        double seedShulker = random.nextDouble();
        if (seedShulker < 0.001) {
            colorfulItem = ColorfulItems.SHULKER_BOX;
        } else {
            colorfulItem = CItems[random.nextInt(CItems.length - 1)];
        }

        switch (colorfulItem) {
            case BED:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Items.BED, 1, value), false);
                }
                break;
            case DYE:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Items.DYE, 1, value), false);
                }
                break;
            case WOOL:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.WOOL, 1, value), false);
                }
                break;
            case BANNER:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Items.BANNER, 1, value), false);
                }
                break;
            case CARPET:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.CARPET, 1, value), false);
                }
                break;
            case CONCRETE:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.CONCRETE, 1, value), false);
                }
                break;
            case CONCRETE_POWDER:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.CONCRETE_POWDER, 1, value), false);
                }
                break;
            case STAINED_GLASS:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.STAINED_GLASS, 1, value), false);
                }
                break;
            case STAINED_GLASS_PANE:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, value), false);
                }
                break;
            case STAINED_HARDENED_CLAY:
                for (int value = 0; value < 16; value++) {
                    playerIn.dropItem(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, value), false);
                }
                break;
            case GLAZED_TERRACOTTA:
                for (Block block: glazedTerracotta) {
                    playerIn.dropItem(new ItemStack(block), false);
                }
                break;
            case SHULKER_BOX:
                for (Block block: shulkerBox) {
                    playerIn.dropItem(new ItemStack(block), false);
                }
            case SHEEP:
                for (int value = 0; value < 16; value++) {
                    EntitySheep sheep = new EntitySheep(worldIn);
                    sheep.setFleeceColor(EDyeColor[value]);
                    sheep.setPosition(
                            playerIn.posX + sheepSpawnDistance * Math.cos(value * sheepSpawnAngle),
                            playerIn.posY,
                            playerIn.posZ + sheepSpawnDistance * Math.sin(value * sheepSpawnAngle)
                    );
                    if (!worldIn.isRemote) {
                        worldIn.spawnEntity(sheep);
                    }
                }
            default:
                break;
        }

        if (!playerIn.capabilities.isCreativeMode) {
            xiao_chou.shrink(1);
        }
        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, xiao_chou);
    }
}
