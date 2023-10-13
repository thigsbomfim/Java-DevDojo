package com.devdojo.maratonajava.javacore.Ycolecoes.test;

import com.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
  public static void main(String[] args) {
    List<Manga> mangas = new ArrayList<>(6);
    // Estamos criando os objetos conforme os adicionamos à lista.
    mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
    mangas.add(new Manga(1L, "Berserk", 11.20, 5));
    mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
    mangas.add(new Manga(3L, "Attack on Titan", 9.5, 2));
    mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));

//    // não usar o foreach para remoção
//    for (Manga manga : mangas) {
//      // a variavel de referencia manga, está fazendo referencia aos objetos que estão sendo capturados no for
//      // aqui estamos dizendo que se a quantidade do manga, for igual a 0, para remover esse manga
//      // sendo que ira ocorrer uma exceção e não é muito viavel utilizar o foreach para remover um objeto da lista
//      if(manga.getQuantidade() == 0) mangas.remove(manga);
//    }

    // Iterator é uma classe que meio que checa antes de fazer alguma ação, por exemplo, imagina que estamos no banco
    // e estamos olhando a fila do banco, nós somos o iterator, a fila do banco são os objetos da lista mangas, antes
    // de chamar alguem da fila, iremos olhar: tem alguem na fila? tem, então você vem ca.
    // ai a pessoa veio e você vai olhar pra fila denovo e se tiver outra pessoa você checa se tem, para depois apontar
    // o dedo e chamar também
    //
    Iterator<Manga> mangaIterator = mangas.iterator();
    // enquanto, mangaIterator, tiver um proximo manga (hasNext()), ou seja, enquanto existir, somos nós olhando para a
    // fila do banco
    while(mangaIterator.hasNext()) {
      // eu quero que, caso exista, você pega a pessoa, utilizando o next(), esse método está pegando o objeto
      // podemos ver que esse next retorna um manga
      // Manga manga = mangaIterator.next();
      // if(manga.next().getQuantidade() == 0) mangaIterator.remove();

      // podemos até simplificar o codigo, ao inves de pegarmos a variavel de referencia igual estamos fazendo acima,
      // podemos jogar diretamente o next no if
      // aqui estamos dizendo que se a quantidade de manga for igual a 0, para remover utilizando o mangaIterator
      if(mangaIterator.next().getQuantidade() == 0) mangaIterator.remove();
    }
    // podemos observar que os objetos que continham a quantidade de 0, foram removidos da lista
    System.out.println(mangas);

    // a partir do java 8, introduziram um método chamado removeIf
    // primeiro precisamos de uma variavel de referencia, igual nós fazemos no for pegando manga,
    // "for (Manga manga : mangas)"
    // devemos introduzir o nome da variavel de referencia e um "->" que quer dizer que a logica de negócio vem depois
    // da seta
    // dessa forma estamos falando, navega por todos os mangas e remove se achar o manga.getQuantidade == 0
    mangas.removeIf(manga -> manga.getQuantidade() == 0);
  }
}
