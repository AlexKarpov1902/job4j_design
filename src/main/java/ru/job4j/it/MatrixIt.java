package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {

    private final int[][] data;
    private int row = 0;
    private int column = -1;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int c = column;
        int r = row;
        while (true) {
            if (data[r].length <= c + 1) {
                c = -1;
                r++;
            } else {
                return true;
            }
            if (data.length <= r) {
                return false;
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return getNext();
    }

    private Integer getNext() {
        if (data[row].length <= ++column) {
            column = -1;
            row++;
            return getNext();
        } else {
            return data[row][column];
        }
    }
}