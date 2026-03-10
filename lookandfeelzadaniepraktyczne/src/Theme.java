import java.io.*;
import java.util.Properties;

public class Theme {

    private static final String CONFIG_FILE = "config.properties.properties";
    private static final String THEME_KEY = "theme";

    public static String loadTheme() {
        Properties prop = new Properties();

        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            prop.load(fis);
            return prop.getProperty(THEME_KEY, "light");
        } catch (IOException e) {
            return "light";
        }
    }

    public static void saveTheme(String theme) {
        Properties prop = new Properties();
        prop.setProperty(THEME_KEY, theme);

        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            prop.store(fos, "Application settings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}