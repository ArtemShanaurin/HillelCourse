package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WereToBuyPage extends AbstractPage{

    public WereToBuyPage(WebDriver driver) {
        super();
    }

    public void clickToInputFieldLocationName(){
        WebElement inputElement = DriverProvider.getDriver().findElement(By.cssSelector("#locationName"));
        inputElement.click();
        inputElement.sendKeys("Sydney, Australia");
        inputElement.sendKeys(Keys.ENTER);
    }
}
