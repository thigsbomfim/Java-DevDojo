package com.devdojo.maratonajava.javacore.Kenum.test;

import com.devdojo.maratonajava.javacore.Kenum.dominio.Cliente;
import com.devdojo.maratonajava.javacore.Kenum.dominio.TipoCliente;
import com.devdojo.maratonajava.javacore.Kenum.dominio.TipoPagamento;

public class ClienteTest01 {
  public static void main(String[] args) {
    Cliente cliente1 = new Cliente("Tsubasa", TipoCliente.PESSOA_FISICA, TipoPagamento.CREDITO);
    Cliente cliente2 = new Cliente("Akira", TipoCliente.PESSOA_JURIDICA, TipoPagamento.DEBITO);

    System.out.println(cliente1);
    System.out.println(cliente2);
    System.out.println(TipoPagamento.DEBITO.calcularDesconto(100));
    TipoCliente tipoCliente = TipoCliente.valueOf("PESSOA_FISICA");
    System.out.println(tipoCliente.getNomeRelatorio());
    TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Física");
    System.out.println(tipoCliente2);
  }
}
