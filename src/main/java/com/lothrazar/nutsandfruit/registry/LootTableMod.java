package com.lothrazar.nutsandfruit.registry;

import com.google.gson.JsonObject;
import java.util.List;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class LootTableMod extends LootModifier {

  private Item item = null;
  private float percent;

  public LootTableMod(LootItemCondition[] conditionsIn, Item replacement, float pct) {
    super(conditionsIn);
    item = replacement;
    pct = Math.min(pct, 100); //stop at 100 if i am larger than 100
    if (pct <= 0) {
      this.percent = 0;
    }
    else {
      this.percent = pct / 100.0F;
    }
  }

  @Override
  public List<ItemStack> doApply(List<ItemStack> originalLoot, LootContext context) {
    if (context.hasParam(LootContextParams.BLOCK_STATE) && this.item != null) {
      if (context.getLevel().random.nextDouble() < this.percent) {
        originalLoot.add(new ItemStack(this.item));
        // NutsAndFruitMod.LOGGER.info(this.percent + " Block state !!! " + new ItemStack(this.item) + " for " + context.get(LootParameters.BLOCK_STATE));
      }
    }
    return originalLoot;
  }

  public static class Serializer extends GlobalLootModifierSerializer<LootTableMod> {

    @Override
    public LootTableMod read(ResourceLocation name, JsonObject json, LootItemCondition[] conditionsIn) {
      Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(json, "replacement")));
      float pct = GsonHelper.getAsInt(json, "percent");
      return new LootTableMod(conditionsIn, replacement, pct);
    }

    @Override
    public JsonObject write(LootTableMod instance) {
      return null; //not sure what to do with this
    }
  }
}
