package pages;
 
import org.openqa.selenium.By;
 
import factory.DriverFactory;
 
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.ui.WebDriverWait;
 
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
 
import java.util.HashMap;
import java.util.Map;
 
public class CatalogPage {
	
	private final By CATALOG_PAGE_NAVIGATION_BTN = By.xpath("//li//a[contains(text(),'Catalog')]");
	private final By CATALOG_TITLE = By.xpath("//div//h1[contains(text(),'Products')]");
	
	private final By CATALOG_LINK = By.cssSelector("a[href='/collections/all']");
	private final By PRODUCT_TITLES = By.cssSelector("section.product-grid h3");
	
	public void clickCatalog() {
		DriverFactory.getDriver().findElement(CATALOG_PAGE_NAVIGATION_BTN).click();
	}
	
	public By verifyCatalogPageTitle() {
		return CATALOG_TITLE;
	}
	public void clickCatalogLink() {
	       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
 
		DriverFactory.getDriver().findElement(CATALOG_LINK).click();
	}
 
	public boolean isOnCatalogPage() {
	       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
 
		return DriverFactory.getDriver().getCurrentUrl().contains("/collections/all");
	}
 
	public List<String> getProductNames() {
	       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
 
		return DriverFactory.getDriver().findElements(PRODUCT_TITLES).stream().map(WebElement::getText)
				.map(String::toLowerCase).collect(Collectors.toList());
	}
 
	public boolean areAllExpectedProductsListed(List<String> expectedProducts) {
	       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
 
		List<String> actualProducts = getProductNames();
		return expectedProducts.stream().map(String::toLowerCase).allMatch(actualProducts::contains);
	}
	
	
}
