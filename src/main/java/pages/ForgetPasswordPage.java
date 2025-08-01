package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class ForgetPasswordPage {
	private final By FORGET_PASSWORD_BTN = By.linkText("Forgot your password?");
	private final By EMAIL_FIELD = By.id("recover-email");
	
	public void clickForgetPasswordBtn() {
		DriverFactory.getDriver().findElement(FORGET_PASSWORD_BTN);
	}
	
	public void emailField() {
		DriverFactory.getDriver().findElement(EMAIL_FIELD);
	}
}
