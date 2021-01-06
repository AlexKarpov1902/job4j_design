package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Consumer;

public class FindDuplicates implements FileVisitor<Path> {

    Consumer<Path> consumer;

    public FindDuplicates(Consumer<Path> consumer) {
        this.consumer = consumer;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        consumer.accept(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)  {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)  {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar FindDuplicates.jar ROOT_FOLDER.\"");
        }
        String rootDir = args[0];
        if (!Paths.get(rootDir).toFile().isDirectory()) {
            throw new IllegalArgumentException("Root folder is not exist. Usage java -jar FindDuplicates.jar ROOT_FOLDER.\"");
        }
        Map<FileSize, File> dbFiles = new HashMap<>();
        List<File> listDub = new ArrayList<>();

        Consumer<Path> createDbFiles = n ->  {
            File f = dbFiles.putIfAbsent(
                    new FileSize(n.getFileName().toString(), n.toFile().length()),
                    n.toFile());
    //        if ((f != null) && (f.length() > 10000000)) {
            if (f != null)  {
                listDub.add(f);
                listDub.add(n.toFile());
            }
        };

        FileVisitor<Path> findDub = new FindDuplicates(createDbFiles);
        Files.walkFileTree(Paths.get(rootDir), findDub);

   /*     for (FileSize fs :dbFiles.keySet()) {
            System.out.println(fs);
        }*/
        System.out.println("------------Дубликаты файлов--------------");
        listDub.forEach(n -> System.out.println(n + " " + n.length()));
    }
}

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
