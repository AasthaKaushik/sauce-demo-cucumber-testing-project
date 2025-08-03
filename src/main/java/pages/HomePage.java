package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
public class HomePage {
    private WebDriver driver = DriverFactory.getDriver();
		public HomePage(WebDriver driver) {
			this.driver = driver;
		}
	public void clickCartIcon() {
		Actions a=new Actions(driver);
		a.contextClick(driver.findElement(By.xpath("//div[@id=\"minicart\"]")));
		// TODO Auto-generated method stub
		//driver.findElement(By.xpath("//div[@id=\"minicart\"]")).click()
	
		
	}
	public void clickGreyJacketImage() {
	    driver.findElement(By.xpath("//a[contains(@href,'/products/grey-jacket')]/img")).click();
	}

	public void clickAddToCart() {
	    driver.findElement(By.xpath("//input[@id='add']")).click();
	}

	public int verifyGreyJacketInCart() {
		 // Click on cart icon
		 driver.findElement(By.xpath("//a[@class='toggle-drawer cart desktop ']")).click();

		 // Wait for the Grey Jacket text to be visible in the cart
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Grey jacket')]")));
		return 1;


}}
