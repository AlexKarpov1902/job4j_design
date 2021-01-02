package ru.job4j.io;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> listAnswers = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            br.lines().forEach(listAnswers::add);
        }
        Scanner in = new Scanner(System.in);
        Random nextAnswer = new Random();
        boolean isDialog = true;
        System.out.println("ВВедите текст:");
        String s = in.nextLine();
        String ss;
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            while (!s.equals(OUT)) {
                if (s.equals(STOP)) {
                    isDialog = false;
                }
                if (s.equals(CONTINUE)) {
                    isDialog = true;
                }
                if (isDialog) {
                    ss = listAnswers.get(nextAnswer.nextInt(listAnswers.size()));
                    System.out.println(ss);
                    pw.println(ss);
                }
                s = in.nextLine();
                pw.println(s);
            }
        }
    }

    public static void main(String[] args) throws IOException {
       ConsoleChat cc = new ConsoleChat("dialog.log", "answers.txt");
       cc.run();
    }
}