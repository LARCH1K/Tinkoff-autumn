package edu.hw7;

import edu.hw7.task3.Person;
import edu.hw7.task3.PersonDatabase;
import edu.hw7.task3.SynchronizedPersonDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class Task3Test {
    private PersonDatabase personDatabase;

    @BeforeEach
    public void setUp() {
        personDatabase = new SynchronizedPersonDatabase();
    }

    @Test
    public void addTest() {
        Person person = new Person(1, "John", "123 Main St", "555-1234");

        personDatabase.add(person);

        assertEquals(person, personDatabase.findByName("John"));
        assertEquals(person, personDatabase.findByAddress("123 Main St"));
        assertEquals(person, personDatabase.findByPhone("555-1234"));
    }

    @Test
    public void deleteTest() {
        Person person = new Person(1, "John", "123 Main St", "555-1234");
        personDatabase.add(person);

        personDatabase.delete(1);

        assertNull(personDatabase.findByName("John"));
        assertNull(personDatabase.findByAddress("123 Main St"));
        assertNull(personDatabase.findByPhone("555-1234"));
    }

    @Test
    public void findByNameTest() {
        Person person = new Person(1, "John", "123 Main St", "555-1234");
        personDatabase.add(person);

        assertEquals(person, personDatabase.findByName("John"));
        assertNull(personDatabase.findByName("Nonexistent"));
    }

    @Test
    public void findByAddressTest() {
        Person person = new Person(1, "John", "123 Main St", "555-1234");
        personDatabase.add(person);

        assertEquals(person, personDatabase.findByAddress("123 Main St"));
        assertNull(personDatabase.findByAddress("Nonexistent"));
    }

    @Test
    public void findByPhoneTest() {
        Person person = new Person(1, "John", "123 Main St", "555-1234");
        personDatabase.add(person);

        assertEquals(person, personDatabase.findByPhone("555-1234"));
        assertNull(personDatabase.findByPhone("Nonexistent"));
    }

    @Test
    public void addMultiplePersonsTest() {
        Person person1 = new Person(1, "John", "123 Main St", "555-1234");
        Person person2 = new Person(2, "Jane", "456 Oak St", "555-5678");

        personDatabase.add(person1);
        personDatabase.add(person2);

        assertEquals(person1, personDatabase.findByName("John"));
        assertEquals(person2, personDatabase.findByName("Jane"));
    }

    @Test
    public void testConcurrentAddAndFind() {
        PersonDatabase spyDatabase = Mockito.spy(personDatabase);

        Person person = new Person(1, "John", "123 Main St", "555-1234");

        Thread addThread = new Thread(() -> {
            spyDatabase.add(person);
        });

        Thread findThread = new Thread(() -> {
            spyDatabase.findByName("John");
        });

        addThread.start();
        findThread.start();

        try {
            addThread.join();
            findThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        verify(spyDatabase, times(1)).add(person);
        verify(spyDatabase, times(1)).findByName("John");
    }
}
