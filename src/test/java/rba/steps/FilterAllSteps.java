package rba.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import rba.model.components.forms.AllFilterForm;

public class FilterAllSteps {

    private AllFilterForm allfilterform = new AllFilterForm();

    @After
    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        allfilterform.cleanUp();
    }

    @Given("user is on all filter form on gift and vouchers")
    public void onAllFilterGiftAndVoucher() {
    }

    @When("user applies filter as following")
    public void allFilterOptions(DataTable datatable) {
        String minPrice = datatable.cell(1, 0);
        String maxPrice = datatable.cell(1, 1);
        String deliveryOption = datatable.cell(1, 2);
        String sellers = datatable.cell(1, 3);
        String within = datatable.cell(1, 4);
        String showOnly = datatable.cell(1,5);

        allfilterform.clickPrice();
        allfilterform.enterPriceMin(minPrice);
        allfilterform.enterPriceMax(maxPrice);

//              | min | max | delivery | sellers | location | show only|
//      | 500 | 1000 | free postage | sellers with eBay stores | 100 | Sale items, Deals & Savings, Accepts Best offer|
//
        allfilterform.clickDeliveryOption();
        allfilterform.tickDeliveryOption(deliveryOption);
        allfilterform.clickSellerOption();
        allfilterform.selectSeller(sellers);
        allfilterform.clickLocationOption();
        allfilterform.selectLocationWithin(within);
        allfilterform.clickShowOnlyOption();
        allfilterform.selectGlobalOptions(showOnly);
    }

    @And("Filter form is displayed")
    public void displayFilterform() {
        Assert.assertTrue(allfilterform.isFormDisplayed());

    }

    @And("user clicks apply")
    public void clickApplyFilter() {
        allfilterform.clickApply();
    }


}
