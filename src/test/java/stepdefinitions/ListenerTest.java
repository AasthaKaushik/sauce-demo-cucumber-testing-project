package stepdefinitions;

import factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String className = result.getTestClass().getName(); // full package.class
        String methodName = result.getMethod().getMethodName();
        // Filter only Login or CreateAccount related failures
        if (className.contains("Login") || className.contains("CreateAccount")) {
            WebDriver driver = DriverFactory.getDriver();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                File dest = new File(System.getProperty("user.dir") +
                        "/screenshots/" + methodName + ".png");
                FileUtils.copyFile(src, dest);
                System.out.println("📸 Screenshot taken for: " + methodName);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
