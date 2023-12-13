package com.devdojo.maratonajava.javacore.ZZEstreams.test;

/**
 * EXPLICAÇÃO SOBRE PARALLEL STREAM
 * */

// QUANDO DEVEMOS UTILIZAR O PARALELO STREAMS E QUANDO NÃO DEVEMOS UTILIZAR?
// PARA SABER, DEVEMOS FAZER O BENCHMARK, SEMPRE QUE FORMOS UTILIZAR, DEVEMOS TENTAR VER O PROCESSAMENTO, TENTAR USAR
// BIBLIOTECAS EXTERNAS OU ATÉ MESMO AQUELE EXEMPLO SIMPLES QUE FIZEMOS NA AULA StreamTest16, PARA SABER SE REALMENTE OS
// DADOS ESTÃO SENDO RETORNADOS DE FORMA MAIS RAPIDA.

// OUTRA COISA QUE DEVEMOS TOMAR CUIDADO NA HORA DE UTILIZAR O PARALELO STREAMS É NA PARTE DE UNBOXING E BOXING, ONDE
// TRABALHAMOS COM TIPOS PRIMITIVOS E WRAPPERS, INDEPENDENTE SE ESTAMOS UTILIZANDO MULTIPLAS THREADS OU NÃO, AINDA TEM
// UM CUSTO NA PERFORMANCE, ENTÃO QUANDO TIVERMOS UTILIZANDO O PARALELO STREAMS, TOMAR CUIDADO PARA SABER SE NÃO ESTAMOS
// ADICIONANDO UM POUCO DE PROCESSAMENTO PARA FAZER BOXING E UNBOXING, NÓS DIVIDIRMOS UMA TAREFA EM DIFERENTES THREADS,
// DAR PARA DIFERENTES TRABALHADORES, TEM SIM UM PEQUENO IMPACTO NA PERFORMANCE, ENTÃO SE FOR MUITO PEQUENA A TAREFA, O
// IMPACTO DE DIVIDIR ELA PARA PODER PARALELIZAR É MAIOR DO QUE ESTIVESSE FAZENDO EM UMA THREAD SÓ.

// E DEVEMOS TOMAR CUIDADO POR QUE TEM ALGUMAS OPERAÇÕES QUE SÃO MUITO RUIM DE FAZER DE FORMA PARALELA, EXEMPLO:
// (limit, findFirst), ELAS NÃO FORAM FEITAS PARA SEREM TRABALHADAS PARALELAMENTE, PODEMOS ACABAR TENDO PROBLEMA,
// PRINCIPALMENTE POR QUE O findFirst PRECISA QUE TENHAMOS TUDO ORDENADOS, JA O findAny É BOM PARA USARMOS DE FORMA
// PARALELA, JUSTAMENTE POR QUE A PARTIR DO MOMENTO QUE ACHARMOS 1, JA ERA.

// OUTRA COISA QUE PRECISA LEVAR EM CONSIDERAÇÃO É O CUSTO TOTAL DA COMPUTAÇÃO, COMO ASSIM?
// GERALMENTE QUANDO ESTAMOS TRABALHANDO COM STREAMS, TEREMOS UMA QUANTIDADE DE ELEMENTOS E UMA QUANTIDADE DE
// PROCESSAMENTO, QUANTO MAIOR A QUANTIDADE DE PROCESSAMENTO QUE PRECISAMOS FAZER, GERALMENTE VAMOS NOS BENEFICIAR SE
// CONSEGUIRMOS FAZER ISSO DE FORMA PARALELA, POIS TEMOS DUAS OU MAIS THREADS TRABALHANDO NO MESMO PROBLEMA, GERALMENTE
// SE O PROCESSAMENTO FOR MUITO ALTO, IREMOS NOS BENEFICIAR DO USO DE MULTIPLAS THREADS, OU SEJA, DE PARALEL STREAMS.

// OUTRA COISA QUE DEVEMOS TOMAR CUIDADO E LEVAR EM CONSIDERAÇÃO É A QUANTIDADE DE DADOS, SE A QUANTIDADE DE DADOS FOR
// MUITO PEQUENA, NÃO VALE A PENA UTILIZARMOS PARALEL STREAMS, POIS O CUSTO PARALELIZAR É MAIS ALTO QUE O CUSTO DE
// SIMPLESMENTE DE QUANDO UTILIZAMOS APENAS UMA THREAD PARA TRABALHAR NO PROCESSAMENTO DELA.

// OUTRA COISA SÃO OS TIPOS DE COLEÇÕES, ALGUMAS COLEÇÕES SÃO MUITO BOAS PARA SEREM TRABALHADAS DE FORMA PARALELA,
// ArrayList É EXCELENTE. LinkedList É UMA BOSTA, POR QUE PRECISAMOS PERCORRER A LISTA INTEIRA.
// O iterate DO STREAM É RUIM, O rangeClosed JÁ É MELHOR, QUE É O MÉTODO QUE TEMOS NOS WRAPPERS.
// O Set, JÁ TEM UMA PERFORMANCE MELHORZINHA, SEMPRE QUE FORMOS UTILIZAR É BOM PESQUISAR ANTES POR QUE AJUDA A TER NOÇÃO
// SE A COLEÇÃO QUE ESTAMOS TRABALHANDO REALMENTE FOI FEITA PARA TRABALHAR DE FORMA PARALELIZADA.

// QUANDO TEMOS AS COLEÇÕES, TAMBÉM TEMOS OS TAMANHO DAS STREAMS, GERALMENTE OS STREAMS QUE JA TEM TAMANHOS DEFINIDOS,
// SÃO MELHORES PARA PARALELIZAR. ENTÃO POR EXEMPLO, SE TEMOS UM STREAM QUE VAI SER CRIADO DINAMICAMENTE TALVEZ TENHAMOS
// TRABALHO PARA PARALELIZAR, POR QUE PARA PARALELIZAR, A TAREFA PRECISA SER DIVIDIDA, SE A GENTE NÃO SABE O TANTO DE
// TAREFA QUE TEMOS, COMO SABEMOS COMO IREMOS DIVIDIR A QUANTIDADE?

// OUTRA COISA QUE PRECISAMOS TOMAR CUIDADO É O PROCESSAMENTO DO MERGE É O QUE PRECISAMOS TOMAR CUIDADO.
// POR BAIXO DOS PANOS O PARALEL STREAMS UTILIZA UM FRAMEWORK CHAMADO FORK JOIN, QUEBRAR AS TAREFAS SIGNIFICA "FORK" E
// QUEBRAR SIGNIFICA "JOIN".

/*
if(tarefa for pequena e não pode ser dividida)
  faz sequencialmente
else {
  divide em duas tarefas
  chama o mesmo método recursivamente
  espera todas as tarefas serem completadas
  combina o resultado
 */

// ENTÃO COMO FUNCIONA? DIGAMOS QUE TENHAMOS UMA TAREFA BEM GRANDE ONDE O STREAM VAI TER QUE TRABALHAR:
/*
                               "FORK JOIN"
                          DIVIDE EM DUAS TAREFAS
                                 FORK
                                   |
   ________________________________|_______________________________
  |                                |                               |
  |                                |                               |
  |________________________________|_______________________________|
                  |                |                |
                  |                |                |
           UMA TAREFA AQUI         |        OUTRA TAREFA AQUI
                 FORK                              FORK
           _______|_______                  ________|________
          |       |       |                |        |        |
          |       |       |                |        |        |
          |_______|_______|                |________|________|
                  |                                 |
  MAS AI, ELE VAI |  EXECUTAR ISSO RECURSIVAMENTE,  |  QUE SIGNIFICA QUE PODE AINDA TER A DIVISÃO E AINDA MAIS TAREFAS,
  FICARIA ASSIM:  |                                 |
                  |                                 |
     ____         |         ____       ____         |         ____
    |    |        |        |    |     |    |        |        |    |
    |    |__FORK__|__FORK__|    |     |    |__FORK__|__FORK__|    |
    |____|                 |____|     |____|                 |____|
      |                      |           |                     |
      |                      |           |                     |
 ESSA | LINHA ABAIXO É PARA  | DIZER QUE |  APARTIR DAQUI, AS  | TAREFAS NÃO PODEM MAIS SER QUEBRADAS COM FORK
_____________________________________________________________________________________________
      |                      |           |                     |
      |                      |           |                     |
  RESULTADO              RESULTADO   RESULTADO             RESULTADO
     _|_                    _|_         _|_                   _|_
    |   |                  |   |       |   |                 |   |
    |___|                  |___|       |___|                 |___|
      |                      |           |                     |
      |                      |           |                     |
      |______________________|           |_____________________|
                  |                                  |
                  |                                  |
  A PARTIR DESSA LINHA ABAIXO É QUE ELE COMEÇA A FAZER O JOIN, QUE É O PROCESSAMENTO DE MERGE
__________________|__________________________________|_______________________________________
                  |                                  |
                JOIN                               JOIN
                  |                                  |
         RESULTADO COMPLETO                 RESULTADO COMPLETO
             _____|_____                        _____|_____
            |           |                      |           |
            |           |                      |           |
            |           |                      |           |
            |___________|                      |___________|
                  |                                  |
                  |                                  |
                  |__________________________________|
                                    |
                                    |
                             RESULTADO FINAL
                               _____|_____
                              |           |
                              |           |
                              |           |
                              |___________|


  TUDO ISSO QUE ELE VAI QUEBRANDO É O FORK, FORK, FORK. AI O NEGÓCIO É QUE QUANDO FICA MUITO PEQUENO, OU SEJA, QUANDO
  CHEGA NO if(tarefa pequena não pode ser dividida) O QUE ELE VAI FAZER?
  ELE VAI EXECUTAR SEQUENCIALMENTE, AI QUE VEM A PARTE DO JOIN DO "FORK JOIN", POR QUE ISSO QUE DARÁ ORIGEM
  AO RESULTADO, QUE É O CIRCULO. AI TEMOS ESSES RESULTADOS QUE PRECISAM SER JUNTADOS, QUE É O CASO DO
  RESULTADO COMPLETO, E ENTÃO TEREMOS O RESULTADO FINAL.
  SE O RESULTADO FINAL FOR MUITO GRANDE, SE O PROCESSAMENTO PARA CHEGAR NO RESULTADO FINAL FOR MUITO GRANDE, AI TALVEZ
  UTILIZAR STREAMS PARALELS NÃO SEJA UMA BOA IDEIA, MAS SE NÃO FOR MUITO GRANDE, PODEMOS UTILIZAR.
*/



public class StreamTest17 {
  public static void main(String[] args) {
  }
}
