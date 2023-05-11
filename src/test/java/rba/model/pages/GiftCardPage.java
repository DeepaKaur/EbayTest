package rba.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rba.common.Screenshots;
import rba.common.Util;

public class GiftCardPage {
    protected WebDriver driver;

    public GiftCardPage() {
        this.driver = Util.getWebDriver();
    }

    public void clickAllFilter(){
        driver.findElement(By.xpath("//button[contains(text(),'All filters')]")).click();
        Screenshots.takeScreenshot(driver,"Filters");
    }

}
