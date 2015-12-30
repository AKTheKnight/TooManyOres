package com.aktheknight.toomanyores;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GetOres {
  public static void get() throws IOException {
    String[] OreDict = OreDictionary.getOreNames();
    ArrayList<ItemStack> Ores = new ArrayList<ItemStack>();
    for (String Ore : OreDict) {
      if (Ore.substring(0, 3).equals("ore")) {
        OreFile.write(Ore);
        Ores = OreDictionary.getOres(Ore);
        for (ItemStack Items : Ores) {
          String Item = Items.getUnlocalizedName();
          OreFile.write("\t" + Item);
          Item = Items.getDisplayName();
          OreFile.write("\t\t" + Item);
        }
      }
    }
  }
}
