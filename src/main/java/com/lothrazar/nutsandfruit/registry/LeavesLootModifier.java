package com.lothrazar.nutsandfruit.registry;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class LeavesLootModifier extends LootModifier {

  private static final RandomSource rand = RandomSource.create();
  public static final Supplier<Codec<LeavesLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
      inst.group(
          Codec.INT.fieldOf("percent").forGetter(m -> m.percent),
          ForgeRegistries.ITEMS.getCodec().fieldOf("replacement").forGetter(m -> m.replacement),
          ForgeRegistries.ITEMS.getCodec().fieldOf("fruit").forGetter(m -> m.fruit)))
      .apply(inst, LeavesLootModifier::new)));
  private int percent;
  private final Item replacement;
  private final Item fruit;

  public LeavesLootModifier(LootItemCondition[] conditionsIn, int percent, Item reward, Item fruit) {
    super(conditionsIn);
    this.replacement = reward;
    this.fruit = fruit;
    this.percent = Math.min(percent, 100); //stop at 100 if i am larger than 100
    if (this.percent <= 0) {
      this.percent = 0;
    }
  }

  @Override
  public Codec<? extends IGlobalLootModifier> codec() {
    return CODEC.get();
  }

  @Override
  protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
    //for example: IF a stick is present, then remove that stick
    //then regardless of that stick being around or not, roll and add fruit
    generatedLoot.removeIf(x -> x.getItem() == replacement);
    ObjectArrayList<ItemStack> ret = new ObjectArrayList<ItemStack>();
    if (rand.nextFloat() < percent) {
      ret.add(new ItemStack(fruit));
    }
    return ret;
  }
}
