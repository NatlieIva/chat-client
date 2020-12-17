package ru.itsjava.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private static Properties props;

    public static String getValue(String key) throws IOException {
        InputStream resourceAsStream = Settings.class.getClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();
        props.load(resourceAsStream);
        return props.getProperty(key);
    }
}
