package stepdefinitions;

import factory.DriverFactory;
import factory.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import java.util.List;

public class CatalogNavigationSteps {

	@When("I click on the catalog")
	@When("I click on the catalog link")
	public void clickCatalogLink() {
		PageFactory.getCatalogPage().clickCatalogLink();
	}

	@Then("I should be on catalog page")
	@And("I am on catalog page")
	public void verifyCatalogPage() {
		Assert.assertTrue(PageFactory.getCatalogPage().isOnCatalogPage(), "Not on catalog page.");
	}

	@Then("The following products should be listed on the catalog page:")
	public void verifyProducts(DataTable dataTable) {
		List<String> expectedProducts = dataTable.asList();
		Assert.assertTrue(PageFactory.getCatalogPage().areAllExpectedProductsListed(expectedProducts),
				"Some expected products are missing from the catalog.");
	}

	

}
	    


    
	    


