package rba.model.components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rba.common.Screenshots;
import rba.common.Util;

import java.util.HashMap;
import java.util.Map;

public class AllFilterForm {
    protected WebDriver driver;

    public AllFilterForm() {
        this.driver = Util.getWebDriver();
    }

    public boolean isFormDisplayed() {
        return driver.findElement(By.xpath("//form[@id='x-overlay__form']")).isDisplayed();
    }
    public void clickPrice(){
        driver.findElement(By.xpath("//div[@data-aspecttitle='price']")).click();
    }
    public void enterPriceMin(String min){
        driver.findElement(By.xpath("//input[@class='x-textrange__input x-textrange__input--from']")).sendKeys(min);
    }
    public void enterPriceMax(String max){
        driver.findElement(By.xpath("//input[@class='x-textrange__input x-textrange__input--to']")).sendKeys(max);
    }
    public void clickDeliveryOption(){
        driver.findElement(By.xpath("//div[@data-aspecttitle='delivery']")).click();
    }
    public void tickDeliveryOption(String deliveryoption){
        driver.findElement(By.xpath("//input[contains(@id,'postage_cbx')]")).click();
    }
    public void selectSeller(String seller){
        driver.findElement(By.xpath(" //input[contains(@id,'x-seller')]")).click();
        driver.findElement(By.xpath("//input[contains(@value,'" + seller + "')]")).click();
    }
    public void clickSellerOption(){
        driver.findElement(By.xpath("//div[@data-aspecttitle='seller']")).click();
    }
    public void clickLocationOption(){
        driver.findElement(By.xpath("//div[@data-aspecttitle='location']")).click();
    }
    public void selectLocationWithin(String within){
        driver.findElement(By.xpath("//input[contains(@id,'_valueOption')]")).click();
    }
    public void clickShowOnlyOption(){
        driver.findElement(By.xpath("//div[@data-aspecttitle='globals']")).click();
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
            driver.findElement(By.xpath("//div[contains(@id,'" + identifier + "')]")).click();
        }
        Screenshots.takeScreenshot(driver,"AppliedFilters");
    }
    public void clickApply(){
        driver.findElement(By.xpath("//div[@class='x-overlay-footer__apply']/button")).click();
        Screenshots.takeScreenshot(driver,"FilteredHome");
    }
}
