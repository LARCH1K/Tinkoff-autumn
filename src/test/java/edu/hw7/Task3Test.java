package edu.hw7;

import edu.hw7.task3.Person;
import edu.hw7.task3.PersonDatabase;
import edu.hw7.task3.ReadWriteLockPersonDatabase;
import edu.hw7.task3.SynchronizedPersonDatabase;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    public void synchronizedPersonDatabaseConcurrentAddAndFindTest() {
        AtomicInteger errorsCount = new AtomicInteger(0);
        final int triesCount = 10000;

        for (int i = 0; i < triesCount; i++) {

            SynchronizedPersonDatabase personDatabase = new SynchronizedPersonDatabase();
            Thread adder = new Thread(() -> {
                Person person1 = new Person(1, "John", "123 Main St", "555-1234");
                Person person2 = new Person(2, "Jane", "456 Oak St", "555-5678");

                personDatabase.add(person1);
                personDatabase.add(person2);
            });

            Thread checker1 = new Thread(() -> {

                if (personDatabase.findByName("John") != null) {
                    if (personDatabase.findByAddress("123 Main St") == null) {
                        errorsCount.incrementAndGet();
                    }
                }
            });

            Thread checker2 = new Thread(() -> {
                if (personDatabase.findByAddress("456 Oak St") != null) {
                    if (personDatabase.findByPhone("555-5678") == null) {
                        errorsCount.incrementAndGet();
                    }
                }
            });

            adder.start();
            checker1.start();
            checker2.start();
            try {
                adder.join();
                checker1.join();
                checker2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        assertEquals(0, errorsCount.get());
    }

    @Test
    public void readWriteLockPersonDatabaseConcurrentAddAndFindTest() {
        AtomicInteger errorsCount = new AtomicInteger(0);
        final int triesCount = 10000;

        for (int i = 0; i < triesCount; i++) {

            ReadWriteLockPersonDatabase personDatabase = new ReadWriteLockPersonDatabase();
            Thread adder = new Thread(() -> {
                Person person1 = new Person(1, "John", "123 Main St", "555-1234");
                Person person2 = new Person(2, "Jane", "456 Oak St", "555-5678");

                personDatabase.add(person1);
                personDatabase.add(person2);
            });

            Thread checker1 = new Thread(() -> {

                if (personDatabase.findByName("John") != null) {
                    if (personDatabase.findByAddress("123 Main St") == null) {
                        errorsCount.incrementAndGet();
                    }
                }
            });

            Thread checker2 = new Thread(() -> {
                if (personDatabase.findByAddress("456 Oak St") != null) {
                    if (personDatabase.findByPhone("555-5678") == null) {
                        errorsCount.incrementAndGet();
                    }
                }
            });

            adder.start();
            checker1.start();
            checker2.start();
            try {
                adder.join();
                checker1.join();
                checker2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        assertEquals(0, errorsCount.get());
    }
}
