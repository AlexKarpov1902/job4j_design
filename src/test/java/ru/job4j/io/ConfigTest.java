package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenWorkProperties() {
        String path = "app.properties";
        Config config = new Config(path);
        config.load();
        System.out.println(config.toString());
        assertThat(config.value("app.password1"), is("password2"));
        assertThat(config.value("spring.h2.console.path"), is("/h2"));
    }

}