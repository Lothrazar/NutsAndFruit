package com.lothrazar.nutsandfruit.event;

import com.lothrazar.nutsandfruit.NutFruitsMod;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemEvents {

  @SubscribeEvent
  public void onLootTableLoadEvent(LootTableLoadEvent event) {
    NutFruitsMod.LOGGER.info("loot: " + event.getName());
  }
}
