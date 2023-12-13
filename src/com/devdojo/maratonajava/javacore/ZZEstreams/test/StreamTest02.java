package com.devdojo.maratonajava.javacore.ZZEstreams.test;


import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {
  private static List<LightNovel> lightNovels = new ArrayList<>(
          List.of(
          new LightNovel("Tensei Shittara", 8.99),
          new LightNovel("Overlord", 3.99),
          new LightNovel("Violet Evergarden", 5.99),
          new LightNovel("No Game no life", 2.99),
          new LightNovel("Fullmetal Alchemist", 5.99),
          new LightNovel("Kumo desuga", 1.99),
          new LightNovel("Monogatari", 4.00)
          )
  );

  public static void main(String[] args) {
    // a maioria das coleções, contém um método chamado stream, e podemos ver que o retorno dele, é de um Stream
    // Stream<LightNovel>, significa que agora eu vou trabalhar com essa sequencia de elementos
    // e o que faremos nessa sequencia de elementos?
    // temos varias operações nas operações de uma stream, onde temos duas ações:
    // ou elas são intermediarias ou são finais
    // uma ação intermediária retorna um próprio stream, onde podemos filtrar, ordenar, limitar, tudo isso irá retornar
    // um outro stream, podemos ir encadeando

    List<String> titles = lightNovels.stream()
            // podemos ver que esse método abaixo retorna outro Stream<LightNovel>
            // esse método serve para ordenar
            .sorted(Comparator.comparing(LightNovel::getTitle))
            // acima, a sintaxe retorna um Stream<LightNovel>
            // agora queremos filtrar os que tem o preço <= 4
            .filter(lm -> lm.getPrice() <= 4)
            // acima, a sintaxe retorna um Stream<LightNovel> novamente
            // aqui estamos limitando o numero de resultados a 3
            .limit(3)
            // acima, a sintaxe retorna um Stream<LightNovel> novamente
            // aq estamos usando o método map para fazer o mapeamento, onde ele aceita uma Function(Interface Funcional)
            // podemos utilizar a sintaxe Method Reference
            .map(LightNovel::getTitle)
            // seria a mesma coisa que esse abaixo
//            .map(lm -> lm.getTitle());
            // acima, a sintaxe retorna um Stream<LightNovel> novamente
            // agora precisamos de um final, operação que vai fechar o stream e vai retornar uma coleção, uma dessas
            // operações finais que temos é coletar.
            // agora que temos uma sequencia de dados eu quero que você agrupe, tire do tempo e mova pro espaço
            // o collect retorna um "R e não uma "Stream" e dentro dele diremos como queremos retornar
            // temos o método toList da classe Collectors, onde ele irá retornar uma List de String
            .collect(Collectors.toList());



    // sintaxe simplificada abaixo sem explicações:
    List<String> titles2 = lightNovels.stream()
            .sorted(Comparator.comparing(LightNovel::getTitle))
            .filter(lm -> lm.getPrice() <= 4)
            .limit(3)
            .map(LightNovel::getTitle)
            .collect(Collectors.toList());

    System.out.println(titles2);
  }
}
