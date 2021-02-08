package com.lothrazar.nutsandfruit;

import com.google.gson.JsonObject;
import java.util.List;
import net.minecraft.block.BlockState;
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

  Item item = null;

  public LootTableMod(ILootCondition[] conditionsIn, Item replacement) {
    super(conditionsIn);
    item = replacement;
  }

  @Override
  public List<ItemStack> doApply(List<ItemStack> originalLoot, LootContext context) {
    if (context.has(LootParameters.BLOCK_STATE) && this.item != null) {
      BlockState stuff = context.get(LootParameters.BLOCK_STATE);
      if (context.getWorld().rand.nextDouble() < 0.1) {
        originalLoot.add(new ItemStack(this.item));
        //        NutsAndFruitMod.LOGGER.info("Block state !!! " + new ItemStack(this.item));
      }
    }
    return originalLoot;
  }

  public static class Serializer extends GlobalLootModifierSerializer<LootTableMod> {

    @Override
    public LootTableMod read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
      Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(json, "replacement")));
      return new LootTableMod(conditionsIn, replacement);
    }

    @Override
    public JsonObject write(LootTableMod instance) {
      return null; //not sure what to do with this
    }
  }
}
