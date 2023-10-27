package edu.hw4;

import static edu.hw4.Animal.Sex.M;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    Boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    @Override public String name() {
        return name;
    }

    @Override public Type type() {
        return type;
    }

    @Override public Sex sex() {
        return sex;
    }

    @Override public int age() {
        return age;
    }

    @Override public int height() {
        return height;
    }

    @Override public int weight() {
        return weight;
    }

    @Override public Boolean bites() {
        return bites;
    }
}
