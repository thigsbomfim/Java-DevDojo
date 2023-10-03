package com.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZoneTest01 {
  public static void main(String[] args) {
    // para ver as zonas, que o java oferece suporte
    Map<String, String> shortIds = ZoneId.SHORT_IDS;
    System.out.println(shortIds);
    // retorna a zona em que o sistema operacional se encontra
    System.out.println(ZoneId.systemDefault());

    // para buscar outra zona
    ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
    System.out.println(tokyoZone);

    // o localDateTime não trás nenhum tipo de zona, mas é possivel pegar o horario passando a zona
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    // para passar o tipo de zona no LocalDateTime
    ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
    System.out.println(zonedDateTime);

    // também podemos usar o Instant, pois o instant trabalha com o zulu time
    Instant nowInstant = Instant.now();
    System.out.println(nowInstant);
    ZonedDateTime zonedDateTime2 = nowInstant.atZone(tokyoZone);
    System.out.println(zonedDateTime2); // ele ja adiciona o horario automaticamente

    // quando queremos usar o horario mas não sabemos a zona, temos uma classe especial zoneOffSet
    // onde temos o valor minimo, o minimo que podemos adicionar é -> -18:00
    // onde temos o valor máximo, o máximo que podemos adicionar é -> +18:00
    System.out.println(ZoneOffset.MIN);
    System.out.println(ZoneOffset.MAX);

    // para setar um horario a partir do valor maximo ou minimo que estou passando, para somar ou substrair o horario
    // a sintaxe do argumento tem que ser exatamente nesse formato, "-00:00" ou "+00:00"
    ZoneOffset offsetManaus = ZoneOffset.of("-04:00");

    // usando o LocalDateTime para adicionar uma nova zona a partir de um valor criado acima
    // utilizando dessa forma, não mostra a zona
    OffsetDateTime offsetDateTime = now.atOffset(offsetManaus);
    System.out.println(offsetDateTime);

    // podemos também utilizar OffsetDateTime, onde no primeiro argumento se passa o horario atual, e o segundo a zona
    OffsetDateTime offsetDateTime2 = OffsetDateTime.of(now, offsetManaus);
    System.out.println(offsetDateTime2);
    
    // também podemos utilizar com a classe Instant
    OffsetDateTime offsetDateTime3 = nowInstant.atOffset(offsetManaus);
    System.out.println(offsetDateTime3); // esse trás o mesmo horario que está no calendario de manaus

    // também podemos trabalhar com os proprios calendarios, onde pegamos diretamente de um localdate
    // mostra a era que estão no japão
    JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
    System.out.println(japaneseDate); // estão na era Reiwa

    // Se utilizarmos o LocalDate com uma data diferente
    LocalDate meijiEraLocalDate = LocalDate.of(1900, 2, 1);
    JapaneseDate meijiEra = JapaneseDate.from(meijiEraLocalDate); // p saber a era q teve em 1900 japao
    System.out.println(meijiEra);

  }
}
