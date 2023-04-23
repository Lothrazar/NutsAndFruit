package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.library.item.ItemFlib;
import com.lothrazar.library.registry.RegistryFactory;
import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import com.lothrazar.nutsandfruit.item.ItemFuel;
import com.lothrazar.nutsandfruit.item.ItemLingon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContentRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NutsAndFruitMod.MODID);

  @SubscribeEvent
  public static void buildContents(CreativeModeTabEvent.Register event) {
    RegistryFactory.buildTab(event, NutsAndFruitMod.MODID, CHESTNUT.get().asItem(), ITEMS);
  }

  public static final RegistryObject<Item> FRUIT_MIX = ITEMS.register("fruit_mix", () -> new ItemFlib(new Item.Properties().food(Foods.GOLDEN_CARROT)));
  public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new ItemLingon(new Item.Properties().food(Foods.SWEET_BERRIES)));
  public static final RegistryObject<Item> LINGONBERRY = ITEMS.register("lingonberry", () -> new ItemLingon(new Item.Properties().food(Foods.MELON_SLICE)));
  public static final RegistryObject<Item> LINGONBERRY_TWIG = ITEMS.register("lingonberry_twig", () -> new ItemFuel(new Item.Properties()));
  public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new ItemFlib(new Item.Properties().food(Foods.APPLE)));
  public static final RegistryObject<Item> CHESTNUT = ITEMS.register("chestnut", () -> new ItemFlib(new Item.Properties()));
  public static final RegistryObject<Item> CHESTNUT_ROASTED = ITEMS.register("chestnut_roasted", () -> new ItemFlib(new Item.Properties().food(Foods.COOKED_BEEF)));
  public static final RegistryObject<Item> CONIFER_CONE = ITEMS.register("conifer_cone", () -> new ItemFuel(new Item.Properties()));
  public static final RegistryObject<Item> TRAIL_MIX = ITEMS.register("trail_mix", () -> new ItemFlib(new Item.Properties().food(Foods.GOLDEN_CARROT)));

  @SubscribeEvent
  public static void onBlocksRegistry(RegisterEvent event) {
    event.register(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, r -> {
      r.register(new ResourceLocation(NutsAndFruitMod.MODID, "loot"), LeavesLootModifier.CODEC.get());
    });
  }
}
