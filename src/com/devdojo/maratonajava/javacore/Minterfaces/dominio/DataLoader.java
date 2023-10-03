package com.devdojo.maratonajava.javacore.Minterfaces.dominio;

// uma interface não pode ser colocada a palavra final, pois ela precisa ser extendida

public interface DataLoader {
  // uma interface automaticamente ja colocam os métodos abstrato e publico
  // public abstract void load();
  // por padrão, todos os atributos de uma interface são constantes
  public static final int MAX_DATA_SIZE = 10;
  public abstract void load();

  // quando usamos o default, estamos dizendo que a própria interface está definindo o método
  // por padrão os métodos na interface recebem o modificador public e abstract, mas se você não quiser criar dessa
  // forma, use default para substituir
  public default void checkPermission(){
    System.out.println("Fazendo checagem de permissões");
  };


  // a partir do java 8, métodos estáticos nunca vão ser sobrescritos, por serem parte da classe em si
  public static void retrieveMaxDataSize(){
    System.out.println("Dentro do retrieveMaxDataSize na interface");
  }


}
