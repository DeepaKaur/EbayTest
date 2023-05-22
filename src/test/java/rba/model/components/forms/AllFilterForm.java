package rba.model.components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rba.common.Screenshots;
import rba.common.Util;

import java.util.HashMap;
import java.util.Map;

public class AllFilterForm {

    public AllFilterForm() {
    }

    public boolean isFormDisplayed() {
        return Util.getWebDriver().findElement(By.xpath("//form[@id='x-overlay__form']")).isDisplayed();
    }
    public void clickPrice(){
        Util.getWebDriver().findElement(By.xpath("//div[@data-aspecttitle='price']")).click();
    }
    public void enterPriceMin(String min){
        Util.getWebDriver().findElement(By.xpath("//input[@class='x-textrange__input x-textrange__input--from']")).sendKeys(min);
    }
    public void enterPriceMax(String max){
        Util.getWebDriver().findElement(By.xpath("//input[@class='x-textrange__input x-textrange__input--to']")).sendKeys(max);
    }
    public void clickDeliveryOption(){
        Util.getWebDriver().findElement(By.xpath("//div[@data-aspecttitle='delivery']")).click();
    }
    public void tickDeliveryOption(String deliveryoption){
        Util.getWebDriver().findElement(By.xpath("//input[contains(@id,'postage_cbx')]")).click();
    }
    public void selectSeller(String seller){
        Util.getWebDriver().findElement(By.xpath(" //input[contains(@id,'x-seller')]")).click();
        Util.getWebDriver().findElement(By.xpath("//input[contains(@value,'" + seller + "')]")).click();
    }
    public void clickSellerOption(){
        Util.getWebDriver().findElement(By.xpath("//div[@data-aspecttitle='seller']")).click();
    }
    public void clickLocationOption(){
        Util.getWebDriver().findElement(By.xpath("//div[@data-aspecttitle='location']")).click();
    }
    public void selectLocationWithin(String within){
        Util.getWebDriver().findElement(By.xpath("//input[contains(@id,'_valueOption')]")).click();
    }
    public void clickShowOnlyOption(){
        Util.getWebDriver().findElement(By.xpath("//div[@data-aspecttitle='globals']")).click();
    }

    private Map<String, String> showOnlyIDsMap = new HashMap();
    {
        showOnlyIDsMap.put("Sale items", "savings");
        showOnlyIDsMap.put("Deals & Savings", "SaleItems");
        showOnlyIDsMap.put("Accepts Best offer", "Offer");
    }
    public void selectGlobalOptions(String showOnlyOptions){
        String[] showOptions = showOnlyOptions.split(",");
        for (String option: showOptions) {
            String identifier = showOnlyIDsMap.get(option.trim());
            Util.getWebDriver().findElement(By.xpath("//div[contains(@id,'" + identifier + "')]")).click();
        }
        Screenshots.takeScreenshot(Util.getWebDriver(),"AppliedFilters");
    }
    public void clickApply(){
        Util.getWebDriver().findElement(By.xpath("//div[@class='x-overlay-footer__apply']/button")).click();
        Screenshots.takeScreenshot(Util.getWebDriver(),"FilteredHome");
    }


    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        Util.closeWebDriver();
    }
}
