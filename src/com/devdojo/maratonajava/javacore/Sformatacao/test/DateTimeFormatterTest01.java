package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

// sempre que vermos Formatter no nome da classe, quer dizer que estamos transformando Objeto em string
// Formatter/Format -> Transformando Objeto em String
// Sempre que vermos a palavra Parse no nome da classe, quer dizer que estamos transformando de uma String para seu obj
// Parse -> transformando String em Objeto
public class DateTimeFormatterTest01 {
  public static void main(String[] args) {
    // formatando Datas
    LocalDate date = LocalDate.now();
    String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);// formata para: 20231003
    String s2 = date.format(DateTimeFormatter.ISO_DATE);// formata para: 2023-10-03 ou se conter zona 2023-10-03+01:00
    String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);// formata para o padrão do LocalDate: 2023-10-03
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    // se quisermos transformar uma String em um objeto, devemos tomar cuidado, devemos escolher o formato certo
    // Exemplo: se dermos um parse na formatação do tipo BASIC_ISO_DATE, ele não irá formatar para data,
    // pois o formato não é apropriado para data
    // LocalDate parse1 = LocalDate.parse(s1);
    // System.out.println(parse1);

    // A não ser que executamos o parse dessa forma
    LocalDate parse2 = LocalDate.parse("20231003", DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println(parse2);

    // também podemos ver, que podemos utilizar a zona no tipo de formatação ISO_DATE
    // mesmo passando e funcionando, não vai ser possivel visualizar a zona
    LocalDate parse3 = LocalDate.parse("2023-10-03+05:00", DateTimeFormatter.ISO_DATE);
    System.out.println(parse3);

    // mas não podemos utilizar zona para o tipo de formatação ISO_LOCAL_DATE
    // erro de compilação: LocalDate parse4 = LocalDate.parse("2023-10-03+05:00", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate parse4 = LocalDate.parse("2023-10-03", DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println(parse4);

    // Também podemos utilizar o LocalDateTime
    LocalDateTime now = LocalDateTime.now();
    // ISO_DATE_TIME -> trás o valor caso tenha zona
    String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
    System.out.println(s4);

    LocalDateTime parse5 = LocalDateTime.parse("2023-10-03T20:17:07.256835400", DateTimeFormatter.ISO_DATE_TIME);
    System.out.println(parse5);

    // formatos de alguns países
    // dd/MM/yyyy -> Brasil
    // MM/dd/yyyy -> Estados unidos
    // yyyy/MM/dd -> Japão

    // para formatar uma data baseado no país
    DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");// Brasil
    String formatBR = LocalDate.now().format(formatterBR);
    System.out.println(formatBR);

    // para realizar o parse
    LocalDate parse6 = LocalDate.parse("03/10/2023", formatterBR);
    System.out.println(parse6);

    DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN); // Alemanha
    String formatGR = LocalDate.now().format(formatterGR); // Alemanha
    System.out.println(formatGR);

    LocalDate parse7 = LocalDate.parse("03.Oktober.2023", formatterGR);
    System.out.println(parse7);
  }
}
