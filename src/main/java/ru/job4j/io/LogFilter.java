package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().filter(n -> n.contains(" 404 ")).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.stream().forEach(System.out::println);
      //  System.out.println(log);
    }
}