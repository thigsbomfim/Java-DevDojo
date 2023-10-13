package com.devdojo.maratonajava.javacore.Xserializacao.test;

import com.devdojo.maratonajava.javacore.Xserializacao.dominio.Aluno;
import com.devdojo.maratonajava.javacore.Xserializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
  public static void main(String[] args) {
    Aluno aluno = new Aluno(1L, "Thiago Bomfim", "123456789");
    Turma turma = new Turma( "Maratona Java Virado no Jiraya em Breve Ricos");
    aluno.setTurma(turma);
     serializar(aluno);
    deserializar();
  }

  // Quando estamos serializando, estamos transformando um objeto em um array de bytes, então estamos trabalhando em
  // baixo nivel
  // geralmente quando estamos trabalhando em baixo nivel, estamos trabalhando com uma das classes Stream
  private static void serializar(Aluno aluno){
    Path path = Paths.get("pasta/aluno.ser");

    // aqui estamos falando que ele quando for escrever, vai ter que escrever para esse path
    try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
      oos.writeObject(aluno);
    }catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // para deserializar um arquivo/objeto
  // quando estamos um objeto deserializado, o java não vai utilizar o construtor
  // se estivermos trabalhando com herança, o negocio fica mais complicado, pois na herança, o objetivo do construtor
  // é sempre chamar o super, como iremos chamar o super na deserialização se o construtor não é executado?
  private static void deserializar(){
    Path path = Paths.get("pasta/aluno.ser");

    // aqui estamos falando que ele quando for escrever, vai ter que escrever para esse path
    try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
      // fazendo o cast e deserializando um arquivo/object
      Aluno aluno = (Aluno) ois.readObject();
      System.out.println(aluno);
    }catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
