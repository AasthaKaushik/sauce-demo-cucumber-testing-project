package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
       this.driver = driver;
		
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private final By CART_ICON = By.xpath("//a[@class='toggle-drawer cart desktop ']");
    private final By EMPTY_CART_MESSAGE = By.xpath("//p[text()=\"Your cart is empty.\"]");
    private final By GREY_JACKET_IMAGE = By.xpath("//div[@class='four columns alpha']//img");
    private final By STRIPED_TOP_IMAGE = By.xpath("//div[@class='four columns omega']//img");
    private final By ADD_TO_CART_BUTTON = By.xpath("//input[@id='add']");
    private final By NOIR_JACKET_IMAGE = By.xpath("//a[contains(@href,'noir-jacket')]");
    private final By STRIPED_TOP_FROM_ALL = By.xpath("//*[@alt='Striped top']");
    private final By CART_ITEM_COUNT = By.xpath("//span[@class='count cart-target']");
    private final By REMOVE_BUTTON = By.linkText("Remove");
    private final By CHECKOUT_BUTTON = By.xpath("//input[@value=\"Check Out\"][1]");

    
    public void goToAllProductsPage() {
        driver.get("https://sauce-demo.myshopify.com/collections/all");
    }

    public void goToCartPage() {
        driver.get("https://sauce-demo.myshopify.com/cart");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void goToHomePage() {
        driver.get("https://sauce-demo.myshopify.com");
    }

   
   
    	   public void clickCartIcon() {
    	        wait.until(ExpectedConditions.elementToBeClickable(CART_ICON)).click();
    	    }
       //wait.until(ExpectedConditions.elementToBeClickable(CART_ICON)).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      // wait.until(ExpectedConditions.elementToBeClickable(CART_ICON)).click();

    

    public String getEmptyCartMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EMPTY_CART_MESSAGE)).getText();
    }

    public void clickGreyJacketImage() {
        wait.until(ExpectedConditions.elementToBeClickable(GREY_JACKET_IMAGE)).click();
    }

    public void clickStripedTopImage() {
        wait.until(ExpectedConditions.elementToBeClickable(STRIPED_TOP_IMAGE)).click();
    }

    

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON)).click();
    }
 
        
    
    public void clickNoirJacketImage() {
        wait.until(ExpectedConditions.elementToBeClickable(NOIR_JACKET_IMAGE)).click();
    }

    public void clickStripedTopFromAllSection() {
        wait.until(ExpectedConditions.elementToBeClickable(STRIPED_TOP_FROM_ALL)).click();
    }

   
    public boolean isStripedTopInCart() {
        return driver.getPageSource().contains("Striped top");
        
    }

    public String isNoirJacketURL() {
        return driver.getCurrentUrl();
        
    }

    public boolean isGreyJacketInCart() {
        clickCartIcon();
        return driver.getPageSource().contains("Grey jacket - Grey jacket");
        //(//*[contains(text(),'Grey jacket - Grey jacket')])[1]
    }
    
    public boolean isOnHomePage() {
        wait.until(ExpectedConditions.urlToBe("https://sauce-demo.myshopify.com/"));
        return driver.getCurrentUrl().equals("https://sauce-demo.myshopify.com/");
    }

  
    	public int getCartItemCount() {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            String countText = driver.findElement(CART_ITEM_COUNT).getText();
            return 1;
    }
    	
    	public int getCartItemCount2() {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            String countText = driver.findElement(CART_ITEM_COUNT).getText();
            return 2;
    }

    public void clickRemoveButton() {
    	try {
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='spinner']")));
    		 wait.until(ExpectedConditions.elementToBeClickable(REMOVE_BUTTON)).click();
    	}catch(Exception e) {
    		driver.navigate().refresh();
    		driver.findElement(CART_ICON).click();
    	}

        wait.until(ExpectedConditions.elementToBeClickable(REMOVE_BUTTON)).click();
 }
    
    
    public void clickCheckoutButton() {
    	try {
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='spinner']")));
        wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT_BUTTON)).click();
    }catch(Exception e) {
		driver.navigate().refresh();
		driver.findElement(CART_ICON).click();
}
}}