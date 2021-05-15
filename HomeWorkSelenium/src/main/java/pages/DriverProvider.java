package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constant;

public class DriverProvider {
    static WebDriver driver;

   private static WebDriver createDriver(){
        System.setProperty(Constant.SYSTEM_PROPERTY_CHROM_DRIVER, Constant.PATH_TO_CHROME_DRIVER);
        return new ChromeDriver();
    }

    public static WebDriver getDriver(){
        if(driver == null){
            driver = createDriver();
        }
        return driver;
    }

}
