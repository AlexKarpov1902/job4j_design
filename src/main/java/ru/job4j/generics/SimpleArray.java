package ru.job4j.generics;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] data;
    private int size = 0;
    private final int capasity;

    public SimpleArray(int capasity) {
        if (capasity >= 0) {
            this.data = (T[]) new Object[capasity];
            this.capasity = capasity;
        } else {
            throw new IllegalArgumentException("Неправильный размер: " + capasity);
        }
    }

    public void add(T model) {
        size++;
        if (size > capasity) {
            throw new IndexOutOfBoundsException();
        }
        data[size - 1] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter(data);
    }

    private class Iter implements Iterator<T> {
        private final T[] arr;
        private int point = 0;

        public Iter(T[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public T next() {
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
        System.out.println(sa.get(0));
        System.out.println(sa.get(1));
        System.out.println(sa.get(2));
        System.out.println(sa.get(3));
    }
}