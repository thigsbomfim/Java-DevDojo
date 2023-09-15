package com.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoPagamento {
  DEBITO {
    // sobrescrevendo
    @Override
    public double calcularDesconto(double valor) {
      return valor * 0.1;
    }
  },
  CREDITO {
    @Override
    public double calcularDesconto(double valor) {
      return valor * 0.05;
    }
  };

  // método abstrato, que é obrigatório sobrescrever, e não pode criar um corpo para ele quando for declarado
  public abstract double calcularDesconto(double valor);
}