package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartElements extends BaseElements{

    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemNames;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    @FindBy(css = ".cart_quantity")
    public List<WebElement> itemQuantities;

    @FindBy(css = ".btn_secondary.cart_button")
    public List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(css  = ".shopping_cart_link")
    public WebElement cartIcon;

    @FindBy(className = "cart_quantity")
    public WebElement cartBadge;

    public CartElements(WebDriver driver) {
        super(driver);
    }
}