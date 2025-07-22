package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (Boolean.getBoolean("headless")) {
                options.addArguments("--window-size=1920,1080"); // Tamanho fixo para headless
            } else {
                options.addArguments("--start-maximized"); // Maximiza em modo normal
            }

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            options.addArguments(
                    "--disable-save-password-bubble",
                    "--disable-notifications",
                    "--disable-infobars"
            );

            driver = new ChromeDriver(options);

            if (!Boolean.getBoolean("headless")) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}