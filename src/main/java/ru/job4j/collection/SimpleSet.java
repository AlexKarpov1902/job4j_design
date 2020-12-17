package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> {
    private final SimpleArray<E> sa;

    public SimpleSet() {
        this.sa = new SimpleArray<>();
    }

    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        sa.add(e);
        return true;
    }

    public boolean contains(E e) {
        Iterator<E> it = sa.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), e)) {
               return true;
            }
        }
        return false;
    }


    public Iterator<E> iterator() {
        return sa.iterator();
    }


}
