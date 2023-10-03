package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.util.Locale;

public class LocaleTest02 {
  public static void main(String[] args) {
    // serve para saber como está configurado para o meu computador, nesse caso está pt_BR
    System.out.println(Locale.getDefault());

    // para saber todas as ISOS que são suportadas:
    String[] isoCountries = Locale.getISOCountries();
    String[] isoLanguages = Locale.getISOLanguages();

    for (String isoLanguage : isoLanguages) {
      System.out.print(isoLanguage + " ");
    }
    System.out.println();
    for (String isoCountry : isoCountries) {
      System.out.print(isoCountry + " ");
    }


  }
}
