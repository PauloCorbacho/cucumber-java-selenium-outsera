package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (Boolean.getBoolean("headless")) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            options.addArguments("--password-store=basic");
            options.addArguments("--disable-features=PasswordManager");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--remote-allow-origins=*");

            WebDriver instance = new ChromeDriver(options);
            instance.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(5))
                    .pageLoadTimeout(Duration.ofSeconds(15));

            threadLocalDriver.set(instance);
        }
        return threadLocalDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error while closing the browser: " + e.getMessage());
            } finally {
                threadLocalDriver.remove();
            }
        }
    }

    public static void setup() {
        getDriver();
    }

    public static void teardown() {
        quitDriver();
    }

    public static void closeAllDrivers() {
        quitDriver();
    }
}