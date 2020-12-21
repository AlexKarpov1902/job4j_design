package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyHashMap<K, V> {

    private Object[] array;
    private int size;
    private final float loadFactor;
    private int count;
    private int resizeCondition;
    private int modCount = 0;

    public MyHashMap() {
        this.size = 16;
        this.loadFactor = 0.75f;
        this.array = new Object[size];
        this.count = 0;
        this.resizeCondition = (int) (size * loadFactor);
    }

    public boolean insert(K key, V value) {
        Node<K, V> node = new Node<>(Objects.hashCode(key), key, value);
        int i = hash(node.hash);
        if (array[i] != null) {
            return false;
        }
        array[i] = node;
        count++;
        if (count > resizeCondition) {
            resize();
        }
        return true;
    }

    public V get(K key) {
        int i = hash(Objects.hashCode(key));
        if (array[i] == null) {
            return null;
        }
        Node<K, V> node = (Node<K, V>) array[i];
        return node.getValue();
    }

    public boolean delete(K key) {
        int i = hash(Objects.hashCode(key));
        if (array[i] == null) {
            return false;
        }
        array[i] = null;
        count--;
        return true;
    }

    public int getSize() {
        return this.size;
    }

    private int hash(int hash) {
        return Math.abs(hash % size);
    }

    private void resize() {
        int oldSize = size;
        size = size * 2;
        Object[] oldArray = array;
        array = new Object[size];
        Node<K, V> node;
        int j;
        for (int i = 0; i < oldSize; i++) {
            if (oldArray[i] != null) {
                node = (Node<K, V>) oldArray[i];
                j = hash(node.hash);
                array[j] = node;
                System.out.println(node.key + " " + node.value);
            }
        }
    }


    public Iterator<K> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<K> {
        private int point = 0;
        private final int expectedModCount;
        private int index = 0;

        public Iter() {
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return point < count;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            while (array[index] == null) {
                index++;
            }
            point++;
            Node<K, V> node = (Node<K, V>) array[index];
            index++;
            return node.getKey();
        }
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}
