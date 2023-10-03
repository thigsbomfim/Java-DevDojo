package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
  public static void main(String[] args) {
    LocalDateTime aniversario = LocalDateTime.of(1998, Month.MARCH, 2, 12, 0, 0);
    LocalDateTime aniversario1 = LocalDateTime.of(2000, Month.OCTOBER, 4, 12, 0, 0);
    LocalDateTime now = LocalDateTime.now();

    System.out.println("Thiago");
    System.out.println(ChronoUnit.DAYS.between(aniversario, now) + " Dias"); // idade em dias
    System.out.println(ChronoUnit.MONTHS.between(aniversario, now) + " Meses"); // idade em meses
    System.out.println(ChronoUnit.WEEKS.between(aniversario, now) + " Semanas"); // idade em semanas
    System.out.println(ChronoUnit.YEARS.between(aniversario, now) + " Anos"); // idade em anos
    System.out.println("-------------------------------");
    System.out.println("Rian");
    System.out.println(ChronoUnit.DAYS.between(aniversario1, now) + " Dias"); // idade em dias
    System.out.println(ChronoUnit.MONTHS.between(aniversario1, now) + " Meses"); // idade em meses
    System.out.println(ChronoUnit.WEEKS.between(aniversario1, now) + " Semanas"); // idade em semanas
    System.out.println(ChronoUnit.YEARS.between(aniversario1, now) + " Anos"); // idade em anos
  }
}
