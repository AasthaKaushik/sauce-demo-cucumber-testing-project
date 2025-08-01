package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup() {
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
