package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;

public class ForgetPasswordPage {

	private final By FORGET_PASSWORD_BTN = By.xpath("//p//following::a[contains(text(),'Forgot your password?')]");
	private final By EMAIL_FIELD = By.xpath("//input[@id='recover-email']");
	private final By SUBMIT_BTN = By.xpath("//div[@class='action_bottom']//following::input[@value='Sign In']");
	private final By GET_BACK_TO_HOMEPAGE_BTN = By.linkText("Login");
	private final By FORGET_PASSWORD_TITLE = By.xpath("//h1[@class='accounts-title border bottom']");
	private final By VERIFY_TEXT = By.xpath("//p[contains(text(),'We will send you an email to reset your password.')]");
	
	public void clickForgetPasswordBtn() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(FORGET_PASSWORD_BTN)).click();
//		DriverFactory.getDriver().findElement(FORGET_PASSWORD_BTN).click();
	}
	
	public void enterEmail(String email) {
		DriverFactory.getDriver().findElement(EMAIL_FIELD).sendKeys(email);
	}
	
	public void clickSubmitBtn() {
		DriverFactory.getDriver().findElement(SUBMIT_BTN).click();
	}
	
	public void clickGetBackToHomePageBtn() {
		DriverFactory.getDriver().findElement(GET_BACK_TO_HOMEPAGE_BTN).click();
	}
	
	public By checkForgetPageTitle() {
		return FORGET_PASSWORD_TITLE;
	}

	public void clearEmailField() {
	    DriverFactory.getDriver().findElement(EMAIL_FIELD).clear();
	}
	
	public void verifyText() {
		DriverFactory.getDriver().findElement(VERIFY_TEXT).isDisplayed();
		
	}
}
