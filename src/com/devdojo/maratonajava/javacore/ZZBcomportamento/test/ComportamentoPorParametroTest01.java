package com.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import com.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
  private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

  public static void main(String[] args) {
    System.out.println(filterRedCar(cars));
    System.out.println(filterGreenCar(cars));

    System.out.println(filterCarByColor(cars, "green"));
    System.out.println(filterCarByColor(cars, "red"));

    System.out.println("---------");

    System.out.println(filterByYearBefore(cars, 2015));
  }

  // como podemos observar em todos os métodos, apenas o if é alterado, onde apenas a condição é alterada
  // e se a gente podesse passar essa condição por parâmetro?
  // vamos melhorar esse código, ficará no pacote interfaces desse pacote ZZBcomportamento e na outra classe
  // ComportamentoPorParametroTest02.

  // para filtrar carros com as cores verdes
  private static List<Car> filterGreenCar(List<Car> cars){
    List<Car> filteredCar = new ArrayList<>();
    for (Car car : cars) {
      if(car.getColor().equals("green")){
        filteredCar.add(car);
      };
    }
    return filteredCar;
  }

  // para filtrar carros com as cores vermelhas
  private static List<Car> filterRedCar(List<Car> cars){
    List<Car> filteredCar = new ArrayList<>();
    for (Car car : cars) {
      if(car.getColor().equals("red")){
        filteredCar.add(car);
      };
    }
    return filteredCar;
  }

  // para filtrar carros com cores passadas por parâmetros para não precisar ficar criando um método para cada filtragem
  // igual fizemos acima
  private static List<Car> filterCarByColor(List<Car> cars, String color){
    List<Car> filteredCar = new ArrayList<>();
    for (Car car : cars) {
      if(car.getColor().equals(color)){
        filteredCar.add(car);
      };
    }
    return filteredCar;
  }


  private static List<Car> filterByYearBefore(List<Car> cars, int year){
    List<Car> filteredCar = new ArrayList<>();
    for (Car car : cars) {
      if(car.getYear() < year){
        filteredCar.add(car);
      };
    }
    return filteredCar;
  }


}
