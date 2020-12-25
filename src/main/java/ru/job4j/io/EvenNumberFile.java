package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("even.txt")) {
            int read;
            StringBuilder str = new StringBuilder();
            while ((read = fis.read()) != -1) {
                str.append((char) read);
            }
            String[] numbers = str.toString().split(System.lineSeparator());
            for (String s : numbers) {
                System.out.println(s + " - "
                        + (Integer.parseInt(s) % 2 == 0 ? "" : "НЕ") + "четное число");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}