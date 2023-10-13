package com.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;

public class FileTest01 {
  public static void main(String[] args) {
    File file = new File("file.txt");
    try {
      boolean isCreated = file.createNewFile();
      System.out.println("Created: " + isCreated);
      System.out.println("Path: "+file.getPath()); // para pegar o nome do arquivo ou pasta
      System.out.println("Path Absolute: "+file.getAbsolutePath()); // para saber o caminho absoluto
      System.out.println("Is directory: "+file.isDirectory()); // para saber se é um diretorio
      System.out.println("Is file: "+file.isFile()); // para saber se é um arquivo
      System.out.println("Is hidden: "+file.isHidden()); // para saber se o arquivo é oculto
      // para saber quando foi modificado, que retorna um long com a data desde 1970
      System.out.println("Last modified: "+ Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()));

      boolean exists = file.exists();
      if(exists) {
        System.out.println("Deleted: " + file.delete());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
