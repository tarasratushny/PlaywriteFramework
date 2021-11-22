package com.dataload;

import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyLoader {
    private static final Logger logger = LogManager.getLogger(PropertyLoader.class.getSimpleName());
    private static final Properties properties = new Properties();

    public static String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }

    public static void loadProperties(){
        loadProperties("setup/default.properties");
    }

    public static void loadProperties(String filePath){
        logger.info("Trying to access property file: " + filePath);
        try (InputStream inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            properties.load(inputStream);
        } catch (Exception e) {
            logger.error("Property file with path: " + filePath + " cannot be opened");
        }
    }
}
