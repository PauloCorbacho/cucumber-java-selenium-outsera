package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;
import setup.DriverManager;

import java.util.Map;

public class CheckoutSteps {
    private final WebDriver driver;
    private final ProductsPage productsPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public CheckoutSteps() {
        this.driver = DriverManager.getDriver();
        this.productsPage = new ProductsPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @When("I add product {string} to cart")
    public void i_add_product_to_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @When("I access the shopping cart")
    public void i_access_the_shopping_cart() {
        productsPage.goToCart();
    }

    @When("I begin the checkout process")
    public void i_begin_the_checkout_process() {
        cartPage.proceedToCheckout();
    }

    @When("I fill my information with:")
    public void i_fill_my_information_with(Map<String, String> dataTable) {
        checkoutPage.fillInformation(dataTable);
    }

    @When("I complete the purchase")
    public void i_complete_the_purchase() {
        checkoutPage.finishPurchase();
    }

    @Then("The purchase should be completed successfully")
    public void purchase_should_be_completed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @Then("I should see the message {string}")
    public void i_should_see_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, checkoutPage.getConfirmationMessage());
    }
}