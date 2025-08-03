package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailNavigationTest {
	
	@Given("I am on the homePage")
	public void i_am_on_the_home_page() {
		DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
	}

	@When("I click on a product like Grey jacket")
	public void i_click_on_a_product_like_grey_jacket() {
	   PageFactory.getProductDetailPage().clickProduct();
	}


	@Then("I should be redirected to the product detail page")
	public void i_should_be_redirected_to_the_product_detail_page() {
	    PageFactory.getProductDetailPage().verifyProductTitle();
	    String actualProductTitle = DriverFactory.getDriver().findElement(PageFactory.getProductDetailPage().verifyProductTitle()).getText();
		String expectedProductTitle = "Grey jacket";
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
	}


}
