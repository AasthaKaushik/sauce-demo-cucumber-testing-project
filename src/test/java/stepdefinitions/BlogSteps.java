package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogSteps {

    @Given("User is on the homepage")
    public void User_is_on_the_homepage() {

        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com");

    }

    @When("I click on the Blog link in the sidebar")
    public void i_click_on_the_blog_link_in_the_sidebar() {
        PageFactory.getBlogsPage().clickBlogLink();
    }

    @Then("I should  see First Post on blog page")
    public void i_should_see_first_post_on_blog_page() {
        Assert.assertEquals(PageFactory.getBlogsPage().getFirstPostTitle(), "First Post");

    }

//2Scenario

    @Given("I am on the Blog page")
    public void i_am_on_the_blog_page() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news");
    }

    @When("I click the First Post")
    public void i_click_the_first_post() {
        PageFactory.getBlogsPage().clickFirstPost();
    }

    @Then("I should see the blog content")
    public void i_should_see_the_blog_content() {
        Assert.assertEquals(PageFactory.getBlogsPage().getBlogContentText(),
                "This is your store’s blog. You can use it to talk about new product launches, experiences, tips or other news you want your customers to read about.");
    }

//3Scenario

    @Given("I am on the First Postpage")
    public void i_am_on_the_first_postpage() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news");
        PageFactory.getBlogsPage().clickFirstPost();
    }

    @When("I click the Shopify’s ecommerce blog link")
    public void i_click_the_shopify_s_ecommerce_blog_link() {
        PageFactory.getBlogsPage().clickshopifycommercrbloglink();
    }

    @Then("it should open in a new tab")
    public void it_should_open_in_a_new_tab() {
        Assert.assertEquals(PageFactory.getBlogsPage().isNewTabOpened(), "https://www.shopify.com/in/blog");
    }

    //4Scenario
    @Given("I am on the page")
    public void i_am_on_the_page() {

        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news/12832805-first-post");
    }

    @When("I click the ecommerce template link")
    public void I_clickthe_ecommerce_template_link() {
        PageFactory.getBlogsPage().ClickTemplateLink();
    }

    @Then("Shopify’s template page should open in a new tab")
    public void shopifys_templagetab_should_open() {
        Assert.assertEquals(PageFactory.getBlogsPage().getNewTabTemplateUrl(),
                "https://www.shopify.com/blog/best-ecommerce-sites");
    }

    //5scenario
    @Given("I am on the firstpage on Homepage")
    public void I_am_on_the_firstpage_on_Homepage() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news");
    }

    @When("I click the ecommerce hosting link")
    public void I_click_the_ecommerce_hosting_link() {
        PageFactory.getBlogsPage().ClickonEcommercehostingLink();
    }

    @Then("hosting info should open in a new tab")
    public void hosting_infoshould_open_in_new_tab() {

        String pagetitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(pagetitle, "9 Best Ecommerce Hosting Solutions in 2025 - Shopify");
        System.out.println(pagetitle);
    }

//6 scenario

    @Given("I am on the Firstpostpage")
    public void i_am_on_the_firstpostpage() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news/12832805-first-post");
    }

    @When("I click the shopping cart software link")
    public void i_click_the_shopping_cart_software_link() {
        PageFactory.getBlogsPage().clickShoppingCartSoftware();
    }

    @Then("cart software info should open")
    public void cart_software_info_should_open() {

        String url = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.shopify.com/tour/shopping-cart");
    }

    //7Scenario
    @Given("I am viewing the First Post")
    public void i_am_viewing_the_first_post() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news/12832805-first-post");

    }

    @Then("I should see the text admin area")
    public void I_should_see_the_text_admin_area() {
        String adminareatext = PageFactory.getBlogsPage().getAdminAreatext();
        Assert.assertEquals(adminareatext, "admin area");
    }

    @Then("it should be a clickable hyperlink")
    public void it_should_be_a_clickable_hyperlink() {

        PageFactory.getBlogsPage().isAdminAreaLinkClickable();
    }

    // 8Scenario
    @Given("I am on the BlogFirstpostpage")
    public void i_am_on_the_BlogFistpostpage() {
        DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/blogs/news/12832805-first-post");
    }

    @When("I click an external link")
    public void i_click_an_external_link() {
        PageFactory.getBlogsPage().ClickBackToPostsLink();
    }

    @Then("it should open in a new browser tab")
    public void it_should_open_in_a_new_browser_tab() {

        String back = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(back, "https://sauce-demo.myshopify.com/blogs/news");
    }

}