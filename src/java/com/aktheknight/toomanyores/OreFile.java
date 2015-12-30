package com.aktheknight.toomanyores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OreFile {
  static File outputDir;
  static FileWriter writer;
  
  public static void setup(File configFile) throws IOException {
    outputDir = new File(configFile.getParentFile() + "/toomanyores");
    outputDir.mkdirs();
    writer = new FileWriter(outputDir + "/ores.txt");
    }
  
  public static void write(String msg) throws IOException {
    writer.write(msg);
    writer.write("\n");
    writer.flush();
  }
  
  public static void close() throws IOException {
    writer.flush();
    writer.close();
  }
}
