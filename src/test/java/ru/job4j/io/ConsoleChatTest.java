package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ConsoleChatTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenChat() throws IOException {
        File logFile = folder.newFile();
        File ansFile = folder.newFile();
        try (PrintWriter pw = new PrintWriter(new FileWriter(ansFile)))
        {
            Stream.of("OK","No","Yes","Don't worry","Be happy").forEach(pw::println);
        }

        ConsoleChat cc = new ConsoleChat(logFile.getAbsolutePath(), ansFile.getAbsolutePath());
        cc.run();
    }
}