package com.devdojo.maratonajava.javacore.ZZDoptional.test;


import com.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import com.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
  public static void main(String[] args) {
    Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
    mangaByTitle.ifPresent(m -> m.setTitle("Boku no Hero 2"));
    System.out.println(mangaByTitle);

    Optional<Manga> mangaById = MangaRepository.findById(2);
    // aqui iremos lançar uma exceção caso não encontre o manga pelo id, e se encontrar, irá exibir o mangá
    mangaById.orElseThrow(IllegalArgumentException::new);

    System.out.println(mangaById);

    Manga newManga = MangaRepository.findByTitle("Drifters")
            // aqui estamos dizendo para caso não encontre, crie um novo manga com esse nome
            .orElseGet(() -> new Manga(3, "Drifters", 20));

    System.out.println(newManga);

  }
}
