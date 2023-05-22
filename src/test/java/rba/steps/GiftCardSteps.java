package rba.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import rba.model.pages.GiftCardPage;

public class GiftCardSteps {

    private GiftCardPage giftcardPage = new GiftCardPage();


    @After
    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        giftcardPage.cleanUp();
    }
    @Given("A user is on gift cards page")
    public void navigateGiftCardPage() {
    }

    @When("User selects all filter option")
    public void clickAllFilterOption() {
        giftcardPage.clickAllFilter();

    }

}
