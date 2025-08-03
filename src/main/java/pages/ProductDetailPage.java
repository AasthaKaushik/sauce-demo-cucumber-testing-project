package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class ProductDetailPage {
	private final By CLICK_PRODUCT = By.xpath("//a//h3[contains(text(),'Grey jacket')]");
	private final By PRODUCT_TITLE = By.xpath("//section//h1[contains(text(),'Grey jacket')]");
	
	public void clickProduct() {
		DriverFactory.getDriver().findElement(CLICK_PRODUCT).click();
	}
	
	public By verifyProductTitle() {
		return PRODUCT_TITLE;
	}
}
