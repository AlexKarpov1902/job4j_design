package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int j = find(id);
        if (j != -1) {
            mem.set(j, model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int j = find(id);
        if (j != -1) {
            mem.remove(j);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        int j = find(id);
        if (j != -1) {
            return mem.get(j);
        } else {
            return null;
        }
    }

    /**
     * @param id
     * @return положение элемента в списке, иначе -1;
     */
    private int find(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}