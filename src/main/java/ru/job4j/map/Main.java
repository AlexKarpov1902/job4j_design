package ru.job4j.map;

import java.util.*;



public class Main {

    public static void main(String[] args) {
        User user1 = new User("Михаил", 2, new GregorianCalendar(2001, Calendar.JANUARY, 25));
        User user2 = new User("Михаил", 2, new GregorianCalendar(2001, Calendar.JANUARY, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "First");
        map.put(user2, "Second");
        System.out.println(map.toString());
        System.out.println(map.get(user2));
        System.out.println(map.get(user1));

    }
}
