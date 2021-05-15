package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constant;

public class DriverProvider {
    static WebDriver driver;



    public static WebDriver getDriver(){
        if(driver == null){
            driver = DriverFactory.createDriver(BrowserType.FIREFOX);
        }
        return driver;
    }

}
