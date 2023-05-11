package rba.common;

import rba.steps.HomeSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Util {
    static WebDriver webDriver;
    public static WebDriver getWebDriver() {
        if (webDriver != null) {
            return webDriver;
        }

        String os = System.getProperty("os.name");
        String driverPath = "";
        if (os.contains("Windows")) {
            driverPath = HomeSteps.class
                    .getClassLoader().getResource("chromedriver.exe").getPath();
        } else if (os.contains("Linux")) {
            driverPath = HomeSteps.class
                    .getClassLoader().getResource("chromedriver_linux").getPath();
        } else if (os.contains("Mac")) {
            driverPath = HomeSteps.class
                    .getClassLoader().getResource("chromedriver_mac").getPath();
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless","--disable-gpu","--window-size=1920,1200","--ignore-certificate-errors");
        options.addArguments("--disable-gpu","--window-size=1920,1200","--ignore-certificate-errors");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return webDriver;
    }
}