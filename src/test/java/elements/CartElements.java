package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartElements extends BaseElements{

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public CartElements(WebDriver driver) {
        super(driver);
    }
}