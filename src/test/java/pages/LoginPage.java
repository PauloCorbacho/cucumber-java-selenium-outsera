package pages;

import org.openqa.selenium.WebDriver;
import elements.LoginElements;

public class LoginPage {
    private final LoginElements elements;

    public LoginPage(WebDriver driver) {
        this.elements = new LoginElements(driver);
    }

    public void login(String username, String password) {
        elements.setUsername(username);
        elements.setPassword(password);
        elements.clickLogin();
    }
}