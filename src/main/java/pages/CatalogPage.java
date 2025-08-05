package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class CatalogPage {
	
	private final By CATALOG_PAGE_NAVIGATION_BTN = By.xpath("//li//a[contains(text(),'Catalog')]");
	private final By CATALOG_TITLE = By.xpath("//div//h1[contains(text(),'Products')]");
	
	public void clickCatalog() {
		DriverFactory.getDriver().findElement(CATALOG_PAGE_NAVIGATION_BTN).click();
	}
	
	public By verifyCatalogPageTitle() {
		return CATALOG_TITLE;
	}
}
