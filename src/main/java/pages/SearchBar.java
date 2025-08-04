package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;

public class SearchBar {

	private final By SEARCH_FIELD = By.xpath("//form//input[@id='search-field']");
	private final By SEARCH_ICON_BTN = By.xpath("//form//input[@id='search-submit']");
	private final By SEARCHED_ITEM_TXT = By.xpath("//div//span[contains(text(),'jacket')]");
	private final By SEARCHED_RANDOM_ITEM_TXT = By.xpath("//div//span[contains(text(),'xyz')]");
	
	public void checkSearchField() {	
		DriverFactory.getDriver().findElement(SEARCH_FIELD).isDisplayed();
	}
	
	public void searchBarClickable() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD)).isEnabled(); 
	}
	
	public void enterProductName(String productName) {
		DriverFactory.getDriver().findElement(SEARCH_FIELD).sendKeys(productName);
	}
	
	public void clickSearchIconBtn() {
		DriverFactory.getDriver().findElement(SEARCH_ICON_BTN).click();
	}
	
	public By searchedItemTxt() {
		return SEARCHED_ITEM_TXT;
	}
	
	public By verifyRandomItemTxt() {
		return SEARCHED_RANDOM_ITEM_TXT;
	}
}
