package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waiters;

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

    @FindBy(css =".main-nav > div > nav > ul > li:nth-child(2) > a")
    private WebElement wereBuy;

    @FindBy(css = ".main-nav > div > nav > ul > li:nth-child(3) > a")
    private WebElement chooseCocktail;

    @FindBy(css = ".main-nav > div > nav > ul > li:nth-child(1) > a")
    private WebElement wineLink;

    @FindBy(css = ".content.animation-screen.-one > h2")
    private WebElement headerWelcome;

    @FindBy(xpath = "//p[contains(text(), \"We are passionate about creating great tasting, quality wines for everyone to enjoy\")]")
    private WebElement subHeader;

    @FindBy(css = ".content.animation-screen.-one > .button.home-button[aria-label*='Find Your Wine'")
    private WebElement findWine;

    @FindBy(css ="#primary-footer")
    private WebElement primaryFooter;

    @FindBy(css = ".main-nav > div > nav > ul > li:nth-child(5) > a")
    private WebElement faqs;

    @FindBy(css =".main-nav > div > nav > ul > li:nth-child(6) > a[href=\"https://www.yellowtailwine.com/contact/\"]")
    private WebElement contact;


    public void clickToMenuBar(){
       // WebElement menuBarOpen = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuBarOpen.click();
    }

    public boolean menuBarOpenIsDisplayed(){
        boolean menuBar = menuBarOpen.isDisplayed();
        return menuBar;
    }

    public boolean headerWelcomeIsDisplayed(){
        headerWelcome.isDisplayed();
        return true;
    }

    public boolean subHeaderIsDisplayed(){
        subHeader.isDisplayed();
        return true;
    }

    public boolean findWineIsDisplayed(){
        findWine.isDisplayed();
        return true;
    }

    public boolean primaryFooterIsDisplayed(){
        primaryFooter.isDisplayed();
        return true;
    }

    public boolean wineLinkIsDisplayed(){
        wineLink.isDisplayed();
        return true;
    }

    public boolean wereBuyIsDisplayed(){
        wereBuy.isDisplayed();
        return true;
    }

    public boolean chooseCocktailIsDisplayed(){
        chooseCocktail.isDisplayed();
        return true;
    }

    public boolean chooseChinaIsDisplayed(){
        chooseChina.isDisplayed();
        return true;
    }

    public boolean faqsIsDisplayed(){
        faqs.isDisplayed();
        return true;
    }

    public boolean contactIsDisplayed(){
        contact.isDisplayed();
        return true;
    }

    public boolean chinaIsDisplayed(){
        langChina.isDisplayed();
        return true;
    }

    public void waitForMenuBar(){
        Waiters.waitForElementToBeVisible(menuBarOpen);
    }
    public void waitForMoment(){
        Waiters.waitForElementToBeVisible(wineLink);
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

    public ChinaPage clickToChina(){
        chooseChina.click();
        return new ChinaPage();
    }

    public WhereToBuyPage clickToWereToBuy(){
        wereBuy.click();
        return new WhereToBuyPage();

    }

    public WineCocktailsPage clickToCocktail(){
        chooseCocktail.click();
        return new WineCocktailsPage();
    }

}
