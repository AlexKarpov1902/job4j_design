package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArgZip {

    private final String[] args;
    private final Map<String, String> values = new HashMap<>();
    private List<Path> listFiles = new ArrayList<>();

    public ArgZip(String[] args) {
        this.args = args;
        valid();
    }

    public boolean valid() {
        if (args.length < 3) {
            throw new IllegalArgumentException("Недостаточное количество аргументов.");
        }
        for (String s: args) {
            String[] arg = s.split("=");
            if (arg[0].startsWith("-")) {
                values.put(arg[0].substring(1), arg[1]);
            }
        }
        File dir =  new File(directory());
        if (!dir.exists()) {
            throw new IllegalArgumentException("Указанный директорий не существует.");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Указанный директорий не существует.");
        }

        System.out.println(directory());
        System.out.println(exclude());
        System.out.println(output());

        return true;
    }

    public String directory() {
        return values.get("d");
    }

    public String exclude() {
        return values.get("e");
    }

    public String output() {
        return values.get("o");
    }

    public List<File> getListFiles() {
        Path dir = Paths.get(directory());
        SearchFiles search = new SearchFiles(n -> !n.toFile().getName().endsWith(exclude()));
        try {
            Files.walkFileTree(dir, search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        listFiles = search.getPaths();

        return listFiles.stream().map(Path::toFile).collect(Collectors.toList());

    }
}