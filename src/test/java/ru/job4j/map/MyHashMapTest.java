package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MyHashMapTest {
    private MyHashMap<String, String> myHashMap;

    @Before
    public void setUp()  {
        myHashMap = new MyHashMap<>();
    }

    @Test
    public void insertAndDelete() {
        myHashMap.insert("first", "первый");
        myHashMap.insert("second", "второй");
        myHashMap.insert("third", "третий");
        String s = myHashMap.get("third");
        assertThat(s, is("третий"));
        s = myHashMap.get("second");
        assertThat(s, is("второй"));
        assertTrue(myHashMap.delete("first"));
        assertNull(myHashMap.get("first"));
    }

    @Test
    public void insertAndInsert() {
        myHashMap.insert("first", "первый");
        myHashMap.insert("second", "второй");
        assertFalse(myHashMap.insert("first", "первый"));
    }

    @Test
    public void insertAndResize() {
        myHashMap.insert("first", "первый");
        myHashMap.insert("second", "второй");
        myHashMap.insert("third", "третий");
        myHashMap.insert("third1", "третий1");
        myHashMap.insert("third2", "третий2");
        myHashMap.insert("third3", "третий3");
        myHashMap.insert("third4", "третий4");
        myHashMap.insert("third5", "третий5");
        myHashMap.insert("third6", "третий6");
        myHashMap.insert("third7", "третий7");
        myHashMap.insert("third8", "третий8");
        myHashMap.insert("third9", "третий9");
        myHashMap.insert("third10", "третий10");
        myHashMap.insert("third11", "третий11");
       assertThat(myHashMap.getSize(), is(32));
    }

    @Test
    public void insertAndHasNext() {
        myHashMap.insert("first", "первый");
        myHashMap.insert("second", "второй");
        myHashMap.insert("third", "третий");
        Iterator<String> it;
        List<String> list = new ArrayList<>();
        for (it = myHashMap.iterator(); it.hasNext();) {
            list.add(myHashMap.get(it.next()));
         }
        assertTrue(list.contains("первый"));
        assertTrue(list.contains("второй"));
        assertTrue(list.contains("третий"));
    }

}