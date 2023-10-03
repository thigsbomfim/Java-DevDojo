package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationTest01 {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2).plusMinutes(8);
    LocalTime timeNow = LocalTime.now();
    LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);

    // Duration.between() serve p ver o tempo que teve entre os dois argumentos, nesse caso é agora e daqui 2 anos
    // P -> no resultado, p significa a parte do periodo, é utilizado quando vai trabalhar com as datas
    // T -> representa o tempo

    // duration não aceita localdate, pois localdate não contém segundos
    // Duration.between(LocalDate.now(), LocalDate.now().plusYears(2)); // erro de compilação: Unsupported unit: Seconds
    Duration d1 = Duration.between(now, nowAfterTwoYears); // PT17544H // LocalDateTime contém segundos
    Duration d2 = Duration.between(timeNow, timeMinus7Hours); // PT17544H // LocalTime contém segundos
    Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000)); // PT17544H // contém s
    Duration d4 = Duration.ofDays(2);
    Duration d5 = Duration.ofMinutes(4);

    // meio complicado de usar, estamos passando o
    Duration d6 = Duration.of(3, ChronoUnit.HOURS);

    System.out.println("d1: " + d1);
    System.out.println("d2: " + d2);
    System.out.println("d3: " + d3);
    System.out.println("d4: " + d4);
    System.out.println("d5: " + d5);
    System.out.println("d6: " + d6);


  }
}
