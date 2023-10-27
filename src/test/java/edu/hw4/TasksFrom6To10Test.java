package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import static edu.hw4.TasksFrom6To10.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TasksFrom6To10Test {

    List<Animal> animals = List.of(
        new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
        new Animal("Buddy", Animal.Type.DOG, Animal.Sex.M, 4, 45, 20, true),
        new Animal("Tweetie", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 0, false),
        new Animal("Goldie", Animal.Type.FISH, Animal.Sex.F, 2, 5, 0, false),
        new Animal("Spinner", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 0, true),
        new Animal("Fluffy", Animal.Type.CAT, Animal.Sex.F, 2, 25, 4, true),
        new Animal("Rex", Animal.Type.DOG, Animal.Sex.M, 5, 50, 18, true),
        new Animal("Sunny", Animal.Type.BIRD, Animal.Sex.F, 2, 15, 1, false),
        new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 3, 0, false),
        new Animal("Charlotte", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true)
    );

    @Test
    void task6Test() {
        Map<Animal.Type, Animal> result = heaviestByType(animals);
        assertThat(result.get(Animal.Type.CAT).name()).isEqualTo("Whiskers");
        assertThat(result.get(Animal.Type.DOG).name()).isEqualTo("Buddy");
        assertThat(result.get(Animal.Type.BIRD).name()).isEqualTo("Sunny");
        assertThat(result.get(Animal.Type.FISH).name()).isEqualTo("Goldie");
        assertThat(result.get(Animal.Type.SPIDER).name()).isEqualTo("Spinner");
    }

    @Test
    void task7Test() {
        Animal result = kthOldest(animals, 3);
        assertThat(result.name()).isEqualTo("Whiskers");
    }

    @Test
    void task8Test() {
        Optional<Animal> result = heaviestBelowKHeight(animals, 40);
        assertThat(result.get().name()).isEqualTo("Whiskers");
    }

    @Test
    void task9Test() {
        Integer result = totalPaws(animals);
        assertThat(result).isEqualTo(36);
    }

    @Test
    void task10Test() {
        List<Animal> result = ageNotMatchingPaws(animals);
        assertThat(result.size()).isEqualTo(8);
        assertThat(result.get(0).name()).isEqualTo("Whiskers");
        assertThat(result.get(1).name()).isEqualTo("Tweetie");
        assertThat(result.get(2).name()).isEqualTo("Goldie");
        assertThat(result.get(3).name()).isEqualTo("Spinner");
        assertThat(result.get(4).name()).isEqualTo("Fluffy");
        assertThat(result.get(5).name()).isEqualTo("Rex");
        assertThat(result.get(6).name()).isEqualTo("Nemo");
        assertThat(result.get(7).name()).isEqualTo("Charlotte");
    }

}
