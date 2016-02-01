package com.aktheknight.toomanyores.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.aktheknight.toomanyores.TooManyOres;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static Configuration config;
	static String category;
	static Boolean defaultValue;
	static String oresArray[] = new String[]{"RegularVanillaGen", "RegularVanillaOres", "Dirt", "Gravel", "Coal", "Iron", "Gold", "Diamond", "Lapis", "Redstone", "NetherQuartz"};
	@SuppressWarnings("unchecked")
	static List<String> oresList = new ArrayList<String>(Arrays.asList(oresArray));
	
	public static void init(File configFile) {
		config = new Configuration(configFile);
		loadConfig();
		
	}
	    
	private static void loadConfig() {
		loadWriteSettings();
		loadOreSettings();
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	private static void loadWriteSettings() {
		category = "File";
		TooManyOres.writeSingleOres = config.getBoolean("writeSingleOres", "File" , true, "Do you want the mod to print out ores even if only one type exists in the world?");
	}
	
	private static void loadOreSettings() {
		config.setCategoryPropertyOrder("Ore Generation" , oresList);
		category = "Ore Generation";
		defaultValue = false;
		TooManyOres.VanillaGen 	= config.getBoolean("RegularVanillaGen", category, defaultValue, "Disable \"all\" vanilla generation. (Dirt and Gravel in stone)");
		TooManyOres.VanillaOres = config.getBoolean("RegularVanillaOres", category, defaultValue, "Disable \"all\" vanilla ore generation. (Also Nether Quartz)");
		TooManyOres.Dirt 		= config.getBoolean("Dirt", category, defaultValue, "Disable dirt generating in stone");
		TooManyOres.Gravel 		= config.getBoolean("Gravel", category, defaultValue, "Disable gravel generating in stone");
		TooManyOres.Coal		= config.getBoolean("Coal", category, defaultValue, "Disable coal ore generating");
		TooManyOres.Iron		= config.getBoolean("Iron", category, defaultValue, "Disable iron ore generating");
		TooManyOres.Gold		= config.getBoolean("Gold", category, defaultValue, "Disable gold ore generating");
		TooManyOres.Diamond		= config.getBoolean("Diamond", category, defaultValue, "Disable diamond ore generating");
		TooManyOres.Lapis		= config.getBoolean("Lapis", category, defaultValue, "Disable lapis ore generating");
		TooManyOres.Redstone	= config.getBoolean("Redstone", category, defaultValue, "Disable redstone ore generating");
		TooManyOres.Quartz		= config.getBoolean("NetherQuartz", category, defaultValue, "Disable nether quartz or generating");
	}
}
