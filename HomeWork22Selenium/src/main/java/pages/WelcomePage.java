package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class WelcomePage extends AbstractPage{

    public WelcomePage() {
        super();
    }

   @FindBy(css = "div.confirmation-checkbox > label")
    private WebElement checkLegalDrink;

    

    public void clickOnCheckLegalDrink() {
        checkLegalDrink.click();
    }

    @FindBy(css ="#agegate-selector-options")
    private WebElement chooseCountry;

    public void waitForAgeGateSelector(){
        Waiters.waitForElementToBeVisible(chooseCountry);
    }

    public void clickOnCountrySelector(){
       chooseCountry.click();
    }
    @FindBy(css ="[value=\"eu\"]")
    private WebElement chooseEurope;
    public void waitForCountryListOpen(){
        Waiters.waitForElementToBeVisible(chooseEurope);
    }

    public void chooseEuropeInList(){
        chooseEurope.click();
    }

    @FindBy(css = "[type=\"submit\"]")
    private WebElement welcomeButtonPush;
    public void waitWhenSubmitButtonIsActive(){
        Waiters.waitForElementToBeVisible(welcomeButtonPush);
       }

    public MainVinePage clickToSubmitButton(){
        welcomeButtonPush.click();
        return new MainVinePage();
    }

    public void welcomePageAllAction(){
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickOnCheckLegalDrink();

        welcomePage.waitForAgeGateSelector();

        welcomePage.clickOnCountrySelector();

        welcomePage.waitForCountryListOpen();

        welcomePage.chooseEuropeInList();

        welcomePage.waitWhenSubmitButtonIsActive();

        //welcomePage.clickToSubmitButton();
    }

}
