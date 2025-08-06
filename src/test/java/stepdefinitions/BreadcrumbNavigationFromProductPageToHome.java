package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BreadcrumbNavigationFromProductPageToHome {
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), java.time.Duration.ofSeconds(10));
    @Given("I am on the {string} product page")
    public void i_am_on_the_product_page(String productName) {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/collections/frontpage/products/grey-jacket"); // Update URL if needed
    }
    @When("I click on the Frontpage link in the breadcrumb")
    public void i_click_on_the_frontpage_link_in_the_breadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Frontpage')]"))).click();
    }
    @And("I should be redirected to the Frontpage")
    public void i_should_be_redirected_to_the_frontpage() {
        wait.until(ExpectedConditions.urlToBe("https://sauce-demo.myshopify.com/collections/frontpage"));
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals("https://sauce-demo.myshopify.com/collections/frontpage", currentUrl);
    }
    @When("I click on the Home link in the breadcrumb")
    public void i_click_on_the_home_link_in_the_breadcrumb() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Home')]"))).click();
    }
    @Then("I should be redirected to the Home page from front page")
    public void i_should_be_redirected_to_the_home_page_from_front_page() {
        wait.until(ExpectedConditions.urlToBe("https://sauce-demo.myshopify.com/"));
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://sauce-demo.myshopify.com/");
    }
}
