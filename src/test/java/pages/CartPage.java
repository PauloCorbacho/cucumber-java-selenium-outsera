package pages;

import elements.CartElements;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final CartElements elements;

    public CartPage(WebDriver driver) {
        this.elements = new CartElements(driver);
    }

    public void proceedToCheckout() {
        elements.waitForClickable(elements.checkoutButton).click();
    }
}