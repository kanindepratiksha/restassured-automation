package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            String env = System.getProperty("env", "qa");
            String fileName = "config-" + env + ".properties";

            InputStream input =
                    ConfigReader.class.getClassLoader()
                            .getResourceAsStream(fileName);

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
