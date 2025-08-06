package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BreadcrumbNavigationToHomePageSteps {
	 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), java.time.Duration.ofSeconds(10));
	   @Given("I am on the About Us page")
	   public void i_am_on_the_about_us_page() {
	       DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/pages/about-us");

	   }
	   @When("I click on the Home in the breadcrumb")
	   public void i_click_on_the_home_in_the_breadcrumb() {
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@itemprop='title']"))).click();
	   }
	   @Then("I should be redirected to the Home page")
	   public void i_should_be_redirected_to_the_home_page() {
	       wait.until(ExpectedConditions.urlToBe("https://sauce-demo.myshopify.com/"));
	       String currentUrl = DriverFactory.getDriver().getCurrentUrl();
	       Assert.assertEquals("https://sauce-demo.myshopify.com/", currentUrl);
	   }
}
