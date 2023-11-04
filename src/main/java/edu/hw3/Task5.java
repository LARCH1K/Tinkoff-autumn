package edu.hw3;

import java.util.Arrays;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    static Person[] parseContacts(String[] names, String sortOrder) {
        if (names == null) {
            return new Person[] {};
        }
        Person[] result = convertToPersonArray(names);
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
        Arrays.sort(result, nameComparator);
        return result;
    }

    private static Person[] convertToPersonArray(String[] names) {
        Person[] result = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) {
                result[i] = (new Person(parts[0], parts[1]));
            } else if (parts.length == 1) {
                result[i] = (new Person(parts[0], ""));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    record Person(String firstName, String lastName) {
        @Override public String toString() {
            return "\"" + firstName + ' ' + lastName + "\"";
        }
    }

}
