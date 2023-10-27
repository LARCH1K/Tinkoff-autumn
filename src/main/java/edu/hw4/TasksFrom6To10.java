package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TasksFrom6To10 {

    private TasksFrom6To10() {
    }

    //Task 6
    static Map<Animal.Type, Animal> heaviestByType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    //Task 7
    static Animal kthOldest(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    //Task 8
    static Optional<Animal> heaviestBelowKHeight(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    //Task 9
    static Integer totalPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    //Task 10
    static List<Animal> ageNotMatchingPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .collect(Collectors.toList());
    }
}
