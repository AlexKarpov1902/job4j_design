package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    private MemStore<Role> mem;

    @Before
    public void setUp()  {
        mem = new MemStore<>();
        mem.add(new Role("1","Иван"));
        mem.add(new Role("2","Федор"));
        mem.add(new Role("3","Макс"));


    }
    @Test
    public void findById() {
        assertThat(mem.findById("1").getName(),is("Иван"));
        assertThat(mem.findById("3").getName(),is("Макс"));
    }

    @Test
    public void add() {


    }

    @Test
    public void testAdd() {
    }

    @Test
    public void replace() {
        mem.replace("2", new Role("2","Павел"));
        assertThat(mem.findById("2").getName(),is("Павел"));
    }

    @Test
    public void delete() {
        mem.delete("2");
        assertNull(mem.findById("2"));
      //  assertEquals();
    }


}