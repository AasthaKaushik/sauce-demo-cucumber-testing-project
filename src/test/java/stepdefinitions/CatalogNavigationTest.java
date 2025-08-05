package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogNavigationTest {
	
	@Given("I am on the Homepage")
	public void i_am_on_the_homepage() {
		DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
	}

	@When("I click on the Catalog")
	public void i_click_on_the_catalog() {
	    PageFactory.getCatalogPage().clickCatalog();
	}

	@Then("I should be redirected to the Catalog page")
	public void i_should_be_redirected_to_the_catalog_page() {
	    PageFactory.getCatalogPage().verifyCatalogPageTitle();
	    String actualTitle = DriverFactory.getDriver().findElement(PageFactory.getCatalogPage().verifyCatalogPageTitle()).getText();
	    String expectedTitle = "Products";
	    Assert.assertEquals(actualTitle, expectedTitle);
	}

}
