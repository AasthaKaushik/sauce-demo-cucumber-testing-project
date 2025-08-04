package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutUsNavigationTest {
	
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
	}

	@When("I click on the About Us from the side menu")
	public void i_click_on_the_about_us_from_the_side_menu() {
	   PageFactory.getAboutUsPage().clickAboutUs();
	}

	@Then("I should be redirected to the About Us page")
	public void i_should_be_redirected_to_the_about_us_page() {
	    PageFactory.getAboutUsPage().verifyAboutUsPageTitle();
	    String actualTitle = DriverFactory.getDriver().findElement(PageFactory.getAboutUsPage().verifyAboutUsPageTitle()).getText();
	    String expectedTitle = "About Us";
   		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
