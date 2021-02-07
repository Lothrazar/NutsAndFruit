package com.lothrazar.nutsandfruit.event;

import com.lothrazar.nutsandfruit.ExampleMod;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemEvents {

  @SubscribeEvent
  public void onLootTableLoadEvent(LootTableLoadEvent event) {
    ExampleMod.LOGGER.info("loot: " + event.getName());
  }
}
