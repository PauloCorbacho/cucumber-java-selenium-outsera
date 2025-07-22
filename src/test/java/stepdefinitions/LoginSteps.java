package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import setup.DriverManager;
import static org.junit.Assert.*;

public class LoginSteps {

    private WebDriver driver = DriverManager.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("I should see the home page")
    public void i_should_see_the_home_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
}