package com.aktheknight.toomanyores;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid="TooManyOres", name="Too Many Ores", version="1.7.10-1.0.2")

public class TooManyOres {
  public static final String MODID = "TooManyOres";
  public static final String MODNAME = "Too Many Ores";
  public static final String VERSION = "1.7.10-1.0.2";
  
  @Mod.Instance
  public static TooManyOres instance;
  public static Logger LOGGER = LogManager.getLogger("TooManyOres");
  
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
	  LOGGER.log(Level.INFO, "Setting up ores file");
	  File configFile = event.getModConfigurationDirectory();
	  try
	  {
		  OreFile.setup(configFile);
	  }
	  catch (IOException io)
	  {
		  LOGGER.log(Level.ERROR, "Error while creating file. Report to AKTheKnight for help");
		  LOGGER.log(Level.ERROR, io.toString());
		  return;
	  }
	  LOGGER.log(Level.INFO, "File setup done");
  }
  
  @Mod.EventHandler
  public void loadComplete(FMLLoadCompleteEvent e) {
	  LOGGER.log(Level.INFO, "Starting Too Many Ores");
	  try
	  {
		  LOGGER.log(Level.INFO, "Getting OreDict info");
		  GetOres.get();
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
