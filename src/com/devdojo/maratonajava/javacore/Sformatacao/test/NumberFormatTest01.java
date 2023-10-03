package com.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest01 {
  // Formas de usar numeros em cada país

  public static void main(String[] args) {
    Locale localeBR = new Locale("pt", "BR");
    Locale localeJP = Locale.JAPAN;
    Locale localeIT = Locale.ITALY;

    NumberFormat[] nfa = new NumberFormat[4];
    nfa[0] = NumberFormat.getInstance();
    nfa[1] = NumberFormat.getInstance(localeJP);
    nfa[2] = NumberFormat.getInstance(localeBR);
    nfa[3] = NumberFormat.getInstance(localeIT);

    double valor = 1_000.2130;
    for (NumberFormat numberFormat : nfa) {
      // para dizer quantos digitos tem nos numeros
      // System.out.println(numberFormat.getMaximumFractionDigits()); // todos contém 3 digitos - 213

      // para setar quantos digitos eu quero:
      // numberFormat.setMaximumFractionDigits(2); // agora contém 2 digitos

      System.out.println(numberFormat.format(valor));
    }

    String valorString = "1000.2130";
    try {
      // se houver um valor inválido ao realizar o parse, irá retornar apenas o numero antes do parse
      // vamos supor que o numero do valorString esteja assim "a1_000.2130", dessa forma irá dar uma exceção
      // agora o se o valor continuar do jeito que está "1_000.2130", irá retornar apenas o primeiro numero
      // pois o "_" é um valor inválido para ser transformado em numero
      System.out.println(nfa[0].parse(valorString));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

  }
}
