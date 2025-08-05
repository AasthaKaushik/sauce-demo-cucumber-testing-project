
package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgetPasswordTest {

	@Given("I am on the login Page")
	public void i_am_on_the_login_page() {
		DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/account/login");
		PageFactory.getLoginPage().enterUsername("dhruv@gmail.com");
		PageFactory.getLoginPage().enterPassword("dhruv12345678");
	}

	@When("I clicks on the Forgot your password")
	public void i_clicks_on_the_forgot_your_password() {
		PageFactory.getForgetPasswordPage().clickForgetPasswordBtn();
	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
		PageFactory.getForgetPasswordPage().enterEmail("dhruv.aggarwal@gspann.com");
	}

	@Then("I am on the password reset page")
	public void i_am_on_the_password_reset_page() {
		String actualString = DriverFactory.getDriver().findElement(PageFactory.getForgetPasswordPage().checkForgetPageTitle()).getText();
		String expectedTitle = "Reset Password";
		Assert.assertEquals(actualString, expectedTitle);
	}

	@When("In email input field, enter a valid registered email address")
	public void in_email_input_field_enter_a_valid_registered_email_address() {
		PageFactory.getForgetPasswordPage().clearEmailField();
	}

	@Then("I get back to the login page")
	public void i_get_back_to_the_login_page() {
		PageFactory.getForgetPasswordPage().clickGetBackToHomePageBtn();
		String actualTitle = DriverFactory.getDriver().findElement(PageFactory.getForgetPasswordPage().checkLoginPageTitle()).getText();
		String expectedTitle = "Customer Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@When("In email input field, enter a invalid registered email address")
	public void in_email_input_field_enter_a_invalid_registered_email_address() {
		PageFactory.getForgetPasswordPage().clearEmailField();
		PageFactory.getForgetPasswordPage().enterEmail("dd.aa@gmail.com");
	}

	@Then("I will not get back to login page")
	public void i_will_not_get_back_to_login_page() {
		PageFactory.getForgetPasswordPage().verifyText();
	}

}
