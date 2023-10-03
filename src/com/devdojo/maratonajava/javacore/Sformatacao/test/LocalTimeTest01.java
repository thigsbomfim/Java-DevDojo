package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest01 {
  public static void main(String[] args) {
    // para criar apartir de uma hora específica, se usa o método of
    // se for criar apartir da data atual se usa o método now()
    // lembrando, o primeiro parametro que são as horas, vão de 0 a 23 e não 24
    LocalTime time = LocalTime.of(23, 32, 12);
    LocalTime timeNow = LocalTime.now();
    System.out.println(time);
    System.out.println(timeNow);

    System.out.println(time.getHour());
    System.out.println(time.getMinute());
    System.out.println(time.getSecond());
    // pega as horas que tem no dia -> 23
    System.out.println(time.get(ChronoField.HOUR_OF_DAY));
    // Pega o horario minimo: 00:00
    System.out.println(LocalTime.MIN);
    // pega o horario maximo 23:59:59.999999999
    System.out.println(LocalTime.MAX);
  }
}
