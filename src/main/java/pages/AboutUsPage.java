package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class AboutUsPage {
	private final By ABOUT_US_PAGE_NAVIGATION_BTN = By.xpath("//li//a[contains(text(),'About Us')]");
	private final By ABOUT_US_PAGE_TITLE = By.xpath("//div//h1[contains(text(),'About Us')]");
	
	public void clickAboutUs() {
		DriverFactory.getDriver().findElement(ABOUT_US_PAGE_NAVIGATION_BTN).click();
	}
	
	public By verifyAboutUsPageTitle() {
		return ABOUT_US_PAGE_TITLE;
	}

}
