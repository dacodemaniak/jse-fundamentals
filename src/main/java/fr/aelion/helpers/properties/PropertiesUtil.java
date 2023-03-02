package fr.aelion.helpers.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private final static String PROPERTY_FILE = "application.properties";

    public Properties loadProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(PropertiesUtil.PROPERTY_FILE);

        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return properties;
    }
}
