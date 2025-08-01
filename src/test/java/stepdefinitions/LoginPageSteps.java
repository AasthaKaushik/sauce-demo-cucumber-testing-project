package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	@Given("I am on the login page")
    public void i_am_on_the_login_page() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/account/login");
    }

    @When("I enter a valid email address and valid password")
    public void i_enter_a_valid_email_address_and_valid_password() {
        PageFactory.getLoginPage().enterUsername("aastha@abc.com");
        PageFactory.getLoginPage().enterPassword("Aastha123");
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        PageFactory.getLoginPage().clickSignInBtn();
    }

    @Then("I should be redirected to the account page")
    public void i_should_be_redirected_to_the_account_page() {
        WebDriver driver = DriverFactory.getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://sauce-demo.myshopify.com/"));
        String expectedUrl = "https://sauce-demo.myshopify.com";
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Expected: " + expectedUrl + ", but got: " + actualUrl);
        }
    }
}
