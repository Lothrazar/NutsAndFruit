package com.lothrazar.nutsandfruit.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFuel extends Item {

  public ItemFuel(Properties properties) {
    super(properties);
  }

  @Override
  public int getBurnTime(ItemStack itemStack) {
    return 200;
  }
}
