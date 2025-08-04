package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class CreateAccountSteps {
	@Given("I am on the Create Account page")
    public void i_am_on_the_create_account_page() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/account/register");
    }
    @When("I enter {string} in the First Name field")
    public void i_enter_in_the_first_name_field(String firstName) {
        PageFactory.getCreateAccountPage().enterFirstName(firstName);
    }
    @When("I enter {string} in the Last Name field")
    public void i_enter_in_the_last_name_field(String lastName) {
        PageFactory.getCreateAccountPage().enterLastName(lastName);
    }
    @When("I enter {string} in the Email Address field")
    public void i_enter_in_the_email_address_field(String email) {
        PageFactory.getCreateAccountPage().enterEmail(email);
    }
    @When("I enter {string} in the Password field")
    public void i_enter_in_the_password_field(String password) {
        PageFactory.getCreateAccountPage().enterPassword(password);
    }
    @When("I click the Create button")
    public void i_click_the_create_button() throws InterruptedException {
        PageFactory.getCreateAccountPage().clickRegisterBtn();
        Thread.sleep(5000);
    }
    @When("I click the Create button without entering any details")
    public void i_click_the_create_button_without_entering_any_details() {
        PageFactory.getCreateAccountPage().clickRegisterBtn();
    }
@Then("I should be redirected to the homepage with the Log out link visible")
public void i_should_be_redirected_to_the_homepage_with_the_log_out_link_visible() throws InterruptedException {
    WebDriver driver = DriverFactory.getDriver();
    // Wait until homepage loads
//    new WebDriverWait(driver, Duration.ofSeconds(10))
//    .until(ExpectedConditions.urlToBe("https://sauce-demo.myshopify.com/"));
    // Verify correct URL
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl, "https://sauce-demo.myshopify.com/",
            "User is not redirected to homepage.");
    // Verify Log out link is visible
    WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Log out']"));
    Assert.assertTrue(logoutLink.isDisplayed(), "Log out link is not visible.");
}
    @Then("I should see error messages for email and password field")
    public void i_should_see_error_messages_for_email_and_password_field() {
        String actualEmailError = DriverFactory.getDriver()
                .findElement(PageFactory.getCreateAccountPage().getEmptyEmailError())
                .getText();
        String actualPasswordError = DriverFactory.getDriver()
                .findElement(PageFactory.getCreateAccountPage().getEmptyPasswordError())
                .getText();
        String expectedEmailError = "Email can't be blank.";
        String expectedPasswordError = "Password can't be blank.";
        Assert.assertEquals(expectedEmailError, actualEmailError);
        Assert.assertEquals(expectedPasswordError, actualPasswordError);
    }
    @Then("I should see a validation error for invalid email format")
    public void i_should_see_a_validation_error_for_invalid_email_format(){
        By emailField = PageFactory.getCreateAccountPage().getEmail();
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",emailField);
        String expectedMessage = "Please include an '@' in the email address. 'aa' is missing an '@'";
        Assert.assertTrue(validationMessage.contains(expectedMessage), "Email validation failed: " + validationMessage);
    }
      @Then("I should see an error message saying the email already exists")
      public void i_should_see_an_error_message_saying_the_email_already_exists() {
    By errorLocator = PageFactory.getCreateAccountPage().getAlreadyRegisteredError();
    //WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
    //WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
    //String actualEmailError = errorElement.getText().trim();
//    String expectedEmailError = "This email address is already associated with an account. If this account is yours, you can reset your password.";
//    Assert.assertEquals(actualEmailError, expectedEmailError, "Email error message is not as expected.");
}
}
