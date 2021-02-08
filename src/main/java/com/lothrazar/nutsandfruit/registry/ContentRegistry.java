package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.nutsandfruit.ItemNut;
import com.lothrazar.nutsandfruit.LootTableMod;
import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.util.SoundEvent;
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
  public static final ItemGroup GRP = new ItemGroup(ModCyclic.MODID) {

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
    r.register(new ItemNut(new Item.Properties().group(GRP).food(Foods.ENCHANTED_GOLDEN_APPLE)).setRegistryName("fruit_salad"));
    r.register(new ItemNut(new Item.Properties().group(GRP).food(Foods.SWEET_BERRIES)).setRegistryName("lime"));
    r.register(new ItemNut(new Item.Properties().group(GRP).food(Foods.SWEET_BERRIES)).setRegistryName("lingonberry"));
    r.register(new ItemNut(new Item.Properties().group(GRP)).setRegistryName("lingonberry_twig"));
    r.register(new ItemNut(new Item.Properties().group(GRP).food(Foods.SWEET_BERRIES)).setRegistryName("pineapple"));
    r.register(new ItemNut(new Item.Properties().group(GRP)).setRegistryName("chestnut"));
    r.register(new ItemNut(new Item.Properties().group(GRP)).setRegistryName("sprucecone"));
    r.register(new ItemNut(new Item.Properties().group(GRP).food(Foods.BAKED_POTATO)).setRegistryName("chestnut_roasted"));
    //    r.register(new ItemNut(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BAKED_POTATO)).setRegistryName("sprucecone_roasted"));
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
