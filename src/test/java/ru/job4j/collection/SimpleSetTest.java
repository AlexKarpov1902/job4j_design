package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddThenIt() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        set.add("second");
        String rsl = set.iterator().next();
        assertThat(rsl, is("first"));
        rsl = set.iterator().next();
        assertThat(rsl, is("second"));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> set = new SimpleSet<>();
        set.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        Iterator<String> it = set.iterator();
        set.add("second");
        it.next();
    }

}