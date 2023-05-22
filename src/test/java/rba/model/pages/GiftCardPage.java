package rba.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rba.common.Screenshots;
import rba.common.Util;

public class GiftCardPage {

    public GiftCardPage() {

    }

    public void clickAllFilter(){
        Util.getWebDriver().findElement(By.xpath("//button[contains(text(),'All filters')]")).click();
        Screenshots.takeScreenshot(Util.getWebDriver(),"Filters");
    }
    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        Util.closeWebDriver();
    }

}
