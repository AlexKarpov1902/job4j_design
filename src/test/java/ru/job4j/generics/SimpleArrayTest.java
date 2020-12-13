package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    SimpleArray<String> array;

    @Test
    public void whenAddAndDelete() {
        array = new SimpleArray<>(5);
        array.add("Первый");
        array.add("Второй");
        array.add("Третий");
        array.add("Четвертый");
        array.remove(2);
        assertThat(array.get(0), is("Первый"));
        assertThat(array.get(1), is("Второй"));
        assertThat(array.get(2), is("Четвертый"));
    }

    @Test
    public void whenSet() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("Первый");
        array.add("Второй");
        array.add("Третий");
        array.set(1,"Пятый");
        assertThat(array.get(1), is("Пятый"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("Первый");
        array.add("Второй");
        array.add("Третий");
    }

    @Test
    public void whenAddThenIt() {
        array = new SimpleArray<>(5);
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        array = new SimpleArray<>(5);
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        array = new SimpleArray<>(5);
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        array = new SimpleArray<>(5);
        array.iterator().next();
    }

}