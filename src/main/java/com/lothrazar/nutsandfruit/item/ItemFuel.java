package com.lothrazar.nutsandfruit.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.RecipeType;

public class ItemFuel extends Item {

  public ItemFuel(Properties properties) {
    super(properties);
  }

  @Override
  public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
    return 200;
  }
}
