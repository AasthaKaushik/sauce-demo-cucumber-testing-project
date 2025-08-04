package pages;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class FooterPage {
   private final WebDriver driver;
   private final WebDriverWait wait;
   public FooterPage() {
       this.driver = DriverFactory.getDriver();
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   }
   
  
   private final By FOOTER_CONTAINER = By.xpath("//footer//h2[text()='Footer']");
   private final By SEARCH_LINK = By.xpath("//h2[text()='Footer']/following::a[@href=\"/search\"][1]");
   private final By ABOUT_US_LINK = By.cssSelector("a[href*='/pages/about']");
   // Visibility Checks
   public boolean isFooterVisible() {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(FOOTER_CONTAINER)).isDisplayed();
   }
   public boolean isSearchLinkClickable() {
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_LINK));
       return element.isDisplayed() && element.isEnabled();
   }
   public boolean isAboutUsLinkClickable() {
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ABOUT_US_LINK));
       return element.isDisplayed() && element.isEnabled();
   }
}
