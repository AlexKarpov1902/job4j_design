package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
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

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getCenter() {
        return center;
    }

    public boolean isFool() {
        return fool;
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

        // библиотека json-java
        /* JSONObject из json-строки строки */
        JSONObject jsonPoint = new JSONObject("{\"x\":10,\"y\": 20}");

        /* JSONArray из ArrayList */
    /*    List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);*/

        /* JSONObject напрямую методом put */
        final Shape form10 = new Shape("Form1", 10, 15, new Point(5, 3), true);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", form10.getName());
        jsonObject.put("height", form10.getHeight());
        jsonObject.put("width", form10.getWidth());
        jsonObject.put("center", jsonPoint);
        jsonObject.put("fool", form10.isFool());

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект  в json-строку */
        System.out.println(new JSONObject(form10).toString());

    }
}


class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }
}