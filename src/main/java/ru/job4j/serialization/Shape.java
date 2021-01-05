package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class Shape implements Serializable {
private final String name;
private final int height;
private final int width;
private final Point center;
private final boolean fool;

    public Shape(String name, int height, int width, Point center, boolean fool) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.center = center;
        this.fool = fool;
    }

    @Override
    public String toString() {
        return "Shape{"
                + "name='" + name + '\''
                + ", height=" + height
                + ", width=" + width
                + ", center=" + center
                + ", fool=" + fool
                + '}';
    }

    public static void main(String[] args) {
        final Shape form1 = new Shape("Form1", 10, 15, new Point(5, 3), true);

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(form1));

        /* Модифицируем json-строку */
        final String formJSON =
                "{\"name\":\"Form2\","
                        + "\"height\":30,"
                        + "\"width\":20,"
                        + "\"center\":{\"x\":10,\"y\":10},"
                        + "\"fool\":false}";

        final Shape form2 = gson.fromJson(formJSON, Shape.class);
        System.out.println(form2);
    }
}


class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }
}