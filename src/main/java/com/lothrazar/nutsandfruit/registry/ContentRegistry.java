package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import com.lothrazar.nutsandfruit.item.ItemFuel;
import com.lothrazar.nutsandfruit.item.ItemLingon;
import com.lothrazar.nutsandfruit.item.ItemPlain;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
  public static final ItemGroup GRP = new ItemGroup(NutsAndFruitMod.MODID) {

    @Override
    public ItemStack createIcon() {
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
    r.register(new ItemPlain(new Item.Properties().group(GRP).food(Foods.GOLDEN_CARROT)).setRegistryName("fruit_mix"));
    r.register(new ItemPlain(new Item.Properties().group(GRP).food(Foods.SWEET_BERRIES)).setRegistryName("lime"));
    r.register(new ItemLingon(new Item.Properties().group(GRP).food(Foods.MELON_SLICE)).setRegistryName("lingonberry"));
    r.register(new ItemFuel(new Item.Properties().group(GRP)).setRegistryName("lingonberry_twig"));
    r.register(new ItemPlain(new Item.Properties().group(GRP).food(Foods.APPLE)).setRegistryName("pineapple"));
    r.register(new ItemPlain(new Item.Properties().group(GRP)).setRegistryName("chestnut"));
    r.register(new ItemPlain(new Item.Properties().group(GRP).food(Foods.COOKED_BEEF)).setRegistryName("chestnut_roasted"));
    r.register(new ItemFuel(new Item.Properties().group(GRP)).setRegistryName("conifer_cone"));
    r.register(new ItemPlain(new Item.Properties().group(GRP).food(Foods.GOLDEN_CARROT)).setRegistryName("trail_mix"));
  }
}
