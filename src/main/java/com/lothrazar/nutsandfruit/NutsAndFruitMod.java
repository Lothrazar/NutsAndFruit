package com.lothrazar.nutsandfruit;

import com.lothrazar.nutsandfruit.registry.ContentRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NutsAndFruitMod.MODID)
public class NutsAndFruitMod {

  public static final String MODID = "nutsandfruit";

  public NutsAndFruitMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    ContentRegistry.ITEMS.register(bus);
  }
}
