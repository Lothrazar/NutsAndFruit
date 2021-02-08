package com.lothrazar.nutsandfruit.event;

import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemEvents {

  @SubscribeEvent
  public void onLootTableLoadEvent(LootTableLoadEvent event) {
    if (event.getName().toString().contains("leaf") || event.getName().toString().contains("leaves")) {
      NutsAndFruitMod.LOGGER.info("xxloot: " + event.getName());
    }
    NutsAndFruitMod.LOGGER.info("loot: " + event.getName());
  }
}
