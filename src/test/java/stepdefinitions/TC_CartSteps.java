package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_CartSteps {

	// BackGrround
	@Given("user Is on the home page")
	public void user_is_on_home_page() {
		PageFactory.getCartPage().goToHomePage();
	}

	// Scenario 1: View empty cart message
	@When("user clicks on the cart")
	public void user_clicks_on_cart() {
		PageFactory.getCartPage().clickCartIcon();
	}

	@Then("user should see message {string}")
	public void user_should_see_message(String expectedMessage) {
		String actualMessage = PageFactory.getCartPage().getEmptyCartMessage();
		assertEquals(actualMessage.trim(), expectedMessage.trim());
	}

	// Scenario 2: Add Grey Jacket from homepage
	@When("user clicks on the Grey Jacket image")
	public void user_clicks_grey_jacket() {
		PageFactory.getCartPage().clickGreyJacketImage();
	}

	@And("clicks \"Add to cart\"")
	public void clicks_add_to_cart() throws InterruptedException {
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);

	}

	@Then("verify product is added to cart")
	public void verify_product_added() {
		PageFactory.getCartPage().goToCartPage();
		Assert.assertTrue(PageFactory.getCartPage().isGreyJacketInCart(), "Grey Jacket should be in the cart");
	}

	// Scenario 3: Verify navigation to Noir Jacket page
	@When("user click the Noir Jacket image")
	public void user_clicks_noir_jacket() {
		PageFactory.getCartPage().clickNoirJacketImage();
	}

	@Then("Correct product page is displayed")
	public void correct_product_page_displayed() {
		Assert.assertEquals(PageFactory.getCartPage().isNoirJacketURL(),
				"https://sauce-demo.myshopify.com/collections/frontpage/products/noir-jacket");
	}

	// Scenario 4: Add multiple products
	@When("I add Grey Jacket and then add Striped Top")
	public void i_add_two_products() throws InterruptedException {
		PageFactory.getCartPage().clickGreyJacketImage();
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);
		PageFactory.getCartPage().goToHomePage();
		PageFactory.getCartPage().clickStripedTopImage();
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);

	}

	@Then("Cart contains Two different products")
	public void cart_has_two_products() throws InterruptedException {
		PageFactory.getCartPage().goToCartPage();
		Thread.sleep(3000);
		assertTrue(PageFactory.getCartPage().isGreyJacketInCart(), "Grey Jacket should be in cart");
		assertTrue(PageFactory.getCartPage().isStripedTopInCart(), "Striped Top should be in cart");
	}

	// Scenario 5: Quantity update when same product added twice
	@When("I add Noir Jacket twice")
	public void i_add_noir_twice() throws InterruptedException {
		PageFactory.getCartPage().clickNoirJacketImage();
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);
		PageFactory.getCartPage().clickAddToCart();

	}

	@Then("Cart should show quantity = two")
	public void cart_quantity_two() throws InterruptedException {
		PageFactory.getCartPage().goToCartPage();
		Thread.sleep(3000);
		assertEquals(PageFactory.getCartPage().getCartItemCount2(), 2);
	}

	// Scenario 6: Verify cart retains items
	@When("User add Striped Top to cart and navigate away then return")
	public void user_adds_and_navigates_away() throws InterruptedException {
		PageFactory.getCartPage().clickStripedTopFromAllSection();
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);
		PageFactory.getCartPage().goToAllProductsPage();
		PageFactory.getCartPage().goToCartPage();
	}

	@Then("Item should be present in cart")
	public void item_present_in_cart() {
		assertTrue(PageFactory.getCartPage().isStripedTopInCart(), "Striped Top should remain in cart");
	}

	// Scenario 7: Cart icon shows count
	@When("User adds Nior Jacket to cart")
	public void user_adds_nior_jacket_to_cart() throws InterruptedException {
		PageFactory.getCartPage().clickNoirJacketImage();
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);
	}

	@And("User checks the cart")
	public void user_checks_the_cart() throws InterruptedException {
		PageFactory.getCartPage().getCartItemCount();

	}

	@Then("Item count should update")
	public void item_count_should_update() {
		Assert.assertEquals(PageFactory.getCartPage().getCartItemCount(), 1);
	}

	// Scenario 8: Remove button in cart
	@When("user adds Grey Jacket to the cart")
	public void user_adds_grey_jacket_to_cart() {
		PageFactory.getCartPage().clickGreyJacketImage();
//        PageFactory.getCartPage().clickAddToCart();
	}

	@And("user clicks on the cart icon")
	public void user_clicks_on_cart_icon() throws InterruptedException {
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);
		PageFactory.getCartPage().clickCartIcon();
	}

	@And("user removes the product from the cart")
	public void user_removes_the_product_from_the_cart() {
		PageFactory.getCartPage().clickRemoveButton();
	}

	@Then("the cart should be empty and product count should be zero")
	public void the_cart_should_be_empty_and_product_count_should_be_zero() {
		assertEquals(PageFactory.getCartPage().getEmptyCartMessage(), "Your cart is empty.");
		// assertEquals(PageFactory.getCartPage().getCartItemCount(),0);
	}

	// Scenario 9:Checkout button in cart

	@When("user adds a product to the cart")
	public void user_adds_a_product_to_the_cart() throws InterruptedException {
		PageFactory.getCartPage().clickGreyJacketImage();
		PageFactory.getCartPage().clickAddToCart();
		Thread.sleep(3000);

	}

	@And("user clicks on the CartIcon")
	public void user_navigates_to_the_cart_page() throws InterruptedException {
		PageFactory.getCartPage().clickCartIcon();

	}

	@When("user clicks on the Checkout button")
	public void user_clicks_on_the_checkout_button() {
		PageFactory.getCartPage().clickCheckoutButton();
	}

	@Then("user should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("sauce-demo.myshopify.com"));
	}

}
