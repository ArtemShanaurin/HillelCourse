import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

public class TestVineTest extends JunitRunner{


    //1
    @Test
    public void requiredElementsShowed() {
        WelcomePage welcomePage = new WelcomePage();
        Assertions.assertTrue(welcomePage.checkLegalDrinkIsDisplayed());
        Assertions.assertTrue(welcomePage.chooseCountryIsDisplayed());
        Assertions.assertTrue(welcomePage.submitButtonIsDisabled());
    }
    //2
    @Test
    public void navigateAsEurope() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();
        makeScreenshot();
        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        Assertions.assertTrue(mainVinePage.menuBarOpenIsDisplayed());

    }

    //3
    @Test
    public void allRequiredElementsDisplayed() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();
        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();

        Assertions.assertTrue(mainVinePage.headerWelcomeIsDisplayed());
        Assertions.assertTrue(mainVinePage.menuBarOpenIsDisplayed());
        Assertions.assertTrue(mainVinePage.subHeaderIsDisplayed());
        Assertions.assertTrue(mainVinePage.findWineIsDisplayed());
        Assertions.assertTrue(mainVinePage.primaryFooterIsDisplayed());
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

        Assertions.assertTrue(mainVinePage.wineLinkIsDisplayed());
        Assertions.assertTrue(mainVinePage.wereBuyIsDisplayed());
        Assertions.assertTrue(mainVinePage.chooseCocktailIsDisplayed());
        Assertions.assertTrue(mainVinePage.chooseChinaIsDisplayed());
        Assertions.assertTrue(mainVinePage.faqsIsDisplayed());
        Assertions.assertTrue(mainVinePage.contactIsDisplayed());
        Assertions.assertTrue(mainVinePage.chinaIsDisplayed());

        mainVinePage.clickToYellowTailLogo();

        Assertions.assertTrue(mainVinePage.menuBarOpenIsDisplayed());
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

        Assertions.assertTrue(mainVinePage.menuBarOpenIsDisplayed());


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
        ChinaPage chinaPage = mainVinePage.clickToChina();
        chinaPage.waitToLoadChinaPage();

        Assertions.assertTrue(chinaPage.imageOnChinaPageIsDisplayed());
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

        ChinaPage chinaPage = mainVinePage.clickToChina();
        chinaPage.waitToWeiboLogoIsDisplayed();

        chinaPage.clickToWeiboLogo();


        Assertions.assertTrue(chinaPage.getCurrentUrl().equals("???https://yellowtailChina"));
    }

    //8
    @Test
    public void whereToBuyValidZipCode() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.welcomePageAllAction();

        MainVinePage mainVinePage = welcomePage.clickToSubmitButton();
        mainVinePage.waitForMenuBar();
        mainVinePage.clickToMenuBar();

        WhereToBuyPage whereToBuyPage = mainVinePage.clickToWereToBuy();

        whereToBuyPage.clickToInputFieldLocationName();

        Assertions.assertTrue(whereToBuyPage.searchResults.get(0).getText().contains("Sydney"));
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

        Assertions.assertEquals(wineCocktailsPage.numbersRedWine, wineCocktailsPage.countElementsRedWine());
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

        Assertions.assertTrue(wineCocktailsPage.getCurrentUrl().contains(wineCocktailsPage.getRaspberryrRoseWine()));
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

        Assertions.assertTrue(wineCocktailsPage.redWineCheckedIsDisplayed());
        Assertions.assertTrue(wineCocktailsPage.sparkWineCheckedIsDisplayed());

        Assertions.assertEquals(wineCocktailsPage.numberOfCoctailsPost, wineCocktailsPage.countElementsRedAndSparklingWine());

    }

}
