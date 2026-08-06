package com.lothrazar.nutsandfruit.registry;

import java.util.function.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class LeavesLootModifier extends LootModifier {

  private static final RandomSource rand = RandomSource.create();
  public static final Supplier<MapCodec<LeavesLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst).and(inst.group(
      Codec.INT.fieldOf("percent").forGetter(m -> m.percent),
      BuiltInRegistries.ITEM.byNameCodec().fieldOf("replacement").forGetter(m -> m.replacement),
      BuiltInRegistries.ITEM.byNameCodec().fieldOf("fruit").forGetter(m -> m.fruit)))
      .apply(inst, LeavesLootModifier::new)));
  private int percent;
  private final Item replacement;
  private final Item fruit;

  public LeavesLootModifier(LootItemCondition[] conditionsIn, int priority, int percent, Item reward, Item fruit) {
    super(conditionsIn, priority);
    this.replacement = reward;
    this.fruit = fruit;
    this.percent = Math.min(percent, 100);
    if (this.percent <= 0) {
      this.percent = 0;
    }
  }

  @Override
  public MapCodec<? extends IGlobalLootModifier> codec() {
    return CODEC.get();
  }

  @Override
  protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
    //for example: IF a stick is present, then remove that stick
    //then regardless of that stick being around or not, roll and add fruit
    generatedLoot.removeIf(x -> x.is(replacement));
    ObjectArrayList<ItemStack> ret = new ObjectArrayList<ItemStack>();
    if (fruit != null && rand.nextInt(100) < percent) {
      ret.add(new ItemStack(fruit));
    }
    return ret;
  }
}
