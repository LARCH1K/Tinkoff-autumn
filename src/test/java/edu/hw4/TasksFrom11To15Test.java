package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.TasksFrom11To15.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TasksFrom11To15Test {

    List<Animal> animals = List.of(
        new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
        new Animal("Buddy", Animal.Type.DOG, Animal.Sex.M, 4, 105, 20, true),
        new Animal("Tweetie", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 0, false),
        new Animal("Goldie", Animal.Type.FISH, Animal.Sex.F, 2, 5, 0, false),
        new Animal("Spinner Spin Jr", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 0, true),
        new Animal("Fluffy", Animal.Type.CAT, Animal.Sex.F, 2, 25, 4, true),
        new Animal("Rex", Animal.Type.DOG, Animal.Sex.M, 5, 50, 18, true),
        new Animal("Sunny", Animal.Type.BIRD, Animal.Sex.F, 2, 15, 1, false),
        new Animal("Nemo Dori Jr", Animal.Type.FISH, Animal.Sex.M, 1, 3, 0, false),
        new Animal("Charlotte", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true)
    );

    @Test
    void task11Test() {
        List<Animal> result = potentialBiters(animals);
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).name()).isEqualTo("Buddy");
    }

    @Test
    void task12Test() {
        Integer result = countWeightOverHeightAnimals(animals);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void task13Test() {
        List<Animal> result = longNamedAnimals(animals);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).name()).isEqualTo("Spinner Spin Jr");
        assertThat(result.get(1).name()).isEqualTo("Nemo Dori Jr");
    }

    @Test
    void task14Test() {
        Boolean result = hasTallDog(animals, 100);
        assertThat(result).isEqualTo(true);
        result = hasTallDog(animals, 120);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void task15Test() {
        Integer result = totalWeightOfSelectedAge(animals, 2, 6);
        assertThat(result).isEqualTo(48);
    }
}
