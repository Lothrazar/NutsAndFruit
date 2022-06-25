package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import com.lothrazar.nutsandfruit.item.ItemFuel;
import com.lothrazar.nutsandfruit.item.ItemLingon;
import com.lothrazar.nutsandfruit.item.ItemPlain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContentRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NutsAndFruitMod.MODID);
  public static final CreativeModeTab GRP = new CreativeModeTab(NutsAndFruitMod.MODID) {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(ContentRegistry.CHESTNUT.get());
    }
  };
  public static final RegistryObject<Item> FRUIT_MIX = ITEMS.register("fruit_mix", () -> new ItemPlain(new Item.Properties().tab(GRP).food(Foods.GOLDEN_CARROT)));
  public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new ItemLingon(new Item.Properties().tab(GRP).food(Foods.SWEET_BERRIES)));
  public static final RegistryObject<Item> LINGONBERRY = ITEMS.register("lingonberry", () -> new ItemLingon(new Item.Properties().tab(GRP).food(Foods.MELON_SLICE)));
  public static final RegistryObject<Item> LINGONBERRY_TWIG = ITEMS.register("lingonberry_twig", () -> new ItemFuel(new Item.Properties().tab(GRP)));
  public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new ItemPlain(new Item.Properties().tab(GRP).food(Foods.APPLE)));
  public static final RegistryObject<Item> CHESTNUT = ITEMS.register("chestnut", () -> new ItemPlain(new Item.Properties().tab(GRP)));
  public static final RegistryObject<Item> CHESTNUT_ROASTED = ITEMS.register("chestnut_roasted", () -> new ItemPlain(new Item.Properties().tab(GRP).food(Foods.COOKED_BEEF)));
  public static final RegistryObject<Item> CONIFER_CONE = ITEMS.register("conifer_cone", () -> new ItemFuel(new Item.Properties().tab(GRP)));
  public static final RegistryObject<Item> TRAIL_MIX = ITEMS.register("trail_mix", () -> new ItemPlain(new Item.Properties().tab(GRP).food(Foods.GOLDEN_CARROT)));

  @SubscribeEvent
  public static void onBlocksRegistry(RegisterEvent event) {
    event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, r -> {
      r.register(new ResourceLocation(NutsAndFruitMod.MODID + ":loot"), new LootTableMod.Serializer());
    });
  }
  //
  //  @SubscribeEvent
  //  public static void registerModifierSerializers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
  //    event.getRegistry().register(new LootTableMod.Serializer().setRegistryName(NutsAndFruitMod.MODID + ":loot"));
  //  }
}
