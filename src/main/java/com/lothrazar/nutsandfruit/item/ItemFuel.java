package com.lothrazar.nutsandfruit.item;

import com.lothrazar.library.item.ItemFlib;

public class ItemFuel extends ItemFlib {

  public ItemFuel(Properties properties) {
    super(properties, new ItemFlib.Settings().burnTime(200));
  }
}
