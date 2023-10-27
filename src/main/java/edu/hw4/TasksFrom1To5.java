package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TasksFrom1To5 {

    private TasksFrom1To5() {
    }

    static List<Animal> sortedByHeight(List<Animal> animals){
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    static List<Animal> sortedByWeightWithLimit(List<Animal> animals, int k){
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    static Map<Animal.Type, Integer> countByType(List<Animal> animals){
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    static Animal longestNameAnimal(List<Animal> animals) {
        return  animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    static Animal.Sex moreCommonSex(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse(null);
    }
}
