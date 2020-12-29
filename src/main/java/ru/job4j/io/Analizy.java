package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> outLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            List<String> inLines = reader.lines().collect(Collectors.toList());
            String l = "";
            boolean isBegin = true;
            for (String s : inLines) {
                if (isBegin) {
                    if (s.startsWith("400") || s.startsWith("500")) {
                        l = s.split(" ")[1];
                        isBegin = !isBegin;
                    }
                } else {
                    if (s.startsWith("200") || s.startsWith("300")) {
                        l = l + ";" + s.split(" ")[1];
                        isBegin = !isBegin;
                        outLines.add(l);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
           outLines.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy an = new Analizy();
       an.unavailable("server.log", "serverout.log");

//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}