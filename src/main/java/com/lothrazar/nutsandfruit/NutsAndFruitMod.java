package com.lothrazar.nutsandfruit;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NutsAndFruitMod.MODID)
public class NutsAndFruitMod {

  public static final String MODID = "nutsandfruit";
  public static final Logger LOGGER = LogManager.getLogger();

  public NutsAndFruitMod() {
    //    ConfigManager.setup();
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
  }

  private void setup(final FMLCommonSetupEvent event) {
    //    MinecraftForge.EVENT_BUS.register(new ItemEvents());
  }
}
