package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
  public static void main(String[] args) {
    // Para colocar um valor dentor do NavigableMap, precisamos que a interface/classe utilize a implementação do
    // Comparable ou passar um Comparator.
    // A mesma coisa do NavigableSet, sendo que no NavigableMap é usado para as chaves
    // Somente a chave precisa implementar o Comparable ou Comparator

    Consumidor consumidor1 = new Consumidor("William Suane");
    Consumidor consumidor2 = new Consumidor("DevDojo Academy");
    NavigableMap<Consumidor, Consumidor> mapConsumidor = new TreeMap<>();
    // nesse caso, a classe Consumidor não implementa o Comparable, então ao tentar executar esse codigo, irá gerar uma
    // exceção, pois a chave que está sendo passada não é um Comparable
    // mas podemos fazer dessa forma, que a chave que está sendo passada não precisa ser um comparable, pois ela é um
    // tipo primitivo, e ela implementa o Comparable
    NavigableMap<String, Consumidor> mapConsumidor1 = new TreeMap<>();
    // irá gerar um erro, pois Consumidor não é um Comparable
//    mapConsumidor.put(consumidor1, consumidor1);
    // para não ocorrer execeção, pode ser feito dessa forma:
    mapConsumidor1.put("consumidor1", consumidor1);

    //           Chave   Valor
    NavigableMap<String, String> map = new TreeMap<>();
    map.put("A", "Letra A");
    map.put("C", "Letra C");
    map.put("D", "Letra D");
    map.put("E", "Letra E");
    map.put("B", "Letra B");

    for(Map.Entry<String, String> entry : map.entrySet()){
      // podemos ver que ele ordena, mas eles ordenam pela chave
      // então o valor, não precisa implementar o Comparable
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    // outros métodos legais que temos, um bem interessante:
    // ele tem duas opções: toKey, e um boolean incluso
    // exemplo, estou passando a letra C, ele vai retornar tudo mundo que está abaixo da letra C ("A", "B")
    // se tivessemos trabalhando com preços, seria os numeros menores que aquele preço
    // é importante se atentar que o headMap está linkado com os objetos do map, então se alguma coisa for alterada
    // a partir dele, será alterado também no proprio objeto do Map
    System.out.println(map.headMap("C")); // {A=Letra A, B=Letra B}
//    System.out.println(map.headMap("C").remove("A")); // Letra A -> será removida do map

    // se quisermos incluir a chave que estamos passando no argumento, que no caso é a chave "C", basta colocar true
    // como segundo argumento
    System.out.println(map.headMap("C", true));


    // lower < (menor)
    // floor <= (menor ou igual)
    // higher > (maior)
    // ceiling >= (maior ou igual)
    // Esses métodos são para comparação com base no objeto que passamos. Se chamarmos "lower", ele trará o primeiro elemento menor.
    // Se chamarmos "floor", ele trará provavelmente o mesmo valor que estamos comparando ou, caso não exista, trará o imediatamente anterior a ele.
    // "higher" trará o primeiro elemento maior, e "ceiling" levará em consideração o valor que você está passando.

    // no ceiling, temos o ceilingEntry e ceilingKey
    // A unica diferença entre os dois é que um vai retornar um Entry e o outro uma string

    // estamos passando a chave como argumento
    System.out.println(map.ceilingKey("C")); // C -> é igual ou maior
    System.out.println(map.higherKey("C")); // D -> é maior
    System.out.println(map.lowerKey("C")); // B -> é menor
    System.out.println(map.floorKey("C")); // C -> é igual ou menor
  }
}
