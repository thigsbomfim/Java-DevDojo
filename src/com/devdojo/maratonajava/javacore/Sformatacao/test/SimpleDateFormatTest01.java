package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
  public static void main(String[] args) {
    String pattern = "'Amsterdam' dd 'de' MMMM 'de' yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    System.out.println(sdf.format(new Date()));

    try {
      // realizando o parse de datas, é preciso que esteja com o mesmo formato da string pattern para realizar o parse
      System.out.println(sdf.parse("Amsterdam 01 de outubro de 2023"));
      // System.out.println(sdf.parse("01 de outubro de 2023")); // se estivesse assim, seria erro de compilação
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
