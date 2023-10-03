package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocalTest01 {
  public static void main(String[] args) {
    // pt-BR
    // duas ISOS que são representadas, que são: ISO 639 e ISO 3166
    // 1° argumento é a linguagem, segundo argumento é o pais
    Locale localeItaly = new Locale("it", "IT");
    Locale localeSuica = new Locale("it", "CH");
    Locale localeIndia = new Locale("hi", "IN");
    Locale localeJapao = new Locale("ja", "JP");
    Locale localeHolanda = new Locale("nl", "NL");

    Calendar calendar = Calendar.getInstance();
    DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
    DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeSuica);
    DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
    DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeJapao);
    DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localeHolanda);

    System.out.println("Italia " + df1.format(calendar.getTime()));
    System.out.println("Suiça " + df2.format(calendar.getTime()));
    System.out.println("India  " + df3.format(calendar.getTime()));
    System.out.println("Japao " + df4.format(calendar.getTime()));
    System.out.println("Holanda " + df5.format(calendar.getTime()));

    // Diz o país que está sendo usado de acordo com a linguagem do sistema operacional
    System.out.println(localeItaly.getDisplayCountry()); // Itália
    System.out.println(localeSuica.getDisplayCountry()); // Suíça

    // Para pegar o país traduzido na linguagem que quisermos, basta passar como argumento da função o locale do pais
    // que queremos que fique nessa linguagem
    System.out.println(localeItaly.getDisplayCountry(localeJapao)); // イタリア
    System.out.println(localeSuica.getDisplayCountry(localeJapao)); // スイス
  }
}
