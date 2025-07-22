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
                options.addArguments("--window-size=1920,1080");
            }

            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");

            WebDriver instance = new ChromeDriver(options);
            instance.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10))
                    .pageLoadTimeout(Duration.ofSeconds(30));

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