package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> {
    SimpleArray<E> sa;

    public SimpleSet() {
        this.sa = new SimpleArray<>();
    }

    public boolean add(E e) {
        Iterator it = sa.iterator();
        while (it.hasNext()) {
            if (it.next().equals(e)) {
                return false;
            }
        }
        sa.add(e);
        return true;
    }

    public Iterator<E> iterator() {
        return sa.iterator();
    }
}
