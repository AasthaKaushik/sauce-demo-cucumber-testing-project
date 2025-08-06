package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

    public class SocialMediaIconTest {

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), java.time.Duration.ofSeconds(10));

        @Given("I am on the Home Page")
        public void i_am_on_the_home_page() {
            DriverFactory.getDriver().get("https://sauce-demo.myshopify.com/");
        }

        @When("I click on a social media icon")
        public void i_click_on_a_social_media_icon() {
            DriverFactory.getDriver().findElement(By.xpath("//div//a[@class='pinterest ']  ")).click();
        }

        @Then("I should be redirected to the corresponding social media page in a new tab")
        public void i_should_be_redirected_to_the_corresponding_social_media_page_in_a_new_tab() {
            String expectedUrl = "https://www.pinterest.com/chrisjhoughton/social-design/";

            // Switch to the new tab
            for (String handle : DriverFactory.getDriver().getWindowHandles()) {
                DriverFactory.getDriver().switchTo().window(handle);
            }

            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            String actualUrl = DriverFactory.getDriver().getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "User was not redirected to the correct social media page.");
        }
    }

