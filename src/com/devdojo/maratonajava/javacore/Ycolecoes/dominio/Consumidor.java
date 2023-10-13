package com.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor {
  private Long id;
  private String nome;

  public Consumidor(String nome) {
    // para fazer o id ser auto-gerado, podemos usar o ThreadLocalRandom.current().nextLong(), ele irá gerar um numero
    // gigantesco, mas que tem uma certa garantia que vai ter um valor duplicado
    // de 0 até 100mil
    this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Consumidor{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Consumidor that = (Consumidor) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public String getNome() {
    return nome;
  }
}
