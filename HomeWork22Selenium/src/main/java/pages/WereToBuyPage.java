package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WereToBuyPage extends AbstractPage{

    public WereToBuyPage() {
        super();
    }

    @FindBy(css = "#locationName")
    private WebElement inputElement;

    @FindBy(css =".address")
    WebElement searchResult;

    public void clickToInputFieldLocationName(){
        inputElement.click();
        inputElement.sendKeys("Sydney, Australia");
        inputElement.sendKeys(Keys.ENTER);
    }

    public List<WebElement> searchResults = DriverProvider.getDriver().findElements(By.cssSelector(".address"));
}
