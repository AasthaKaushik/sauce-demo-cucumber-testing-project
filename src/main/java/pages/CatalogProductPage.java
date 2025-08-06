package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CatalogProductPage {

    private final By PRODUCTLINK = By.xpath("//*[text()='Black heels']");
    private final By ADDTOCART = By.xpath("//input[@id='add']");

    private final By BROWNSHADESOLD = By.xpath("//*[@id=\"product-3\"]/div");
    private final By SOLDOUTBUTTONDISABLE = By.xpath("//input[@value='Sold Out']");

    private final By PRODUCTBUTTON = By.xpath("//*[@value=\"Add to Cart\"]");
    private final By ITEMTEXT = By.xpath("(//*[@type=\"text\"])[2]");
    private final By CARTLINK=By.xpath("//*[@id=\"minicart\"]/a[1]");
    private final By BROWNSANDALS = By.xpath("(//img[@class=\"product\"])[2]");
    private final By BROWNDSANDALSTEXT = By.xpath("//*[text()=\"£39.99\"]");

    public void navigateToProductPage() {
        DriverFactory.getDriver().findElement(PRODUCTLINK).click();
    }

    public void clickAddToCartButton() {
        DriverFactory.getDriver().findElement(ADDTOCART).click();
    }

    public void clickonBrownShadesProduct() {
        DriverFactory.getDriver().findElement(BROWNSHADESOLD).click();
    }

    public WebElement getSoldOutDisable() {
        return DriverFactory.getDriver().findElement(SOLDOUTBUTTONDISABLE);
    }

    public void addtoCartButton() throws InterruptedException {

        DriverFactory.getDriver().findElement(PRODUCTBUTTON).click();

    }

    public void ClickonCartLink() throws InterruptedException {

        DriverFactory.getDriver().findElement(CARTLINK).click();

    }

    public String getItemsInCartText() {
        return DriverFactory.getDriver().findElement(ITEMTEXT).getText();
    }
    public void clickOnSandals() {

        DriverFactory.getDriver().findElement(BROWNSANDALS).click();
    }

    public String getBrownSandalsPrice() {
        return DriverFactory.getDriver().findElement(BROWNDSANDALSTEXT).getText();
    }

}
