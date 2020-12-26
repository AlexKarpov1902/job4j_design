package ru.job4j.info;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {
    @Test
    public void whenAdd2Deleted1Changed1() {
        List<Analize.User> prev = new ArrayList<>();
        prev.add(new Analize.User(1, "Maxim"));
        prev.add(new Analize.User(2, "Peter"));
        prev.add(new Analize.User(3, "Don"));
        prev.add(new Analize.User(4, "Den"));
        prev.add(new Analize.User(5, "Boris"));
        prev.add(new Analize.User(6, "Andre"));
        System.out.println(prev);
        List<Analize.User> cur = new ArrayList<>(prev);

        cur.add(new Analize.User(7, "Kirill"));    // добавлено 2
        cur.add(new Analize.User(8, "Vasiliy"));

        cur.remove(new Analize.User(2, "Peter"));   // удален 1

        cur.remove(new Analize.User(3, "Don"));     // изменен 1
        cur.add(new Analize.User(3, "DonPedro"));

        System.out.println(cur);
        Analize analiz = new Analize();
        Analize.Info result = analiz.diff(prev, cur);
        System.out.println(result.toString());
        assertThat(result.added, is(2));
        assertThat(result.deleted, is(1));
        assertThat(result.changed, is(1));
    }


}