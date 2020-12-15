package ru.job4j.collection;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class SimpleLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private SimpleLinkedList.Node<T> first;
    private SimpleLinkedList.Node<T> last;
    private int modCount = 0;

    void add(T e) {
        final SimpleLinkedList.Node<T> l = last;
        final SimpleLinkedList.Node<T> newNode = new SimpleLinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        SimpleLinkedList.Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.item;
    }
    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new SimpleLinkedList<T>.Iter();
    }

    private class Iter implements Iterator<T> {
        private SimpleLinkedList.Node<T> lastGet;
        private SimpleLinkedList.Node<T> next;
        private int index;
        private final int expectedModCount;

        public Iter() {
            this.lastGet = null;
            this.next = first.next;
            this.index = 0;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return index < size;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (index == 0) {
                lastGet = first;
                next = first.next;
            } else {
                lastGet = next;
                next = next.next;
            }
            index++;
            return lastGet.item;
        }
    }

    private static class Node<E> {
        E item;
        SimpleLinkedList.Node<E> next;
        SimpleLinkedList.Node<E> prev;

        Node(SimpleLinkedList.Node<E> prev, E element, SimpleLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<String> s = new SimpleLinkedList<>();
        s.add("Первый");
        s.add("Второй");
        s.add("третий");
        s.add("Четвертый");
        Iterator<String> it = s.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(s.get(0));
        System.out.println(s.get(1));
        System.out.println(s.get(2));
        System.out.println(s.get(3));
    }

}