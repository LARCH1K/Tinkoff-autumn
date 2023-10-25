package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw3.Task5.*;
import static edu.hw3.Task5.parseContacts;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task5Test {

    @Test
    @DisplayName("Test from task")
    void parseContactsTaskTest() {
        Person[] personsExpected = new Person[4];
        personsExpected[0] = new Person("Thomas", "Aquinas");
        personsExpected[1] = new Person("Rene", "Descartes");
        personsExpected[2] = new Person("David", "Hume");
        personsExpected[3] = new Person("John", "Locke");
        Person[] personsActual =
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC");
        assertArrayEquals(personsExpected, personsActual);

        Person[] personsExpected1 = new Person[3];
        personsExpected1[0] = new Person("Carl", "Gauss");
        personsExpected1[1] = new Person("Leonhard", "Euler");
        personsExpected1[2] = new Person("Paul", "Erdos");
        Person[] personsActual1 = parseContacts(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC");
        assertArrayEquals(personsExpected1, personsActual1);

        Person[] personsExpected2 = new Person[] {};
        Person[] personsActual2 = parseContacts(new String[] {}, "DESC");
        assertArrayEquals(personsExpected2, personsActual2);

        Person[] personsExpected3 = new Person[] {};
        Person[] personsActual3 = parseContacts(null, "DESC");
        assertArrayEquals(personsExpected3, personsActual3);
    }

    @Test
    @DisplayName("Test without lastname")
    void parseContactsWithoutLastnameTest() {
        Person[] personsExpected = new Person[4];
        personsExpected[0] = new Person("Thomas", "Aquinas");
        personsExpected[1] = new Person("David", "Hume");
        personsExpected[2] = new Person("John", "Locke");
        personsExpected[3] = new Person("Rene", "");
        Person[] personsActual =
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene"}, "ASC");
        assertArrayEquals(personsExpected, personsActual);
    }

    @Test
    @DisplayName("Test with throws exception if input null")
    void parseContactsThrowExceptionIfInputWrongSortOrderTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> parseContacts(new String[] {"John Locke", "Thomas Aquinas", "Rene Descartes"}, "123")
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> parseContacts(new String[] {"Carl Gauss", "Paul Erdos", "Leonhard Euler"}, "null")
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> parseContacts(new String[] {"Paul Erdos", "Leo nhard Euler", "Carl Gauss"}, "ASC")
        );
    }
}
