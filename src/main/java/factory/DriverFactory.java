package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static WebDriver getDriver(){
        if(driver.get() == null){
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }
    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}




