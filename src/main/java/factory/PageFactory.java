package factory;

import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class PageFactory {

    private static ThreadLocal<LoginPage> loginPageTL = new ThreadLocal<>();
    private static ThreadLocal<CartPage> cartPageTL = new ThreadLocal<>();
    private static ThreadLocal<HomePage> homePageTL = new ThreadLocal<>();

    public static LoginPage getLoginPage() {
        if (loginPageTL.get() == null) {
            loginPageTL.set(new LoginPage());
        }
        return loginPageTL.get();
    }

    public static CartPage getCartPage() {
        if (cartPageTL.get() == null) {
            cartPageTL.set(new CartPage());
        }
        return cartPageTL.get();
    }

    public static HomePage getHomePage() {
        WebDriver driver = DriverFactory.getDriver();
        if (homePageTL.get() == null) {
            homePageTL.set(new HomePage(driver));
        }
        return homePageTL.get();
    }

	
}
