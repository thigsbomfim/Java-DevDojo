package com.devdojo.maratonajava.javacore.ZZEstreams.test;

import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import com.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
  private static List<LightNovel> lightNovels = new ArrayList<>(
    List.of(
      new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
      new LightNovel("Overlord", 3.99, Category.FANTASY),
      new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
      new LightNovel("No Game no life", 2.99, Category.FANTASY),
      new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
      new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
      new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
      new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    )
  );

  public static void main(String[] args) {
    // utilizando codigos sem streams
    Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
    // teriamos que ter uma lista para cada categoria, começa a ficar complicado se tivermos que alterar e colocar
    // mais uma categoria, teriamos que ficar adicionando
    List<LightNovel> fantasy = new ArrayList<>();
    List<LightNovel> drama = new ArrayList<>();
    List<LightNovel> romance = new ArrayList<>();

    for (LightNovel lightNovel : lightNovels) {
      switch (lightNovel.getCategory()){
        case DRAMA: drama.add(lightNovel); break;
        case ROMANCE: romance.add(lightNovel); break;
        case FANTASY: fantasy.add(lightNovel); break;
      }
    }
    categoryLightNovelMap.put(Category.DRAMA, drama);
    categoryLightNovelMap.put(Category.ROMANCE, romance);
    categoryLightNovelMap.put(Category.FANTASY, fantasy);
    System.out.println(categoryLightNovelMap);


    // groupingBy, fará exatamente o que estamos fazendo acima, só precisamos dizer o que queremos como chave
    // nesse caso queremos LightNovel::getCategory.
    // o que foi gerado é exatamente o que estamos fazendo acima
    // fizemos isso tudo acima em apenas uma linha
    Map<Category, List<LightNovel>> collect = lightNovels
            .stream().collect(Collectors.groupingBy(LightNovel::getCategory));
    System.out.println(collect);
  }
}
