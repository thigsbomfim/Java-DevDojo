package com.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Quando vermos Stream significa que geralmente estaremos trabalhando com dados baixo nivel, praticamente binário
public class ZipOutputStreamTest01 {
  public static void main(String[] args) {
    // arquivo que vai ser zipado
    Path arquivoZip = Paths.get("pasta/arquivo.zip");
    // para copiar os arquivos que queremos para jogar dentro do arquivo zip
    Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");
    //chamando o método
    zip(arquivoZip, arquivosParaZipar);
  }

  private static void zip(Path arquivoZip, Path arquivosParaZipar) {
    // Files.newOutputStream basicamente pega um path e vai transformar esse path em outputStream
    // estamos usando o DirectoryStream para navegar nessa pasta e pegar cada um desses arquivos, para colocar
    // no arquivo zip
    try(ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
      for (Path file : directoryStream) {
        // aqui estamos preparando uma entrada para o arquivo zip, preparando o objeto
        ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());

        // falando pro zipStream: olha, vou colocar esse cara daqui a pouco
        // aqui estamos criando o arquivo zip com os arquivos que estão sendo copiados, mas que estão sem conteúdo
        zipStream.putNextEntry(zipEntry);
        // aqui estamos copiando o conteúdo do arquivo e jogando no zipStream
        Files.copy(file, zipStream);

        // fechando o
        zipStream.closeEntry();
      }
      System.out.println("Arquivo criado com sucesso");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

}
