package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(n -> (!n.isEmpty() && !n.startsWith("#")))
                    .forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] array;
        for (String s : list) {
            array = s.split("=");
            if (array.length == 2) {
                values.put(array[0], array[1]);
            }
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
       System.out.println(new Config("app.properties"));
    }
}