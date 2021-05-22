package pages;

import io.qameta.allure.Step;
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

    @Step("Click on the checkbox Legal drink Age")
    public void clickOnCheckLegalDrink() {
        checkLegalDrink.click();
    }

    @Step("Check is displayed checkbox Legal drink Age")
    public boolean checkLegalDrinkIsDisplayed(){
        checkLegalDrink.isDisplayed();
        return true;
    }

    @Step("Check is displayed dropbox for choosing country")
    public boolean chooseCountryIsDisplayed(){
        chooseCountry.isDisplayed();
        return true;
    }

    @Step("Check is displayed submit button")
    public boolean submitButtonIsDisabled(){
        submitButtonIsDisabled.isDisplayed();
        return true;
    }

    @Step("Wait for age gate selector is visible")
    public void waitForAgeGateSelector(){
        Waiters.waitForElementToBeVisible(chooseCountry);
    }

    @Step("Click at the country selector")
    public void clickOnCountrySelector(){
       chooseCountry.click();
    }

    @Step("Wait for country list is open")
    public void waitForCountryListOpen(){
        Waiters.waitForElementToBeVisible(chooseEurope);
    }

    @Step("Choose Europe in the country list")
    public void chooseEuropeInList(){
        chooseEurope.click();
    }

    @Step("Wait for Submit button is Active")
    public void waitWhenSubmitButtonIsActive(){
        Waiters.waitForElementToBeVisible(welcomeButtonPush);
       }

    @Step("Click at the Submit button is Active")
    public MainVinePage clickToSubmitButton(){
        welcomeButtonPush.click();
        return new MainVinePage();
    }

    @Step("Complete all required action at first page and going to the main page")
    public void welcomePageAllAction(){
        clickOnCheckLegalDrink();

        waitForAgeGateSelector();

        clickOnCountrySelector();

        waitForCountryListOpen();

        chooseEuropeInList();

        waitWhenSubmitButtonIsActive();

    }

}
