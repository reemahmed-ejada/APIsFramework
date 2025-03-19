package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
        private static Properties properties;

        static {
            try (FileInputStream fileInputStream = new FileInputStream("src/test/Resources/config.properties")) {
                properties = new Properties();
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getBaseUrl() {
            return properties.getProperty("baseUrl");
        }


}
