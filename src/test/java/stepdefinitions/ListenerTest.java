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
        Object currentClass = result.getInstance();
        WebDriver driver= DriverFactory.getDriver();
        String methodName = result.getMethod().getMethodName();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(System.getProperty("user.dir")+File.separator+methodName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
