package com.aktheknight.toomanyores.ores;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GetOres {
	
	static String[] OreDict;
	static ArrayList<ItemStack> Ores;
	
	public static void get(Boolean singleOres) throws IOException {
		if (singleOres == true) {
			getAll();
		}
		else {
			ignoreSingles();
		}
	}
	
	static void ignoreSingles() throws IOException {
		OreDict = OreDictionary.getOreNames();
		Ores = new ArrayList<ItemStack>();
		for (String Ore : OreDict) {
			if (Ore.substring(0, 3).equals("ore")) {
				Ores = OreDictionary.getOres(Ore);
				if (Ores.size() != 1 && Ores.size() != 0) {
					write(Ore);
				}
			}
		}
	}
	
	static void getAll() throws IOException {
		OreDict = OreDictionary.getOreNames();
		Ores = new ArrayList<ItemStack>();
		for (String Ore : OreDict) {
			if (Ore.substring(0, 3).equals("ore")) {
				write(Ore);
			}
		}
	}
	
	static void write(String Ore) throws IOException {
		Ores = OreDictionary.getOres(Ore);
		OreFile.write(Ore);
		for (ItemStack Items : Ores) {
			String Item = Items.getUnlocalizedName();
			OreFile.write("\t" + Item);
			Item = Items.getDisplayName();
			OreFile.write("\t\t" + Item);
		}
	}
 }
