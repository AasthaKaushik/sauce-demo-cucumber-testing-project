package stepdefinitions;

import java.time.Duration;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
    public void setup() {
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
