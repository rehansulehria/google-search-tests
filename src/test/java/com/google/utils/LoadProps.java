package com.google.utils;

import java.io.IOException;
import java.util.Properties;

public class LoadProps {
     private Properties props = new Properties();

    public String getProperty(String key) throws IOException {
        props.load(this.getClass().getClassLoader()
                .getResourceAsStream("test.properties")); // Load the properties file
        return props.getProperty(key);
    }
}
