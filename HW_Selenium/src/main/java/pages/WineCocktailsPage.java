package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WineCocktailsPage extends AbstractPage{

    public WineCocktailsPage() {
        super();
    }

    @FindBy(css = ".toggle")
    private WebElement chooseToggle;

    @FindBy(css = "[data-value=\"red\"]")
    private WebElement chooseRed;

    @FindBy(css = "[data-value=\"bubbles\"]")
    private WebElement chooseSparklingWine;

    @FindBy(css = "[data-value=\"red\"].-checked")
    WebElement redWineChecked;

    @FindBy(css ="[data-value=\"bubbles\"].-checked")
    WebElement sparkWineChecked;

    @FindBy(css="a[href=\"raspberry-rose\"]")
    private WebElement scrollToRaspberryRoseReceipt;

    public boolean sparkWineCheckedIsDisplayed(){
        sparkWineChecked.isDisplayed();
        return true;
    }

    public boolean redWineCheckedIsDisplayed(){
        redWineChecked.isDisplayed();
        return true;
    }

    public void openCocktailList(){
        chooseToggle.click();
    }

    public void chooseRedWineInCocktailList(){
        chooseRed.click();
    }

    public void chooseSparklingWine(){
        chooseSparklingWine.click();
    }

    public int countElementsRedWine(){
        List<WebElement> redWineList = DriverProvider.getDriver().findElements(By.cssSelector(".tile.recipe-tile[data-types=\"red\"]"));
        return redWineList.size();
    }


    public void scrollToRaspberryRose(){
        //WebElement scroll = DriverProvider.getDriver().findElement(By.cssSelector("a[href=\"raspberry-rose\"]"));
        ((JavascriptExecutor) DriverProvider.getDriver()).executeScript("arguments[0].scrollIntoView(true);", scrollToRaspberryRoseReceipt);
        scrollToRaspberryRoseReceipt.click();
    }

    public String getCurrentUrl(){
        String currentUrl = DriverProvider.getDriver().getCurrentUrl();
        return currentUrl;
    }

    public int countElementsRedAndSparklingWine(){
        List<WebElement> wineList = DriverProvider.getDriver().findElements(By.cssSelector("[class=\"tile recipe-tile\"]"));
        int count = 0;
        for (WebElement item: wineList) {
            count++;
        }
        return count;
    }
    public String getRaspberryrRoseWine(){
        String raspberryrRoseWine = "raspberry-rose";
        return  raspberryrRoseWine;
    }

    public int numberOfCoctailsPost = 18;

    public int numbersRedWine = 7;


}
