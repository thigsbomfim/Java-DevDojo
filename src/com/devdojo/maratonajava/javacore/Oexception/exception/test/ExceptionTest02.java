package com.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;


public class ExceptionTest02 {
  public static void main(String[] args) {

    // tratar
    // criarNovoArquivo();
  }

  // quando usamos o throws na criação do método, jogamos a responsabilidade de tratar o método para o método que está
  // chamando esse método abaixo
  // quando utilizar throws Exception e quando usar o try/catch:
  // Se estamos criando um método privado, as chances é que vamos acabar usando o try/catch, por que o método privado
  // ninguem fora dessa classe terá acesso a esse método
  // agora se o método for public, não temos noção nenhuma de quem irá chamar esse método e eles podem ter uma visão
  // diferente de como a criação do arquivo deveria ser tratada

  // ainda existe uma opção de fazer algo hibrido, ou seja, capturamos a exceção e relança a exceção
  // quando relançamos uma exceção do tipo IOException, somos obrigados a colocar o throws IOException na assinatura do
  // método
  public static void criarNovoArquivo() throws IOException{
    File file = new File("arquivo\\teste.txt");
    try {
      boolean isCriado = file.createNewFile();
      System.out.println("Arquivo criado: "+isCriado);
    } catch (IOException e){
      // aqui estamos trabalhando na impressão do console
      e.printStackTrace();
      // aqui estamos relançando a exceção
      throw e;

      // relançamos uma exceção, não necessariamente precisa ser a mesma exceção se o problema for uma exceção diferente
      // como dessa forma abaixo
      // a pessoa que está chamando(método main), não precisa mais fazer o tratamento de IOException, não estamos
      // obrigando a colocarem o try/catch dentro do bloco mas ainda estamos dando a chance deles trabalharem em cima
      // de uma exceção
      // throw new RuntimeException("Problema na hora de criar o arquivo");
    }



  }
}
