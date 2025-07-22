package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsElements extends BaseElements {
    @FindBy(className = "inventory_item")
    public List<WebElement> products;

    @FindBy(css  = ".shopping_cart_link")
    public WebElement cartIcon;

    public ProductsElements(WebDriver driver) {
        super(driver);
    }
}