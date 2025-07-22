package pages;

import elements.ProductsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private final ProductsElements elements;

    public ProductsPage(WebDriver driver) {
        this.elements = new ProductsElements(driver);
    }

    public void addProductToCart(String productName) {
        elements.products.stream()
                .filter(p -> p.getText().contains(productName))
                .findFirst()
                .ifPresent(p -> {
                    WebElement addButton = p.findElement(By.tagName("button"));
                    elements.waitForClickable(addButton).click();
                });
    }

    public void goToCart() {
        elements.waitForClickable(elements.cartIcon).click();
    }
}