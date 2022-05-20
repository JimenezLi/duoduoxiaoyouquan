package jimenezli.zju.duoduoxiaoyouquan.item.expressions;

import jimenezli.zju.duoduoxiaoyouquan.Reference;
import jimenezli.zju.duoduoxiaoyouquan.duoduoxiaoyouquan;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemHuaJi extends Item {
    public ItemHuaJi(){
        String name = "hua_ji";
        this.setRegistryName(Reference.MODID + ":" + name);
        this.setUnlocalizedName(Reference.MODID + "." + name);
        this.setCreativeTab(duoduoxiaoyouquan.DUODUO);
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand handIn, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack hua_ji = playerIn.getHeldItem(handIn);
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, hua_ji))
        {
            return EnumActionResult.FAIL;
        }

        if (!playerIn.capabilities.isCreativeMode) {
            hua_ji.shrink(1);
        }

        //Copied from ItemMonsterPlacer
        BlockPos blockpos = pos.offset(facing);
        double posX = (double)blockpos.getX() + 0.5D;
        double posY = (double)blockpos.getY() + 1.0D;
        double posZ = (double)blockpos.getZ() + 0.5D;

        EntityParrot parrot = new EntityParrot(worldIn);
        EntityRabbit rabbit = new EntityRabbit(worldIn);
        EntityChicken chicken = new EntityChicken(worldIn);
        EntityPig pig = new EntityPig(worldIn);
        EntitySheep sheep = new EntitySheep(worldIn);
//        EntityHorse horse = new EntityHorse(worldIn);
//        EntityDonkey donkey = new EntityDonkey(worldIn);
//        EntityLlama llama = new EntityLlama(worldIn);
        EntityCow cow = new EntityCow(worldIn);
        EntityMooshroom mooshroom = new EntityMooshroom(worldIn);

        parrot.setPosition(posX, posY, posZ);
        rabbit.setPosition(posX, posY, posZ);
        chicken.setPosition(posX, posY, posZ);
        pig.setPosition(posX, posY, posZ);
        sheep.setPosition(posX, posY, posZ);
//        horse.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
//        donkey.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
//        llama.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
        cow.setPosition(posX, posY, posZ);
        mooshroom.setPosition(posX, posY, posZ);

        if (!worldIn.isRemote) {
            worldIn.spawnEntity(parrot);
            worldIn.spawnEntity(rabbit);
            worldIn.spawnEntity(chicken);
            worldIn.spawnEntity(pig);
            worldIn.spawnEntity(sheep);
//            worldIn.spawnEntity(horse);
//            worldIn.spawnEntity(donkey);
//            worldIn.spawnEntity(llama);
            worldIn.spawnEntity(cow);
            worldIn.spawnEntity(mooshroom);
        }
        parrot.startRiding(rabbit);
        rabbit.startRiding(chicken);
        chicken.startRiding(pig);
        pig.startRiding(sheep);
//        sheep.startRiding(horse);
//        horse.startRiding(donkey);
//        donkey.startRiding(llama);
//        llama.startRiding(cow);
        sheep.startRiding(cow);
        cow.startRiding(mooshroom);

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return EnumActionResult.SUCCESS;
    }
}
