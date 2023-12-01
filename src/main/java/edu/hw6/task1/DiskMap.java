package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final File file;
    private final Map<String, String> map = new HashMap<>();

    public DiskMap(File file) throws IOException {
        this.file = file;
        load();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(String key, String value) {
        map.put(key, value);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String remove(Object key) {
        String value = map.remove(key);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    @Override
    public void putAll(@NotNull final Map<? extends String, ? extends String> m) {
        map.putAll(m);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        map.clear();
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public @NotNull Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public @NotNull Collection<String> values() {
        return map.values();
    }

    @Override
    public @NotNull Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String getOrDefault(final Object key, final String defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(final BiConsumer<? super String, ? super String> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(final BiFunction<? super String, ? super String, ? extends String> function) {
        Map.super.replaceAll(function);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    @Override
    public String putIfAbsent(final String key, final String value) {
        map.putIfAbsent(key, value);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    @Override
    public boolean remove(final Object key, final Object value) {
        boolean res = map.remove(key, value);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public boolean replace(final String key, final String oldValue, final String newValue) {
        boolean res = map.replace(key, oldValue, newValue);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Nullable
    @Override
    public String replace(final String key, final String value) {
        String res = map.replace(key, value);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String computeIfAbsent(
        final String key,
        @NotNull final Function<? super String, ? extends String> mappingFunction
    ) {
        String res = map.computeIfAbsent(key, mappingFunction);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String computeIfPresent(
        final String key,
        @NotNull final BiFunction<? super String, ? super String, ? extends String> remappingFunction
    ) {
        String res = map.computeIfPresent(key, remappingFunction);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String compute(
        final String key,
        @NotNull final BiFunction<? super String, ? super String, ? extends String> remappingFunction
    ) {
        String res = map.compute(key, remappingFunction);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String merge(
        final String key,
        @NotNull final String value,
        @NotNull final BiFunction<? super String, ? super String, ? extends String> remappingFunction
    ) {
        String res = map.merge(key, value, remappingFunction);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private void load() throws IOException {
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        map.put(parts[0], parts[1]);
                    }
                }
            }
        }
    }

    private void save() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Entry<String, String> entry : map.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
