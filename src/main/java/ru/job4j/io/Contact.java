package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String lastName;
    private final String phone;
    private final String email;
    private final int age;

    public Contact(String lastName, String phone, String email, int age) {
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "lastName='" + lastName + '\''
                + ", phone='" + phone + '\''
                + ", email='" + email + '\''
                + ", age=" + age
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact("Иванов",
                "+7 (111) 111-11-11",
                "ivanov@mail.ru", 33);

        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

        try (FileInputStream fis = new FileInputStream(tempFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            Contact contact1 = (Contact) ois.readObject();
            System.out.println(contact1);
        }
    }
}
