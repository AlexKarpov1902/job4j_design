package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(("Таблица умножения " + System.lineSeparator()).getBytes());
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    String s = "  " + i + " * " + j + " = " + (j * i) + System.lineSeparator();
                    out.write(s.getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}