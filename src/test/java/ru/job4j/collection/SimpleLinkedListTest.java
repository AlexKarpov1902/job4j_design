package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<String> linkList = new SimpleLinkedList<>();
        linkList.add("first");
        linkList.add("second");
        String rsl = linkList.get(1);
        assertThat(rsl, is("second"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<String> linkList = new SimpleLinkedList<>();
        linkList.add("first");
        linkList.add("second");
        Iterator<String> it = linkList.iterator();
        assertThat(it.next(), is("first"));
        assertThat(it.next(), is("second"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> linkList = new SimpleLinkedList<>();
        linkList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> linkList = new SimpleLinkedList<>();
        linkList.add("first");
        linkList.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> linkList = new SimpleLinkedList<>();
        linkList.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> linkList = new SimpleLinkedList<>();
        linkList.add("first");
        Iterator<String> it = linkList.iterator();
        linkList.add("second");
        it.next();
    }


}