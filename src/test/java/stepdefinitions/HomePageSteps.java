package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	WebDriver driver;
    @Given("I open the browser")
    public void i_open_the_browser() {
       driver =  DriverFactory.getDriver();
    }
    @When("I navigate to the homepage url")
    public void i_navigate_to_the_homepage_url() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
    }
    @Then("the home page should load without error")
    public void the_home_page_should_load_without_error() {
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://sauce-demo.myshopify.com/"), "Homepage did not load correctly.");
    }
    @Then("the browser tab should display the correct title")
    public void the_browser_tab_should_display_the_correct_title() {
        String actualTitle = DriverFactory.getDriver().getTitle();
        String expectedTitle = "Sauce Demo"; // Update this if your tab title differs
        Assert.assertEquals(actualTitle, expectedTitle, "Browser tab title is incorrect.");
    }
}
