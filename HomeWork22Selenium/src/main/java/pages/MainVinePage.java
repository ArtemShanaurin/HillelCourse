package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;
import java.util.List;

public class MainVinePage extends AbstractPage{

    public MainVinePage() {
        super();
    }

    @FindBy(css = ".fa.fa-bars")
    private WebElement menuBarOpen;

    @FindBy(css = "div.top-nav.-active > div.main-nav > div > div > a")
    private WebElement yellowTailLogo;

    @FindBy(css ="#country-select")
    private WebElement langChina;

    @FindBy(css = "div > ul > li:nth-child(4)")
    private WebElement chooseChina;

    @FindBy(css = "#image-comp-id-1533175598405")
    private WebElement imageOnChinaPage;

    @FindBy(css = ".sgg-comp-social-slot.social-weibo")
    private WebElement weiboLogo;

    @FindBy(css =".main-nav > div > nav > ul > li:nth-child(2) > a")
    private WebElement wereBuy;

    @FindBy(css = ".main-nav > div > nav > ul > li:nth-child(3) > a")
    private WebElement chooseCocktail;

    @FindBy(css = ".main-nav > div > nav > ul > li:nth-child(1) > a")
    private WebElement momentWait;

    public void clickToMenuBar(){
       // WebElement menuBarOpen = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuBarOpen.click();
    }

    public void waitForMenuBar(){
        Waiters.waitForElementToBeVisible(menuBarOpen);
    }
    public void waitForMoment(){
        Waiters.waitForElementToBeVisible(momentWait);
    }

    public void clickToYellowTailLogo(){
        yellowTailLogo.click();
    }

    public void chooseCountry(){
        langChina.click();
    }

    public void waitForChinaIsDisplayedIn(){
        Waiters.waitForElementToBeVisible(chooseChina);
    }

    public void clickToChina(){
        chooseChina.click();
    }

    public void waitToLoadChinaPage(){
        Waiters.waitForElementToBeVisible(imageOnChinaPage);
    }

    public void waitToWeiboLogoIsDisplayed(){
        Waiters.waitForElementToBeVisible(weiboLogo);
    }

    public void clickToWeiboLogo(){
        weiboLogo.click();
    }

    public WereToBuyPage clickToWereToBuy(){
        wereBuy.click();
        return new WereToBuyPage(DriverProvider.getDriver());

    }

    public WineCocktailsPage clickToCocktail(){
        chooseCocktail.click();
        return new WineCocktailsPage();
    }

}
