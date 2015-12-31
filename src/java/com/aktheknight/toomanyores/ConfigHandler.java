package com.aktheknight.toomanyores;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static Configuration config;

	public static void init(File configFile) {
		config = new Configuration(configFile);
		loadConfig();
	}
	    
	private static void loadConfig() {
		loadGeneralSettings();
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	private static void loadGeneralSettings() {
		TooManyOres.writeSingleOres = config.getBoolean("writeSingleOres", "General" , true, "Do you want the mod to print out ores even if only one type exists in the world?");
	}
}
