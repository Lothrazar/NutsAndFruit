package com.lothrazar.nutsandfruit.item;

import com.lothrazar.nutsandfruit.registry.ContentRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemLingon extends Item {

  public ItemLingon(Properties properties) {
    super(properties);
  }

  /**
   * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using the Item before the action is complete.
   */
  @Override
  public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
    ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);
    if (entityLiving instanceof Player && !((Player) entityLiving).isCreative()) {
      entityLiving.spawnAtLocation(new ItemStack(ContentRegistry.LINGONBERRY_TWIG));
    }
    return itemstack;
  }
}
