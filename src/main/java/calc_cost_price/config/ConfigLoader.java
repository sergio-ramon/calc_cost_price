package calc_cost_price.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    public static Properties load() {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("Config loader error " + e);
        }
    }
}
