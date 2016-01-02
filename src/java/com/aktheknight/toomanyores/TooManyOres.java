package com.aktheknight.toomanyores;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aktheknight.toomanyores.config.ConfigHandler;
import com.aktheknight.toomanyores.ores.GetOres;
import com.aktheknight.toomanyores.ores.OreFile;
import com.aktheknight.toomanyores.ores.OreGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="TooManyOres", name="Too Many Ores", version="1.7.10-1.0.3")

public class TooManyOres {
  public static final String MODID = "TooManyOres";
  public static final String MODNAME = "Too Many Ores";
  public static final String VERSION = "1.7.10-1.0.3";
  
  @Mod.Instance
  public static TooManyOres instance;
  
  //Create logger
  public static Logger LOGGER = LogManager.getLogger(MODID);
  
  //Config options
  //Writing to file
  public static boolean writeSingleOres = true;
  //Ore Gen. True if disabling
  public static boolean VanillaGen = false;
  public static boolean VanillaOres = false;
  public static boolean Dirt = false;
  public static boolean Gravel = false;
  public static boolean Coal = false;
  public static boolean Iron = false;
  public static boolean Gold = false;
  public static boolean Diamond = false;
  public static boolean Lapis = false;
  public static boolean Redstone = false;
  public static boolean Quartz = false;
  
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
	  LOGGER.log(Level.INFO, "Loading/creating config file");
	  ConfigHandler.init(event.getSuggestedConfigurationFile());
	  LOGGER.log(Level.INFO, "Loading/creating config complete");
	  
	  LOGGER.log(Level.INFO, "Setting up ores file");
	  File configFolder = event.getModConfigurationDirectory();	  
	  try {
		  OreFile.setup(configFolder);
	  }
	  catch (IOException io) {
		  LOGGER.log(Level.ERROR, "Error while creating file. Report to AKTheKnight for help");
		  LOGGER.log(Level.ERROR, io.toString());
		  return;
	  }
	  LOGGER.log(Level.INFO, "File setup done");
	  
	  MinecraftForge.ORE_GEN_BUS.register(new OreGen());
  }
  
  @Mod.EventHandler
  public void loadComplete(FMLLoadCompleteEvent e) {
	  LOGGER.log(Level.INFO, "Starting Too Many Ores");
	  try {
		  LOGGER.log(Level.INFO, "Getting OreDict info");
		  GetOres.get(writeSingleOres);
	  }
	  catch (IOException io) {
		  LOGGER.log(Level.ERROR, "Error while writing to file. Report to AKTheKnight for help");
		  LOGGER.log(Level.ERROR, io.toString());
		  return;
	  }
	  try {
		  OreFile.close();
	  }
	  catch (IOException io) {
		  LOGGER.log(Level.ERROR, "Error while closing file. Report to AKTheKnight for help");
		  LOGGER.log(Level.ERROR, io.toString());
		  return;
	  }
	  LOGGER.log(Level.INFO, "Finished. Ores printed to /toomanyores/ores.txt");
  }
}
