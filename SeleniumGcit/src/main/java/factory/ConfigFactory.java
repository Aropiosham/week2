package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFactory {
    private static Properties properties = new Properties();

    static {
        System.out.println("🔍 [ConfigFactory] static initializer start");
        try (InputStream inputStream =
                     ConfigFactory.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                System.err.println("❌ [ConfigFactory] config.properties NOT found in classpath!");
                throw new RuntimeException("config.properties file not found in classpath");
            }

            properties.load(inputStream);
            System.out.println("✅ [ConfigFactory] Loaded config.properties successfully");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to load config.properties file!", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("⚠️ [ConfigFactory] No value found for key: " + key);
        }
        return value;
    }
}
