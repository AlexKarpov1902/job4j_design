package ru.job4j.collection;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }
    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        Node<T> last = tail;
        while (tail.next != null) {
            last = tail;
            tail = tail.next;
        }
        last.next = null;
        return tail.value;
    }


    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> n = head;
        head = head.next;
        return n.value;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}