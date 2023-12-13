package com.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import com.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import com.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
  private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));
  // vamos melhorar o código do arquivo ComportamentoPorParametroTest01, onde estamos criando esse método para filtrar
  // carros
  public static void main(String[] args) {
    // aqui estamos chamando o método criado abaixo, a partir dele, iremos passar como primeiro argumento a lista de
    // carros, e no segundo argumento passaremos a classe anonima
    // nesse código abaixo, temos o mesmo resultado da classe ComportamentoPorParametroTest01, a diferença é que nós
    // temos a interface que define o método test, mas o método dessa interface não tem comportamento, o comportamento
    // virá através da subclasse anonima que estamos criando abaixo:
//    List<Car> greenCars = filter(cars, new CarPredicate() {
//      @Override
//      public boolean test(Car car) {
//        return car.getColor().equals("green");
//      }
//    });

    // podemos também usar a sintaxe lambda, como só temos um método na interface CarPredicate, quando temos um só
    // método, é chamado de Predicate.
    // Podemos ver que utilizando uma interface combinada com classes anonimas, é possivel criar métodos de forma
    // eficiente.
    List<Car> greenCars = filterCars(cars, car -> car.getColor().equals("green"));
    // se quisermos carros vermelho, basta alterar dessa forma:
    List<Car> redCars = filterCars(cars, car -> car.getColor().equals("red"));
    // se quisermos carros menores que 2015:
    List<Car> yearBeforeCars = filterCars(cars, car -> car.getYear() < 2015);

    // como podemos observar, através desse método abaixo, definimos apenas uma lógica de negócio que irá mudar de
    // acordo com a chamada, ou seja, o comportamento está vindo por parâmetro
    System.out.println(greenCars);
    System.out.println(redCars);
    System.out.println(yearBeforeCars);
  }

  // Estamos criando com o nome de filter, pois a responsabilidade não vai ser mais do método que nós definimos
  // no if car.getColor() dentro do código, a responsabilidade da regra de negócio vai ser enviar via CarPredicate
  // como podemos ver, não sabemos qual vai ser o test, temos que definir através de uma classe anonima
  private static List<Car> filterCars(List<Car> cars, CarPredicate carPredicate){
    List<Car> filteredCar = new ArrayList<>();
    for (Car car : cars) {
//      if(car.getColor().equals(color)){
//        filteredCar.add(car);
//      }

      if(carPredicate.test(car)){
        filteredCar.add(car);
      }
    }
    return filteredCar;
  }

  // podemos até criar métodos para filtrar qualquer tipo de coisa, onde iremos usar uma interface que é do proprio java
  // que é um Predicate
//  private static <T> List<T> filter(List<T> list){
//    for (T t : list) {
//
//    }
//    return list;
//  }
}
