package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Map;


public class CatalogPage {

	private final By CATALOG_LINK = By.cssSelector("a[href='/collections/all']");
	private final By PRODUCT_TITLES = By.cssSelector("section.product-grid h3");
	private final By PRODUCT_PRICES = By.cssSelector("section.product-grid h4");
	private final By PRODUCT_LINKS = By.cssSelector("section.product-grid a");

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

	public void clickOnProduct(String productName) {
		String urlPart = productName.toLowerCase().replace(" ", "-"); // e.g., "black-heels"
		By productLink = By.cssSelector("a[href*='/products/" + urlPart + "']");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
		wait.until(d -> d.findElement(productLink)).click();
	}

	public boolean isRedirectedToProductPage(String productName) {
		String urlPart = productName.toLowerCase().replace(" ", "-");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
		return wait.until(d -> d.getCurrentUrl().contains("/products/" + urlPart));
	}

}
