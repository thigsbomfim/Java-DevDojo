package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest01 {
  public static void main(String[] args) {
    // Map sempre trabalha com chave e valor
    // no momento da criação, teremos que dizer o tipo da chave e o tipo do valor
    // como temos hash no nome, ele vai ordenar as chaves baseado no hash, ou seja, não tem uma ordem específica, pode
    // mudar conforme nós formos inserindo
    // precisamos do equals e hashCode sobrescrito, pq temos regras no Map
    // 1º regra -> não podem ter chaves duplicadas
    // se quisermos manter a ordem de inserção, devemos utilizar o LinkedHashMap
//    Map<String, String> map = new LinkedHashMap<>();
    Map<String, String> map = new HashMap<>();
    // para adicionar valores no map, usamos o put
    // eles pedem 2 argumentos, o primeiro é a chave, e o segundo o valor
    map.put("teklado", "teclado");
    map.put("mouze", "mouse");
    map.put("vc", "você");
    // ao tentarmos colocar duas chaves iguais, irá sobrescrever os valores, no caso a chave vc, passaria a ser você2
    // diferente do Set, que ignora, o Map sobrescreve os valores quando as chaves são iguais
    map.put("vc", "você2");
    // por isso temos o método, putIfAbsent, quer dizer que ele só vai adicionar caso não exista
    // ele veio apartir da versão 1.8
    map.putIfAbsent("vc", "você2");

    map.putIfAbsent("vc2", "você2");
    // podemos visualizar as chaves e valores dessa forma
    System.out.println(map);

    // mas também queremos iterar sobre map, vamos iterar sobre eles
    // temos duas opções,
    // utilizando a navegação via chaves
    // ou utilizando a navegação via valores
    // como sabemos, para cada chave, temos um valor. Se pegarmos todas essas chaves, o que nós temos? lembrando que
    // a chave representa elementos unicos, a chave é um Set, é por isso que dentro do nosso map, temos o que chamamos
    // de keySet, pois ele retorna um Set que nesse caso é de string
    // e temos o values, o values retorna o tipo mais genérico, que é uma collection que nesse caso é de string, podemos
    // ter valores duplicados, podemos por exemplo, ter duas chaves diferentes mas com valores iguais

    // vamos pegar todas as chaves
    for(String key : map.keySet()) {
      // podemos também pegar os valores, dessa forma, onde chamamos o método get que retorna uma String, e que no
      // argumento é pedido a chave
      System.out.println(key + ": " + map.get(key));
    }

    System.out.println("----------------");

    // temos outra opção, ao invés de percorrer pela chave, podemos percorrer pelo valor
    for(String value : map.values()){
      System.out.println(value);
    }

    System.out.println("----------------");

    // agora se quisermos pegar os dois ao mesmo tempo, para n ter que ficar pegando de um em um
    // dessa forma, nós temos através dessa variavel entry, a chave e o valor
    // é uma forma estranha mas é útil
    // onde estamos utilizando a interface Map e chamando a interface Entry que temos que passar um par de chave-valor
    // e baseado no map.entrySet(), irá retornar o par de chave-valor
    for(Map.Entry<String, String> entry : map.entrySet()) {
      // aqui podemos pegar tanto a chave quanto o valor no mesmo for
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }

  }
}
