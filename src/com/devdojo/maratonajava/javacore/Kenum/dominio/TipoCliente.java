package com.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoCliente {
  PESSOA_NAOSEI(0, "Não sei"),
  PESSOA_FISICA(1, "Pessoa Física"),
  PESSOA_JURIDICA(2, "Pessoa Juridica");

  // pode ou não usar final
  private final int VALOR;
  private final String nomeRelatorio;

  public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio){
    // retorna um array com todos as enumerações (PESSOA_NAOSEI, PESSOA_FISICA, PESSOA_JURIDICA)
    for (TipoCliente tipoCliente : values()) {
      if(tipoCliente.getNomeRelatorio().equals(nomeRelatorio)) return tipoCliente;
    }
    return null;
  }

  // usam somente get no enum, ja que n queremos alterar nenhum tipo
  public int getVALOR() {
    return VALOR;
  }

  public String getNomeRelatorio() {
    return nomeRelatorio;
  }

  TipoCliente(int VALOR, String nomeRelatorio) {
    this.VALOR = VALOR;
    this.nomeRelatorio = nomeRelatorio;
  }
}
