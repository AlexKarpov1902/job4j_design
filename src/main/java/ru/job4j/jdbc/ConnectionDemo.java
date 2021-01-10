package ru.job4j.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("app.properties"));
        Class.forName(properties.getProperty("datasource.driverClassName"));
        String url = properties.getProperty("datasource.url");
        String login = properties.getProperty("datasource.login");
        String password = properties.getProperty("datasource.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}