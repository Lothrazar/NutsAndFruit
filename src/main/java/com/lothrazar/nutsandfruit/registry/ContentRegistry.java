package com.lothrazar.nutsandfruit.registry;

import com.lothrazar.library.item.ItemFlib;
import com.lothrazar.library.registry.RecipeCompostFactory;
import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import com.lothrazar.nutsandfruit.item.ItemFuel;
import com.lothrazar.nutsandfruit.item.ItemLingon;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = NutsAndFruitMod.MODID)
public class ContentRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, NutsAndFruitMod.MODID);
  public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
      DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, NutsAndFruitMod.MODID);

  private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
      Identifier.fromNamespaceAndPath(NutsAndFruitMod.MODID, "tab"));

  public static final DeferredHolder<Item, Item> FRUIT_MIX = ITEMS.register("fruit_mix", () -> new ItemFlib(new Item.Properties().food(Foods.GOLDEN_CARROT)));
  public static final DeferredHolder<Item, Item> LIME = ITEMS.register("lime", () -> new ItemLingon(new Item.Properties().food(Foods.SWEET_BERRIES)));
  public static final DeferredHolder<Item, Item> LINGONBERRY = ITEMS.register("lingonberry", () -> new ItemLingon(new Item.Properties().food(Foods.MELON_SLICE)));
  public static final DeferredHolder<Item, Item> LINGONBERRY_TWIG = ITEMS.register("lingonberry_twig", () -> new ItemFuel(new Item.Properties()));
  public static final DeferredHolder<Item, Item> PINEAPPLE = ITEMS.register("pineapple", () -> new ItemFlib(new Item.Properties().food(Foods.APPLE)));
  public static final DeferredHolder<Item, Item> CHESTNUT = ITEMS.register("chestnut", () -> new ItemFlib(new Item.Properties()));
  public static final DeferredHolder<Item, Item> CHESTNUT_ROASTED = ITEMS.register("chestnut_roasted", () -> new ItemFlib(new Item.Properties().food(Foods.COOKED_BEEF)));
  public static final DeferredHolder<Item, Item> CONIFER_CONE = ITEMS.register("conifer_cone", () -> new ItemFuel(new Item.Properties()));
  public static final DeferredHolder<Item, Item> TRAIL_MIX = ITEMS.register("trail_mix", () -> new ItemFlib(new Item.Properties().food(Foods.GOLDEN_CARROT)));

  @SuppressWarnings("unused")
  public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<LeavesLootModifier>> LEAVES_MODIFIER =
      LOOT_MODIFIER_SERIALIZERS.register("loot", LeavesLootModifier.CODEC);

  @SubscribeEvent
  public static void onCreativeModeTabRegister(RegisterEvent event) {
    event.register(Registries.CREATIVE_MODE_TAB, helper -> {
      helper.register(TAB, CreativeModeTab.builder().icon(() -> new ItemStack(CHESTNUT.get()))
          .title(Component.translatable("itemGroup." + NutsAndFruitMod.MODID))
          .displayItems((enabledFlags, populator) -> {
            for (DeferredHolder<Item, ? extends Item> entry : ITEMS.getEntries()) {
              populator.accept(entry.get());
            }
          }).build());
    });
  }

  public static void registerCompostables() {
    RecipeCompostFactory.put(LIME.get(), RecipeCompostFactory.FillValues.FLOWER);
    RecipeCompostFactory.put(LINGONBERRY.get(), RecipeCompostFactory.FillValues.FLOWER);
    RecipeCompostFactory.put(LINGONBERRY_TWIG.get(), RecipeCompostFactory.FillValues.LEAVES);
    RecipeCompostFactory.put(PINEAPPLE.get(), RecipeCompostFactory.FillValues.FLOWER);
    RecipeCompostFactory.put(CHESTNUT.get(), RecipeCompostFactory.FillValues.LEAVES);
    RecipeCompostFactory.put(CONIFER_CONE.get(), RecipeCompostFactory.FillValues.FLOWER);
  }
}
