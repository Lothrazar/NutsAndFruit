package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import com.lothrazar.nutsandfruit.item.ItemFuel;
import com.lothrazar.nutsandfruit.item.ItemLingon;
import com.lothrazar.nutsandfruit.item.ItemPlain;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContentRegistry {

  @ObjectHolder(NutsAndFruitMod.MODID + ":chestnut")
  public static Item CHESTNUT;
  @ObjectHolder(NutsAndFruitMod.MODID + ":lingonberry_twig")
  public static Item LINGONBERRY_TWIG;
  public static final CreativeModeTab GRP = new CreativeModeTab(NutsAndFruitMod.MODID) {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(ContentRegistry.CHESTNUT);
    }
  };

  @SubscribeEvent
  public static void registerModifierSerializers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
    event.getRegistry().register(new LootTableMod.Serializer().setRegistryName(NutsAndFruitMod.MODID + ":loot"));
  }

  @SubscribeEvent
  public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> r = event.getRegistry();
    r.register(new ItemPlain(new Item.Properties().tab(GRP).food(Foods.GOLDEN_CARROT)).setRegistryName("fruit_mix"));
    r.register(new ItemPlain(new Item.Properties().tab(GRP).food(Foods.SWEET_BERRIES)).setRegistryName("lime"));
    r.register(new ItemLingon(new Item.Properties().tab(GRP).food(Foods.MELON_SLICE)).setRegistryName("lingonberry"));
    r.register(new ItemFuel(new Item.Properties().tab(GRP)).setRegistryName("lingonberry_twig"));
    r.register(new ItemPlain(new Item.Properties().tab(GRP).food(Foods.APPLE)).setRegistryName("pineapple"));
    r.register(new ItemPlain(new Item.Properties().tab(GRP)).setRegistryName("chestnut"));
    r.register(new ItemPlain(new Item.Properties().tab(GRP).food(Foods.COOKED_BEEF)).setRegistryName("chestnut_roasted"));
    r.register(new ItemFuel(new Item.Properties().tab(GRP)).setRegistryName("conifer_cone"));
    r.register(new ItemPlain(new Item.Properties().tab(GRP).food(Foods.GOLDEN_CARROT)).setRegistryName("trail_mix"));
  }
}
