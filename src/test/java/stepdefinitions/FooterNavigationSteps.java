package stepdefinitions;


import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FooterNavigationSteps {

	@Given("I open the homepage")
    public void openHomepage() {
DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
    }
 
    @Then("Footer should be visible")
    public void footerShouldBeVisible() {
        Assert.assertTrue(
            PageFactory.getFooterPage().isFooterVisible(),
            "Footer is not visible on the homepage"
        );
    }
 
    @Then("Search link should be clickable")
    public void searchLinkShouldBeClickable() {
        Assert.assertTrue(
            PageFactory.getFooterPage().isSearchLinkClickable(),
            "Search link is not clickable"
        );
    }
 
    @Then("About Us link should be clickable")
    public void aboutUsLinkShouldBeClickable() {
        Assert.assertTrue(
            PageFactory.getFooterPage().isAboutUsLinkClickable(),
            "About Us link is not clickable"
        );
    }
 
}


