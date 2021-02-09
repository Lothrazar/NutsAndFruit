package com.lothrazar.nutsandfruit.item;

import com.lothrazar.nutsandfruit.registry.ContentRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLingon extends Item {

  public ItemLingon(Properties properties) {
    super(properties);
  }

  /**
   * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using the Item before the action is complete.
   */
  @Override
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
    ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
    if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
      entityLiving.entityDropItem(new ItemStack(ContentRegistry.LINGONBERRY_TWIG));
    }
    return itemstack;
  }
}
