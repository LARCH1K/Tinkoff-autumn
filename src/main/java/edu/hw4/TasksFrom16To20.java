package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TasksFrom16To20 {

    static List<Animal> sortedAnimals(List<Animal> animals){
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    static Boolean spidersBiteMore(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER || animal.type() == Animal.Type.DOG)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal
                -> (animal.bites() != null && animal.bites()) ? 1 : 0)))
            .getOrDefault(Animal.Type.SPIDER, 0) >
                (Integer) animals.stream()
                        .filter(animal -> animal.type() == Animal.Type.DOG)
                    .mapToInt(animal -> (animal.bites() != null && animal.bites()) ? 1 : 0).sum();
    }

    static Animal heaviestFish(List<Animal> animals1, List<Animal> animals2){
        return Stream.of(animals1, animals2)
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    static Map<String, Set<ValidationError>> animalsWithErrors(List<Animal> animals){
        return animals.stream()
            .filter(animal -> animal.name() == null || animal.type() == null || animal.sex() == null
                || animal.age() < 0 || animal.height() < 0 || animal.weight() < 0)
            .collect(Collectors.toMap(
                Animal::name,
                animal -> Stream.of(
                        animal.name() == null ? ValidationError.NAME_IS_NULL : null,
                        animal.type() == null ? ValidationError.TYPE_IS_NULL : null,
                        animal.sex() == null ? ValidationError.SEX_IS_NULL : null,
                        animal.age() < 0 ? ValidationError.AGE_IS_NEGATIVE : null,
                        animal.height() < 0 ? ValidationError.HEIGHT_IS_NEGATIVE : null,
                        animal.weight() < 0 ? ValidationError.WEIGHT_IS_NEGATIVE : null)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet())));
    }

    static Map<String, String>  animalsWithErrorsReadable(List<Animal> animals) {
        return animalsWithErrors(animals).entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                    .map(Enum::toString)
                    .collect(Collectors.joining(", "))));
    }

}
