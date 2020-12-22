package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleHashMapTest {
    private SimpleHashMap<String, String> simpleHashMap;

    @Before
    public void setUp()  {
        simpleHashMap = new SimpleHashMap<>();
    }

    @Test
    public void insertAndDelete() {
        simpleHashMap.insert("first", "первый");
        simpleHashMap.insert("second", "второй");
        simpleHashMap.insert("third", "третий");
        String s = simpleHashMap.get("third");
        assertThat(s, is("третий"));
        s = simpleHashMap.get("second");
        assertThat(s, is("второй"));
        assertTrue(simpleHashMap.delete("first"));
        assertNull(simpleHashMap.get("first"));
    }

    @Test
    public void insertAndInsert() {
        simpleHashMap.insert("first", "первый");
        simpleHashMap.insert("second", "второй");
        assertFalse(simpleHashMap.insert("first", "первый"));
    }

    @Test
    public void insertAndResize() {
        simpleHashMap.insert("first", "первый");
        simpleHashMap.insert("second", "второй");
        simpleHashMap.insert("third", "третий");
        simpleHashMap.insert("third1", "третий1");
        simpleHashMap.insert("third2", "третий2");
        simpleHashMap.insert("third3", "третий3");
        simpleHashMap.insert("third4", "третий4");
        simpleHashMap.insert("third5", "третий5");
        simpleHashMap.insert("third6", "третий6");
        simpleHashMap.insert("third7", "третий7");
        simpleHashMap.insert("third8", "третий8");
        simpleHashMap.insert("third9", "третий9");
        simpleHashMap.insert("third10", "третий10");
        simpleHashMap.insert("third11", "третий11");
       assertThat(simpleHashMap.getSize(), is(32));
    }

    @Test
    public void insertAndHasNext() {
        simpleHashMap.insert("first", "первый");
        simpleHashMap.insert("second", "второй");
        simpleHashMap.insert("third", "третий");
        Iterator<String> it;
        List<String> list = new ArrayList<>();
        for (it = simpleHashMap.iterator(); it.hasNext();) {
            list.add(simpleHashMap.get(it.next()));
         }
        assertTrue(list.contains("первый"));
        assertTrue(list.contains("второй"));
        assertTrue(list.contains("третий"));
    }

}