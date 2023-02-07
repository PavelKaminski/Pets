package kaminski.overone.pets.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static final String propFileName = "application.properties";
    public String getProperty(String key) {

        String propertyValue = null;
        try {
            Properties property = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream(propFileName);
            property.load(is);
            propertyValue = property.getProperty(key);
        } catch (IOException e) {
            System.err.println("properties file not found" + e);
        }
        return propertyValue;
    }
}
