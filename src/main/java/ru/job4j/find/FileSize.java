package ru.job4j.find;

import java.util.Objects;

class FileSize {
    private final String name;
    private final Long size;

    public FileSize(String name, Long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "FileSize{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileSize fileSize = (FileSize) o;
        return Objects.equals(name, fileSize.name)
                &&  Objects.equals(size, fileSize.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}