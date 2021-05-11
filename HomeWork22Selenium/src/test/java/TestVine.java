import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import pages.*;

import java.util.List;

public class TestVine extends JunitRunner{


    //1
    @Test
    public void requiredElementsShowed() {
        WelcomePage welcomePage = new WelcomePage();
        WebElement checkbox = DriverProvider.getDriver().findElement(By.cssSelector("div.confirmation-checkbox > label"));
        Assertions.assertTrue(checkbox.isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("#agegate-selector-options")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("[type=\"submit\"][disabled]")).isDisplayed());
    }
    //2
    @Test
    public void navigateAsEurope() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".fa.fa-bars")).isDisplayed());

    }

    //3
    @Test
    public void allRequiredElementsDisplayed() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".content.animation-screen.-one > h2")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".fa.fa-bars > span")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".header-sub-copy")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".content.animation-screen.-one > .button.home-button[aria-label*='Find Your Wine'")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("#primary-footer")).isDisplayed());
    }

    //4
    @Test
    public void menuButtonLogicHeaderOpen() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();

        mainVinePage.waitForMoment();

        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".main-nav > div > nav > ul > li:nth-child(1) > a")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".main-nav > div > nav > ul > li:nth-child(2) > a")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".main-nav > div > nav > ul > li:nth-child(3) > a")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".main-nav > div > nav > ul > li:nth-child(4) > a")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".main-nav > div > nav > ul > li:nth-child(5) > a")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".main-nav > div > nav > ul > li:nth-child(6) > a")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("#country-select > a")).isDisplayed());

        mainVinePage.clickToYellowTailLogo();

        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".fa.fa-bars")).isDisplayed());
    }
    //5
    @Test
    public void menuButtonLogicHeaderClose() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();
        mainVinePage.clickToYellowTailLogo();

        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector(".fa.fa-bars")).isDisplayed());


    }

    //6
    @Test
    public void globalNavlogic() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();
        mainVinePage.chooseCountry();
        mainVinePage.waitForChinaIsDisplayedIn();
        mainVinePage.clickToChina();
        mainVinePage.waitToLoadChinaPage();

        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("#image-comp-id-1533175598405")).isDisplayed());
    }

    //7
    @Test
    public void globalNavlogicChina() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();
        mainVinePage.chooseCountry();
        mainVinePage.waitForChinaIsDisplayedIn();

        mainVinePage.clickToChina();
        mainVinePage.waitToWeiboLogoIsDisplayed();

        mainVinePage.clickToWeiboLogo();

        String currentUrl = DriverProvider.getDriver().getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("“https://yellowtailChina"));
    }

    //8
    @Test
    public void whereToBuyValidZipCode() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();

        WereToBuyPage wereToBuyPage= mainVinePage.clickToWereToBuy();

        wereToBuyPage.clickToInputFieldLocationName();

        List<WebElement> searchResult = DriverProvider.getDriver().findElements(By.cssSelector(".address"));
        Assertions.assertTrue(searchResult.get(0).getText().contains("Sydney"));
    }

    //9
    @Test
    public void selectOneWine() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();

        WineCocktailsPage wineCocktailsPage = mainVinePage.clickToCocktail();
        wineCocktailsPage.openCocktailList();
        wineCocktailsPage.chooseRedWineInCocktailList();

        Assertions.assertEquals(7, wineCocktailsPage.countElementsRedWine());
    }

    //10
    @Test
    public void cocktailsNavigateToCocktailRecipePage() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();

        WineCocktailsPage wineCocktailsPage = mainVinePage.clickToCocktail();
        wineCocktailsPage.scrollToRaspberryRose();

        Assertions.assertTrue(wineCocktailsPage.getCurrentUrl().contains("raspberry-rose"));
    }

    //11
    @Test
    public void cocktailsSelectSeveralWines() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();

        WineCocktailsPage wineCocktailsPage = mainVinePage.clickToCocktail();
        wineCocktailsPage.openCocktailList();
        wineCocktailsPage.chooseRedWineInCocktailList();
        wineCocktailsPage.chooseSparklingWine();

        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("[data-value=\"red\"].-checked")).isDisplayed());
        Assertions.assertTrue(DriverProvider.getDriver().findElement(By.cssSelector("[data-value=\"bubbles\"].-checked")).isDisplayed());

        Assertions.assertEquals(18, wineCocktailsPage.countElementsRedAndSparklingWine());

    }

}
