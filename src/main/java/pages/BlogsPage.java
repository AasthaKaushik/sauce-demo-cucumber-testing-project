package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;

public class BlogsPage {

    private final By BLOG_LINK_TEXT = By.linkText("Blog");
    private final By BLOG_PAGE_BODY = By.xpath("//body[@id='news']");
    private final By FIRST_POST_TEXT = By.xpath("//*[contains(text(),'First Post')]");
    private final By BLOG_CONTENT = By.xpath("//*[@class=\"wysiwyg\"]/p[1]");

    private By POST_DATE_TEXT = By.xpath("//*[@class=\"two columns alpha date\"]/span");
    private By BACK_TO_POST_LINK = By.linkText("Back to posts");

    private final By ADMIN_AREA_LINK = By.linkText("admin area");
    private final By ECOMMERCE_BLOG_LINK = By.linkText("ecommerce blog");
    private final By TEMPLATE_LINK = By.linkText("ecommerce template");
    private final By HOSTING_LINK = By.linkText("ecommerce hosting");
    private final By SOFTWARELINK = By.linkText("shopping cart software");
    private final By SHOPIFYLINK = By.linkText("Shopify");
    private final By SELLONLINELINK = By.linkText("sell online");
    private final By SAVEBUTTON = By.xpath("//*[@class=\"pinterest\"]/a");

    //1
    public void clickBlogLink() {
        DriverFactory.getDriver().findElement(BLOG_LINK_TEXT).click();
    }

    public boolean BlogHomepageVisible() {
        return DriverFactory.getDriver().findElement(BLOG_PAGE_BODY).isDisplayed();
    }

    public String getFirstPostTitle() {
        return DriverFactory.getDriver().findElement(FIRST_POST_TEXT).getText();
    }


    // 2
//	public boolean isBlogTitleVisible() {
//		return DriverFactory.getDriver().findElement(FIRST_PostText).isDisplayed();
//	}

    public void clickFirstPost() {
        DriverFactory.getDriver().findElement(FIRST_POST_TEXT).click();
    }

    public String getBlogContentText() {
        return DriverFactory.getDriver().findElement(BLOG_CONTENT).getText();
    }

    //3
    public void clickshopifycommercrbloglink() {
        DriverFactory.getDriver().findElement(ECOMMERCE_BLOG_LINK).click();
    }

    public String isNewTabOpened() {
        return DriverFactory.getDriver().getCurrentUrl();

    }

    //4
    public void ClickTemplateLink() {
        DriverFactory.getDriver().findElement(TEMPLATE_LINK).click();
    }

    public String getNewTabTemplateUrl() {
        return DriverFactory.getDriver().getCurrentUrl();
    }

    // 5
    public void ClickonEcommercehostingLink() {
        DriverFactory.getDriver().findElement(HOSTING_LINK).click();
    }

    //6
    public void clickShoppingCartSoftware() {
        DriverFactory.getDriver().findElement(SOFTWARELINK).click();
    }

    //7
    public String getAdminAreatext() {
        return DriverFactory.getDriver().findElement(ADMIN_AREA_LINK).getText();
    }

    public boolean isAdminAreaLinkClickable() {
        WebElement link = DriverFactory.getDriver().findElement(ADMIN_AREA_LINK);
        return link.isDisplayed() && link.isEnabled();
    }

    //8
    public void ClickBackToPostsLink() {
        DriverFactory.getDriver().findElement(BACK_TO_POST_LINK).click();
    }

    //9
    public void clickSaveButton() {
        DriverFactory.getDriver().findElement(SAVEBUTTON);
    }

    // 10
    public void clickShopifyLink() {
        DriverFactory.getDriver().findElement(SHOPIFYLINK).click();
    }

    // 11
    public void clickSellOnlineLink() {
        DriverFactory.getDriver().findElement(SELLONLINELINK).click();
    }
}