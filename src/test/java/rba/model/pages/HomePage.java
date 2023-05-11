package rba.model.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import rba.common.Screenshots;
import rba.common.Util;

import java.io.File;
import java.io.IOException;

public class HomePage {

    protected WebDriver driver;

    public HomePage() {
        this.driver = Util.getWebDriver();
    }

    public void navigateHomePage()  {
        driver.get("https://ebay.com.au");
        Screenshots.takeScreenshot(driver,"Homepage");

    }

    public boolean verifyPage(String pageHeader){
        return driver.findElement(By.xpath("//h1[contains(text(),'" + pageHeader + "')]")).isDisplayed();
    }


    public void navigateToTab(String searchTab){
        WebElement tab = driver.findElement(By.partialLinkText(searchTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(tab).perform();
        Screenshots.takeScreenshot(driver,"Navigatetotab");
    }

    public void navigateToSearchOption(String option){
        driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]")).click();
    }

    public boolean verifyFilteredPage() {
       return driver.findElement(By.xpath("//span[contains(text(),'Gift Cards & Vouchers between')]")).isDisplayed();
    }

    public void closeBrowser() {
        driver.close();
    }

    public boolean verifyNotNullResults() {
        return driver.findElement(By.xpath("//section[contains(@class,'b-lownull')]")).isDisplayed();
    }
}
