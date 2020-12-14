package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private  T[] data;
    private int size = 0;
    private int capacity;
    private int modCount;

    public SimpleArray(int capacity) {
        if (capacity >= 0) {
            this.data = (T[]) new Object[capacity];
            this.capacity = capacity;
            this.modCount = 1;
        } else {
            throw new IllegalArgumentException("Неправильный размер: " + capacity);
        }
    }
    public SimpleArray() {
       this (10);
    }



    public void add(T model) {
        size++;
        if (size > capacity) {
            grow();
        }
        data[size - 1] = model;
        modCount++;
    }

    private void grow() {
        int capacityNew = capacity + 10;
        T[] dataNew = (T[]) new Object[capacityNew];
        System.arraycopy(data, 0, dataNew, 0, capacity);
        data = dataNew;
        capacity = capacityNew;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        data[index] = model;
        modCount++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArray.Iter(data);
    }

    private class Iter implements Iterator<T> {
        private final T[] arr;
        private int point = 0;
        private final int expectedModCount;

        public Iter(T[] arr) {
            this.arr = arr;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return point < size;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return arr[point++];
        }
    }


    public static void main(String[] args) {
       SimpleArray<String> sa = new SimpleArray<>(10);
        sa.add("Первый");
        sa.add("Второй");
        sa.add("Третий");
        sa.add("Четвертый");
        sa.add("Пятый");
        sa.add("Шестой");
        sa.add("Седьмой");
        sa.add("Восьмой");
        sa.add("Девятый");
        sa.add("Десятый");
        sa.add("Одиннадцатый");
        System.out.println(sa.get(0));
        System.out.println(sa.get(9));
        System.out.println(sa.get(10));

    }
}