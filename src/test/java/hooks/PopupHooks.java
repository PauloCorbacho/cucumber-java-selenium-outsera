package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import setup.DriverManager;

public class PopupHooks {

    private WebDriver driver;

    @Before(order = 10)
    public void setup() {
        driver = DriverManager.getDriver();
        blockPasswordPopups();
    }

    @BeforeStep
    public void beforeStep() {
        dismissAnyPopup();
    }

    private void blockPasswordPopups() {
        ((JavascriptExecutor)driver).executeScript(
                "Object.defineProperty(navigator, 'credentials', {" +
                        "  get: () => ({ preventSilentAccess: () => {} })" +
                        "});");
    }

    private void dismissAnyPopup() {
        try {
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
        }
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }
}