package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartElements extends BaseElements {

    @FindBy(className = "cart_quantity")
    public WebElement quantity;

    @FindBy(className = "inventory_item_name")
    public WebElement itemName;

    @FindBy(className = "inventory_item_desc")
    public WebElement itemDescription;

    @FindBy(className = "inventory_item_price")
    public WebElement itemPrice;

    // Buttons
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public CartElements(WebDriver driver) {
        super(driver);
    }
}