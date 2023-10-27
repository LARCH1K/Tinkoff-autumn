package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class TasksFrom11To15 {

    static List<Animal> potentialBiters(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> (animal.bites() == null || animal.bites()) && animal.height() > 100)
            .collect(Collectors.toList());
    }

    static Integer countWeightOverHeightAnimals(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    static List<Animal> longNamedAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    static Boolean hasTallDog(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    static Integer totalWeightOfSelectedAge(List<Animal> animals, int k, int l) {
        return animals.stream()
                .filter(animal -> animal.age() >= k && animal.age() <= l).mapToInt(Animal::weight).sum();
    }
}
