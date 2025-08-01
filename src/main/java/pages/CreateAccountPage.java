package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class CreateAccountPage {
	private final By FIRST_NAME_FIELD = By.xpath("//input[@id='first_name']");
    private final By LAST_NAME_FIELD = By.xpath("//input[@id='last_name']");
    private final By EMAIL_FIELD = By.xpath("//input[@id='email']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    private final By REGISTER_BTN = By.xpath("//input[@value='Create']");
    private final By EMPTY_EMAIL_ERROR = By.xpath("(//*[@class='errors']//li)[1]");
    private final By EMPTY_PASSWORD_ERROR = By.xpath("//div[@class='errors']//following::li");
    private final By ALREADY_REGISTERED_ERROR = By.xpath("//div[@class='errors']/ul/li[contains(text(),'This email address is already associated with an account')]");

    public void enterFirstName(String firstName) {
        DriverFactory.getDriver().findElement(FIRST_NAME_FIELD).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        DriverFactory.getDriver().findElement(LAST_NAME_FIELD).sendKeys(lastName);
    }
    public void enterEmail(String email) {
        DriverFactory.getDriver().findElement(EMAIL_FIELD).sendKeys(email);
    }
    public By getEmail(){
        return EMAIL_FIELD;
    }
    public void enterPassword(String password) {
        DriverFactory.getDriver().findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickRegisterBtn() {
        DriverFactory.getDriver().findElement(REGISTER_BTN).click();
    }
    public By getEmptyEmailError(){
        return EMPTY_EMAIL_ERROR;
    }
    public By getEmptyPasswordError(){
        return EMPTY_PASSWORD_ERROR;
    }
    public By getAlreadyRegisteredError(){
        return ALREADY_REGISTERED_ERROR;
    }

}
