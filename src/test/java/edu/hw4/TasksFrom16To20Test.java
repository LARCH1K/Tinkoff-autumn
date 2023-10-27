package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static edu.hw4.TasksFrom16To20.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TasksFrom16To20Test {

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
    void task16Test() {
        List<Animal> result = sortedAnimals(animals);
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0).name()).isEqualTo("Whiskers");
        assertThat(result.get(1).name()).isEqualTo("Fluffy");
        assertThat(result.get(2).name()).isEqualTo("Buddy");
        assertThat(result.get(3).name()).isEqualTo("Rex");
        assertThat(result.get(4).name()).isEqualTo("Sunny");
        assertThat(result.get(5).name()).isEqualTo("Tweetie");
        assertThat(result.get(6).name()).isEqualTo("Nemo Dori Jr");
        assertThat(result.get(7).name()).isEqualTo("Goldie");
        assertThat(result.get(8).name()).isEqualTo("Charlotte");
        assertThat(result.get(9).name()).isEqualTo("Spinner Spin Jr");
    }

    @Test
    void task17Test() {
        Boolean result = spidersBiteMore(animals);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void task18Test() {
        List<Animal> animals1 = List.of(
            new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
            new Animal("Buddy", Animal.Type.DOG, Animal.Sex.M, 4, 105, 20, true),
            new Animal("Tweetie", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 0, false),
            new Animal("Weight Fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 1, false)
        );
        Animal result = heaviestFish(animals, animals1);
        assertThat(result.name()).isEqualTo("Weight Fish");
    }

    @Test
    void task19Test() {
        List<Animal> animalList = List.of(
            new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
            new Animal(null, Animal.Type.DOG, Animal.Sex.M, 4, 45, 20, true),
            new Animal("Tweetie", null, Animal.Sex.F, -1, 10, 0, false),
            new Animal("Goldie", Animal.Type.FISH, Animal.Sex.F, 2, -5, 0, false)
        );
        Map<String, Set<ValidationError>> result = animalsWithErrors(animalList);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.containsKey("Tweetie")).isEqualTo(true);
        assertThat(result.containsKey("Goldie")).isEqualTo(true);
        assertThat(result.containsKey(null)).isEqualTo(true);

        assertThat(result.get("Goldie").contains(ValidationError.HEIGHT_IS_NEGATIVE)).isEqualTo(true);
        assertThat(result.get(null).contains(ValidationError.NAME_IS_NULL)).isEqualTo(true);
        assertThat(result.get("Tweetie").contains(ValidationError.TYPE_IS_NULL)).isEqualTo(true);
        assertThat(result.get("Tweetie").contains(ValidationError.AGE_IS_NEGATIVE)).isEqualTo(true);
    }

    @Test
    void task20Test() {
        List<Animal> animalList = List.of(
            new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
            new Animal(null, Animal.Type.DOG, Animal.Sex.M, 4, 45, 20, true),
            new Animal("Tweetie", null, Animal.Sex.F, -1, 10, 0, false),
            new Animal("Goldie", Animal.Type.FISH, Animal.Sex.F, 2, -5, 0, false)
        );
        Map<String, String> result = animalsWithErrorsReadable(animalList);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.containsKey("Tweetie")).isEqualTo(true);
        assertThat(result.containsKey("Goldie")).isEqualTo(true);
        assertThat(result.containsKey(null)).isEqualTo(true);

        assertThat(result.get("Goldie")).isEqualTo("HEIGHT_IS_NEGATIVE");
        assertThat(result.get("Tweetie")).isEqualTo("TYPE_IS_NULL, AGE_IS_NEGATIVE");
        assertThat(result.get(null)).isEqualTo("NAME_IS_NULL");
    }
}
