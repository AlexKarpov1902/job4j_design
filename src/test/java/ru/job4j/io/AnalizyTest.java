package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void when() {
        Analizy an = new Analizy();
        an.unavailable("server.log", "serverout.log");
        List<String> testList = new ArrayList<>();
        testList.add("10:58:01;10:59:01");
        testList.add("11:01:02;11:04:02");
        testList.add("11:05:02;11:07:02");

        try (BufferedReader reader = new BufferedReader(new FileReader("serverout.log")))
        {
            List<String> l = reader.lines().collect(Collectors.toList());
            assertTrue(l.containsAll(testList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}