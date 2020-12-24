package ru.job4j.info;

import java.util.*;

public class Analize<User> {

    public Info diff(List<Analize.User> previous, List<Analize.User> current) {

        Info result = new Info();
        // создаем списки-сеты из List для быстрого поиска
        Set<Analize.User> setPrev = new HashSet<>(previous);
        Set<Analize.User> setCur = new HashSet<>(current);
        // Список-сет id previous
        Set<Integer> setIdPrev = new HashSet<>();
        previous.stream().forEach(user -> setIdPrev.add(user.getId()));
        // список-сет id current
        Set<Integer> setIdCur = new HashSet<>();
        current.stream().forEach(user -> setIdCur.add(user.getId()));

        for (Analize.User user : current) {
            if (!setPrev.contains(user)) {          // если нет в сете, значит добавлен или изменен
                if (!setIdPrev.contains(user.getId())) {   // если нет в сете id, значит добавлен, иначе изменен
                    result.added++;
                } else {
                    result.changed++;
                }
            }
        }
        for (Analize.User user : previous) {
            if (!setCur.contains(user)) {            // если нет в сете, значит удален или изменен
                if (!setIdCur.contains(user.getId())) {  // если нет в сете id, значит удален, иначе изменен( учтено выше)
                    result.deleted++;
                }
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