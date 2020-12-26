package ru.job4j.info;

import java.util.*;

public class Analize {

    public Info diff(List<Analize.User> previous, List<Analize.User> current) {

        Info result = new Info();
        Map<Integer, Analize.User> mapPrev = new HashMap<>();
        previous.forEach(n -> mapPrev.put(n.id, n));
        Map<Integer, Analize.User> mapCur = new HashMap<>();
        current.forEach(n -> mapCur.put(n.id, n));

        for (Analize.User user : current) {
            if (!mapPrev.containsKey(user.id)) {          // если нет id, значит  добавлен
                result.added++;
            } else {
                if (!mapPrev.containsValue(user)) {      // если нет в мапе , значит изменен
                    result.changed++;
                }
            }
        }
        for (Analize.User user : previous) {
            if (!mapCur.containsKey(user.id)) {            // если нет id, значит  удален
                result.deleted++;
            }
        }
        return result;


    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "id=" + id
                    + ", name='" + name + '\''
                    + '}';
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info() {
            this.added = 0;
            this.changed = 0;
            this.deleted = 0;
        }

        @Override
        public String toString() {
            return "Information {"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }
    }


}