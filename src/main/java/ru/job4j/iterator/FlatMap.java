package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
        this.cursor = (data.hasNext()) ? data.next() : null;
    }

    @Override
    public boolean hasNext() {
        if (cursor == null) {
            return false;
        }
        while (true) {
            if (cursor.hasNext()) {
                return true;
            } else {
                if (data.hasNext()) {
                    this.cursor = data.next();
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    private Boolean isHasNext() {
        if (cursor.hasNext()) {
            return true;
        } else {
            if (data.hasNext()) {
                this.cursor = data.next();
                return isHasNext();
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }

}