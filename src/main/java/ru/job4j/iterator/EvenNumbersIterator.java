package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    int[] data;
    int point = -1;
    public EvenNumbersIterator(final int[] numbers) {
          this.data = numbers;
    }


    @Override
    public boolean hasNext() {
        int c = point;
        while (true) {
            c++;
            if ((c) > data.length - 1) {
                return false;
            }
            if (data[c] % 2 == 0) {
                return true;
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (true) {
            point++;
            if (data[point] % 2 == 0) {
                return data[point];
            }
        }
    }
}
