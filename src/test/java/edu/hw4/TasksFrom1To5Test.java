package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import static edu.hw4.TasksFrom1To5.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TasksFrom1To5Test {

    List<Animal> animals = List.of(
        new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
        new Animal("Buddy", Animal.Type.DOG, Animal.Sex.M, 4, 45, 20, true),
        new Animal("Tweetie", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 0, false),
        new Animal("Goldie", Animal.Type.FISH, Animal.Sex.F, 2, 5, 0, false),
        new Animal("Spinner", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 0, true),
        new Animal("Fluffy", Animal.Type.CAT, Animal.Sex.F, 2, 25, 4, true),
        new Animal("Rex", Animal.Type.DOG, Animal.Sex.M, 5, 50, 18, true),
        new Animal("Sunny", Animal.Type.BIRD, Animal.Sex.F, 3, 15, 1, false),
        new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 3, 0, false),
        new Animal("Charlotte", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true)
    );

    @Test
    void task1Test() {
        List<Animal> result = sortedByHeight(animals);
        assertThat(result.stream().map(Animal::height)).containsExactly(1, 2, 3, 5, 10, 15, 25, 30, 45, 50);
    }

    @Test
    void task2Test() {
        List<Animal> result = sortedByWeightWithLimit(animals, 5);
        assertThat(result.size()).isEqualTo(5);
        assertThat(result.stream().map(Animal::weight)).containsExactly(20, 18, 5, 4, 1);
    }

    @Test
    void task3Test() {
        Map<Animal.Type, Integer> result = countByType(animals);
        assertThat(result.get(Animal.Type.CAT)).isEqualTo(2);
        assertThat(result.get(Animal.Type.DOG)).isEqualTo(2);
        assertThat(result.get(Animal.Type.BIRD)).isEqualTo(2);
        assertThat(result.get(Animal.Type.FISH)).isEqualTo(2);
        assertThat(result.get(Animal.Type.SPIDER)).isEqualTo(2);
    }

    @Test
    void task4Test() {
        Animal result = longestNameAnimal(animals);
        assertThat(result.name()).isEqualTo("Charlotte");
    }

    @Test
    void task5Test() {
        Animal.Sex result = moreCommonSex(animals);
        assertThat(result).isEqualTo(Animal.Sex.M);
    }
}
