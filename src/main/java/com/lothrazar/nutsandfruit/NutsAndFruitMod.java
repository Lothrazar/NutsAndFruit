package com.lothrazar.nutsandfruit;

import com.lothrazar.nutsandfruit.registry.ContentRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(NutsAndFruitMod.MODID)
public class NutsAndFruitMod {

  public static final String MODID = "nutsandfruit";

  public NutsAndFruitMod(IEventBus modEventBus) {
    ContentRegistry.ITEMS.register(modEventBus);
    ContentRegistry.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    modEventBus.addListener(this::setup);
  }

  private void setup(final FMLCommonSetupEvent event) {
    ContentRegistry.registerCompostables();
  }
}
