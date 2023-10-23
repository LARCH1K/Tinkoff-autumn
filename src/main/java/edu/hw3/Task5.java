package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    static ArrayList<Person> parseContacts(String[] names, String sortOrder) {
        if (names == null) {
            return new ArrayList<Person>();
        }
        ArrayList<Person> result = convertToPersonArrayList(names);
        Comparator<Person> nameComparator = (firstPerson, secondPerson) -> {
            String compareFirst = firstPerson.lastName;
            if (firstPerson.lastName.isEmpty()) {
                compareFirst = firstPerson.firstName;
            }
            String compareSecond = secondPerson.lastName;
            if (secondPerson.lastName.isEmpty()) {
                compareSecond = secondPerson.firstName;
            }
            if ("ASC".equalsIgnoreCase(sortOrder)) {
                return compareFirst.compareTo(compareSecond);
            } else if ("DESC".equalsIgnoreCase(sortOrder)) {
                return compareSecond.compareTo(compareFirst);
            } else {
                throw new IllegalArgumentException("Недопустимый порядок сортировки. "
                    + "Используйте \"ASC\" или \"DESC\".");
            }
        };
        result.sort(nameComparator);
        return result;
    }

    private static ArrayList<Person> convertToPersonArrayList(String[] names) {
        ArrayList<Person> result = new ArrayList<>();
        for (final String name : names) {
            String[] parts = name.split(" ");
            if (parts.length == 2) {
                result.add(new Person(parts[0], parts[1]));
            } else if (parts.length == 1) {
                result.add(new Person(parts[0], ""));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    private record Person(String firstName, String lastName) {
        @Override public String toString() {
            return "\"" + firstName + ' ' + lastName + "\"";
            }
        }

}
