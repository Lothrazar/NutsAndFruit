package com.lothrazar.nutsandfruit.registry;

import com.google.gson.JsonObject;
import com.lothrazar.nutsandfruit.NutsAndFruitMod;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class LootTableMod extends LootModifier {

  private Item item = null;
  private float percent;

  public LootTableMod(ILootCondition[] conditionsIn, Item replacement, float pct) {
    super(conditionsIn);
    item = replacement;
    pct = Math.min(pct, 100);//stop at 100 if i am larger than 100
    if (pct <= 0) {
      this.percent = 0;
    }
    else {
      this.percent = pct / 100.0F;
    }
  }

  @Override
  public List<ItemStack> doApply(List<ItemStack> originalLoot, LootContext context) {
    if (context.has(LootParameters.BLOCK_STATE) && this.item != null) {
      //      BlockState stuff = context.get(LootParameters.BLOCK_STATE);
      if (context.getWorld().rand.nextDouble() < this.percent) {
        originalLoot.add(new ItemStack(this.item));
        NutsAndFruitMod.LOGGER.info(this.percent + " Block state !!! " + new ItemStack(this.item) + " for " + context.get(LootParameters.BLOCK_STATE));
      }
    }
    return originalLoot;
  }

  public static class Serializer extends GlobalLootModifierSerializer<LootTableMod> {

    @Override
    public LootTableMod read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
      Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(json, "replacement")));
      float pct = JSONUtils.getInt(json, "percent");
      return new LootTableMod(conditionsIn, replacement, pct);
    }

    @Override
    public JsonObject write(LootTableMod instance) {
      return null; //not sure what to do with this
    }
  }
}
