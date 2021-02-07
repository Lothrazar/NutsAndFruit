package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.nutsandfruit.ItemNut;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleRegistry {
  //change Object to your Block/Item/whatever 
  //  @ObjectHolder(ExampleMod.MODID + ":anything")
  //  public static Object anything;

  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    //IForgeRegistry<Block> r = event.getRegistry();
    //    r.register(  );
  }

  @SubscribeEvent
  public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
    //   IForgeRegistry<TileEntityType<?>> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> r = event.getRegistry();
    r.register(new ItemNut(new Item.Properties()).setRegistryName("lime"));
    //    r.register(new ItemNut(new Item.Properties()));
    //    r.register(new ItemFruit(new Item.Properties()));
    //    r.register(new ItemFruit(new Item.Properties()));
    //    r.register(new ItemFruit(new Item.Properties()));
  }

  @SubscribeEvent
  public static void onPotEffectRegistry(RegistryEvent.Register<Effect> event) {
    //  IForgeRegistry<Effect> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void onPotRegistry(RegistryEvent.Register<Potion> event) {
    //   IForgeRegistry<Potion> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
    //  IForgeRegistry<SoundEvent> r = event.getRegistry();
  }
}
