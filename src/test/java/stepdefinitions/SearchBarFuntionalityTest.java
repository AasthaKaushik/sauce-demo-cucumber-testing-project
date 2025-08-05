package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBarFuntionalityTest {
	
	@Given("I am on the HomePage")
	public void i_am_on_the_home_page() {
	    DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
	}

	@Then("I should see the search bar")
	public void i_should_see_the_search_bar() {
	    PageFactory.getSearchBar().checkSearchField();
	}

	@Then("The search bar should be clickable")
	public void the_search_bar_should_be_clickable() {
		PageFactory.getSearchBar().searchBarClickable();
	}

	@When("I enter a valid product keyword like {string} in the search bar")
	public void i_enter_a_valid_product_keyword_like_in_the_search_bar(String string) {
	    PageFactory.getSearchBar().enterProductName(string);
	}

	@When("I click on the search icon")
	public void i_click_on_the_search_icon() {
	    PageFactory.getSearchBar().clickSearchIconBtn();
	}

	@Then("I should see products related to the keyword jacket")
	public void i_should_see_products_related_to_the_keyword_jacket() {
		String actualItemTxt = DriverFactory.getDriver().findElement(PageFactory.getSearchBar().searchedItemTxt()).getText();
	    String expectedtxt = "jacket";
	    Assert.assertEquals(actualItemTxt, expectedtxt);
	}

	@When("I enter an invalid or random keyword like {string} in the search bar")
	public void i_enter_an_invalid_or_random_keyword_like_in_the_search_bar(String string) {
	    PageFactory.getSearchBar().enterProductName(string);
	}

	@When("I press the Enter key or click on the search icon")
	public void i_press_the_enter_key_or_click_on_the_search_icon() {
		 PageFactory.getSearchBar().clickSearchIconBtn();
	}

	@Then("system should display message like No results found")
	public void system_should_display_message_like_no_results_found() {
		String actualItemTxt = DriverFactory.getDriver().findElement(PageFactory.getSearchBar().verifyRandomItemTxt()).getText();
	    String expectedtxt = "xyz";
	    Assert.assertEquals(actualItemTxt, expectedtxt);
	}

}
