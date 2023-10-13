package com.devdojo.maratonajava.javacore.Tresoursebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourseBundleTest01 {
  public static void main(String[] args) {
    // O objeto ResourceBundle é utilizado para buscar recursos (como strings) em diferentes idiomas e regiões.
    // Neste exemplo, estamos configurando o ResourceBundle para buscar recursos do arquivo "messages"
    // no idioma e região "pt_BR" (português do Brasil).
    // Em seguida, estamos recuperando duas strings, "hello" e "good.morning", do arquivo de recursos.
    System.out.println(Locale.getDefault());
    ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
    String hello = bundle.getString("hello");
    String goodMorning = bundle.getString("good.morning");
    System.out.println(hello);
    System.out.println(goodMorning);

    // é sempre importante se atentar ao fallback que está sendo passado no getBundle, ele precisa existir
    // caso não exista o arquivo "messages_pt_BR.properties", ele irá buscar da seguinte forma:
    /*
     * vamos supor que estamos usando o local do en_US:
     * messages_en_US.properties -> caso não exista, vai buscar o proximo da seguinte forma
     * messages_en.properties -> caso ainda não exista, vai buscar o proximo da seguinte forma
     * ESTA FORMA ABAIXO É QUANDO COMEÇA A BUSCAR NA LINGUAGEM DO SEU SISTEMA OPERACIONAL
     * messages_pt_BR.properties -> caso ainda não exista, vai buscar o proximo da seguinte forma
     * messages_pt.properties -> caso ainda não exista, vai buscar o proximo da seguinte forma
     * messages.properties -> caso ainda não exista nenhum arquivo, irá lançar uma exceção
     * */
    ResourceBundle bundle2 = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
    String hello1 = bundle2.getString("hello");
    String goodMorning1 = bundle2.getString("good.morning");
    System.out.println(hello1);
    System.out.println(goodMorning1);

  }
}
