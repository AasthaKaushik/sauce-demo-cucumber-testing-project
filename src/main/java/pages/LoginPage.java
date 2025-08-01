package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class LoginPage {
	private final By USERNAME_FIELD = By.id("customer_email");
    private final By PASSWORD_FIELD = By.id("customer_password");
    private final By SIGN_IN_BTN = By.xpath("//input[@value='Sign In']");

    public void enterUsername(String email) {
        DriverFactory.getDriver().findElement(USERNAME_FIELD).sendKeys(email);
    }
    public void enterPassword(String password) {
        DriverFactory.getDriver().findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickSignInBtn() {
        DriverFactory.getDriver().findElement(SIGN_IN_BTN).click();
    }

}
