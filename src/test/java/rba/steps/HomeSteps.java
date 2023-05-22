package rba.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import rba.model.pages.HomePage;

import java.io.IOException;

public class HomeSteps {

    private HomePage homePage = new HomePage();


    @After
    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        homePage.cleanUp();
    }
    @Given("A user is on home page")
    public void navigateToHome() throws IOException {
        homePage.navigateHomePage();
    }

    @Given("Browser is closed")
    public void closeBrowser(){
        homePage.closeBrowser();
    }

    @When("User searches the following tab")
    public void searchTab(DataTable datatable) {
        String search = datatable.cell(1, 0);
        homePage.navigateToTab(search);
    }

    @And("User selects the following option")
    public void selectOption(DataTable dataTable) {
        String option = dataTable.cell(1, 0);
        homePage.navigateToSearchOption(option);
    }

    @And("User is navigated to following page")
    public void verifyNavigatedPage(DataTable datatable) {
        String pageHeader = datatable.cell(1, 0);
        Assert.assertTrue(homePage.verifyPage(pageHeader));
    }

    @Then("user is navigated to gifts and vouchers screen with results")
    public void verifyDisplayedPage() {
        Assert.assertTrue(homePage.verifyFilteredPage());
        Assert.assertFalse(homePage.verifyNotNullResults());
    }
}
