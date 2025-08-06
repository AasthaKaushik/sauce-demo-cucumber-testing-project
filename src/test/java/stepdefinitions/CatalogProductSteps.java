package stepdefinitions;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CatalogProductSteps {

    @Given("I am on the product detail page for Black Heels")
    public void i_am_on_the_product_detail_page_for_black_heels() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/collections/all");
    }

    @When("I click the Add to Cart button")
    public void i_click_the_add_to_cart_button() {
        PageFactory.getCatalogProductPage().navigateToProductPage();
        PageFactory.getCatalogProductPage().clickAddToCartButton();
    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(),
                "https://sauce-demo.myshopify.com/products/flower-print-jeans");
    }

    // 2 scenarios

    @Given("I am on the catalog page")
    public void i_am_on_the_catalog_page() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/collections/all");
    }

    @When("I click on a product marked SOLD OUT")
    public void i_click_on_a_product_marked_sold_out() {
        PageFactory.getCatalogProductPage().clickonBrownShadesProduct();
    }

    @Then("there should be SOLDOUT button must be disable")
    public void there_should_be_soldout_button_must_be_disable() {
        WebElement soldOutButton = PageFactory.getCatalogProductPage().getSoldOutDisable();
        Assert.assertFalse(soldOutButton.isEnabled());
    }
    @Given("I am on the Products Catalog page")
    public void i_am_on_the_products_catalog_page() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/collections/all");

    }

    @When("I click on the product Bronze Sandals")
    public void i_click_on_the_product_bronze_sandals() {
        PageFactory.getCatalogProductPage().clickOnSandals();

    }

    @Then("the price should be display of product sandals")
    public void the_price_should_be_display_of_product_sandals() {
        String sandalsprice = PageFactory.getCatalogProductPage().getBrownSandalsPrice();
        Assert.assertEquals(sandalsprice, "£39.99");

    }
}
