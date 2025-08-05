package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
        glue={"stepdefinitions","Hooks"},
        plugin= {"pretty","html:target/cucumber.html"},
        monochrome=true
)
public class TestRunner extends AbstractTestNGCucumberTests{
	 @DataProvider(parallel=true)
     @Override
	    public Object[][] scenarios(){
	        return super.scenarios();
	    }
}
