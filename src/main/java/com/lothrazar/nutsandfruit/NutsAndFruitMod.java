package com.lothrazar.nutsandfruit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.nutsandfruit.registry.ContentRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NutsAndFruitMod.MODID)
public class NutsAndFruitMod {

  public static final String MODID = "nutsandfruit";
  public static final Logger LOGGER = LogManager.getLogger();

  public NutsAndFruitMod() {
    //    ConfigManager.setup();
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    ContentRegistry.ITEMS.register(bus);
  }

  private void setup(final FMLCommonSetupEvent event) {
    //    MinecraftForge.EVENT_BUS.register(new ItemEvents());
  }
}
