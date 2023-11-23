package edu.hw7.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public class SynchronizedPersonDatabase implements PersonDatabase {
    private final Object lock = new Object();

    private final Map<Integer, Person> persons = new HashMap<>();
    private final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    private final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    private final Map<String, Set<Integer>> phoneIndex = new HashMap<>();

    @Override
    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        synchronized (lock) {
            persons.put(person.id(), person);

            addToIndex(nameIndex, person.name(), person.id());
            addToIndex(addressIndex, person.address(), person.id());
            addToIndex(phoneIndex, person.phoneNumber(), person.id());
        }
    }

    @Override
    public void delete(int id) {
        synchronized (lock) {
            Person person = persons.get(id);
            if (person != null) {
                removeFromIndex(nameIndex, person.name(), id);
                removeFromIndex(addressIndex, person.address(), id);
                removeFromIndex(phoneIndex, person.phoneNumber(), id);
                persons.remove(id);
            }
        }
    }

    @Override
    @Nullable
    public Person findByName(String name) {
        synchronized (lock) {
            return findOneFromIndex(nameIndex, name);
        }
    }

    @Override
    @Nullable
    public Person findByAddress(String address) {
        synchronized (lock) {
            return findOneFromIndex(addressIndex, address);
        }
    }

    @Override
    @Nullable
    public Person findByPhone(String phone) {
        synchronized (lock) {
            return findOneFromIndex(phoneIndex, phone);
        }
    }

    private void addToIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new HashSet<>()).add(id);
    }

    private void removeFromIndex(Map<String, Set<Integer>> index, String key, int id) {
        Set<Integer> ids = index.get(key);
        if (ids != null) {
            ids.remove(id);
            if (ids.isEmpty()) {
                index.remove(key);
            }
        }
    }

    @Nullable
    private Person findOneFromIndex(Map<String, Set<Integer>> index, String key) {
        Set<Integer> ids = index.get(key);
        if (ids != null && !ids.isEmpty()) {
            int id = ids.iterator().next();
            return persons.get(id);
        }
        return null;
    }
}
