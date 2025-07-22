package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginElements extends BaseElements{

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void setUsername(String username) {
        userName.sendKeys(username);
    }

    public void setPassword(String password) {
        userPassword.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public LoginElements(WebDriver driver) {
        super(driver);
    }
}
