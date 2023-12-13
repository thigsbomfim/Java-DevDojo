package com.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import com.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import com.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
  private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

  public static void main(String[] args) {
    List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
    List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
    List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2015);

    System.out.println(greenCars);
    System.out.println(redCars);
    System.out.println(yearBeforeCars);
    
    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    List<Integer> numberEven  = filter(numbers, num -> num % 2 == 0);
    List<Integer> numberOdd = filter(numbers, num -> num % 2 == 1);
    System.out.println(numberEven);
    System.out.println(numberOdd);
  }

  // podemos até criar métodos para filtrar qualquer tipo de coisa, onde iremos usar uma interface que é do proprio java
  // que é um Predicate.
  // esse método está funcionando exatamente igual classe ComportamentoPorParametroTest02, mas a vantagem é que posso
  // usar esse método com qualquer tipo de classe, e não ficar limitado apenas na utilização de uma classe
  // método genérico
  private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
    List<T> filteredList = new ArrayList<>();
    for (T e : list) {
      if(predicate.test(e)){
        filteredList.add(e);
      }
    }
    return filteredList;
  }
}
