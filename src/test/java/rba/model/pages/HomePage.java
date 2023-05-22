package rba.model.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import rba.common.Screenshots;
import rba.common.Util;

import java.io.File;
import java.io.IOException;

public class HomePage {


    public HomePage() {

    }



    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        Util.closeWebDriver();
    }
    public void navigateHomePage()  {
        Util.getWebDriver().get("https://ebay.com.au");
        Screenshots.takeScreenshot(Util.getWebDriver(),"Homepage");

    }

    public boolean verifyPage(String pageHeader){
        return Util.getWebDriver().findElement(By.xpath("//h1[contains(text(),'" + pageHeader + "')]")).isDisplayed();
    }


    public void navigateToTab(String searchTab){
        WebElement tab = Util.getWebDriver().findElement(By.partialLinkText(searchTab));
        Actions actions = new Actions(Util.getWebDriver());
        actions.moveToElement(tab).perform();
        Screenshots.takeScreenshot(Util.getWebDriver(),"Navigatetotab");
    }

    public void navigateToSearchOption(String option){
        Util.getWebDriver().findElement(By.xpath("//a[contains(text(),'" + option + "')]")).click();
    }

    public boolean verifyFilteredPage() {
       return Util.getWebDriver().findElement(By.xpath("//span[contains(text(),'Gift Cards & Vouchers between')]")).isDisplayed();
    }

    public void closeBrowser() {
        Util.getWebDriver().close();
    }

    public boolean verifyNotNullResults() {
        return Util.getWebDriver().findElement(By.xpath("//section[contains(@class,'b-lownull')]")).isDisplayed();
    }
}
