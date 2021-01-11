package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void when() throws IOException {

        File in = folder.newFile("server.log");
        try (PrintWriter pw = new PrintWriter(in)) {
            Stream.of(
                    "200 10:56:01",
                    "200 10:57:01",
                    "400 10:58:01",
                    "200 10:59:01",
                    "500 11:01:02",
                    "400 11:02:02",
                    "500 11:03:02",
                    "200 11:04:02",
                    "400 11:05:02",
                    "500 11:06:02",
                    "200 11:07:02",
                    "200 11:08:02").forEach(pw::println);
        }
        File out = folder.newFile("serverout.log");
        Analizy an = new Analizy();
        an.unavailable(in.getAbsolutePath(), out.getAbsolutePath());
        List<String> testList = new ArrayList<>();
        testList.add("10:58:01;10:59:01");
        testList.add("11:01:02;11:04:02");
        testList.add("11:05:02;11:07:02");

        try (BufferedReader reader = new BufferedReader(new FileReader(out))) {
            List<String> l = reader.lines().collect(Collectors.toList());
            assertTrue(l.containsAll(testList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}