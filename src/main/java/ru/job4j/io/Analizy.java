package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> outLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            String l = "";
            boolean isBegin = true;
            while ((s = reader.readLine()) != null) {
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

    }
}