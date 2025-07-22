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

    public int getItemQuantity() {
        return Integer.parseInt(elements.quantity.getText());
    }

    public String getItemName() {
        return elements.itemName.getText();
    }

    public String getItemDescription() {
        return elements.itemDescription.getText();
    }

    public String getItemPrice() {
        return elements.itemPrice.getText();
    }

    public boolean isRemoveButtonVisible() {
        return elements.removeButton.isDisplayed();
    }

    public boolean isContinueShoppingButtonVisible() {
        return elements.continueShoppingButton.isDisplayed();
    }

    public boolean isCheckoutButtonVisible() {
        return elements.checkoutButton.isDisplayed();
    }
}