package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class WelcomePage extends AbstractPage{

    public WelcomePage() {
        super();
    }

   @FindBy(css = "div.confirmation-checkbox > label")
    private WebElement checkLegalDrink;

    @FindBy(css ="#agegate-selector-options")
    private WebElement chooseCountry;

    @FindBy(css = "[type=\"submit\"][disabled]")
    private WebElement submitButtonIsDisabled;

    @FindBy(css ="[value=\"eu\"]")
    private WebElement chooseEurope;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement welcomeButtonPush;


    public void clickOnCheckLegalDrink() {
        checkLegalDrink.click();
    }

    public boolean checkLegalDrinkIsDisplayed(){
        checkLegalDrink.isDisplayed();
        return true;
    }

    public boolean chooseCountryIsDisplayed(){
        chooseCountry.isDisplayed();
        return true;
    }

    public boolean submitButtonIsDisabled(){
        submitButtonIsDisabled.isDisplayed();
        return true;
    }

    public void waitForAgeGateSelector(){
        Waiters.waitForElementToBeVisible(chooseCountry);
    }

    public void clickOnCountrySelector(){
       chooseCountry.click();
    }

    public void waitForCountryListOpen(){
        Waiters.waitForElementToBeVisible(chooseEurope);
    }

    public void chooseEuropeInList(){
        chooseEurope.click();
    }

    public void waitWhenSubmitButtonIsActive(){
        Waiters.waitForElementToBeVisible(welcomeButtonPush);
       }

    public MainVinePage clickToSubmitButton(){
        welcomeButtonPush.click();
        return new MainVinePage();
    }

    public void welcomePageAllAction(){
        clickOnCheckLegalDrink();

        waitForAgeGateSelector();

        clickOnCountrySelector();

        waitForCountryListOpen();

        chooseEuropeInList();

        waitWhenSubmitButtonIsActive();

    }

}
