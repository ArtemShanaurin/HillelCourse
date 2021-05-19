package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Constant;

public class DriverFactory {
    public static WebDriver createDriver(BrowserType browserName){
        //String browserName = "chrom";
        WebDriver driver;
        switch (browserName){
            case CHROME:
                System.setProperty(Constant.SYSTEM_PROPERTY_CHROM_DRIVER, Constant.PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(Constant.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constant.PATH_TO_FIREFOX_DRIVER);
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Configuration for "+browserName+"is NOT exist");
        }
        return driver;
    }
}
