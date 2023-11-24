package edu.hw4;


public record Animal(

    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    Boolean bites
) {
    private final static int COUNT_DOG_OR_CATS_PAWS = 4;

    private final static int COUNT_SPIDER_PAWS = 8;

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> COUNT_DOG_OR_CATS_PAWS;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> COUNT_SPIDER_PAWS;
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
