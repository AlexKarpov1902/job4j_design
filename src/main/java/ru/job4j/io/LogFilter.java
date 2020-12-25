package ru.job4j.io;

import java.io.*;
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

    public static void save(List<String> log, String file) {
        try (
                PrintWriter pw = new PrintWriter(
                        new BufferedOutputStream(new FileOutputStream(file)))
        ) {
            log.forEach(n -> pw.write(n + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        //  log.stream().forEach(System.out::println);
        save(log, "404.txt");
        //  System.out.println(log);
    }
}