package com.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class PropertiesLoader {

    final static Logger logger = Logger.getLogger(PropertiesLoader.class);

    public static Properties getProperties() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            property.load(fis);
        } catch (Exception e) {
            logger.error("The property file was not found: " + e.getMessage());
        }
        return property;
    }
}


