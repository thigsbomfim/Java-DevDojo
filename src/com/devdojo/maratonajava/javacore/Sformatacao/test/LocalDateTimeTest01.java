package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest01 {
  public static void main(String[] args) {
    // Data e hora atual do sistema operacional
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalDate date = LocalDate.parse("2024-10-02");
    LocalTime time = LocalTime.parse("14:54:00");
    System.out.println(localDateTime);
    System.out.println(date);
    System.out.println(time);

    // usando o LocalDateTime para criar data e hora, adicionando a variavel time no método atTime da variavel date
    LocalDateTime ldt1 = date.atTime(time);
    System.out.println(ldt1);

    // usando o LocalDateTime para criar data e hora, adicionando a variavel date no método atDate da variavel time
    LocalDateTime ldt2 = time.atDate(date);
    System.out.println(ldt2);


  }
}
