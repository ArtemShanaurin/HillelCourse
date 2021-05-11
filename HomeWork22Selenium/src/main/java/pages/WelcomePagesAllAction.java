package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePagesAllAction {
   /* WebDriver driver;

    public WelcomePagesAllAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCheckLegalDrink() {

        By legalDrinkAge = By.cssSelector("div.confirmation-checkbox > label");
        WebElement checkLegalDrink = driver.findElement(legalDrinkAge);
        checkLegalDrink.click();

    }

    public void waitForAgeGateSelector(){
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#agegate-selector-options")));

    }

    public void clickOnCountrySelector(){
        By selectCountry = By.cssSelector("#agegate-selector-options");
        WebElement chooseCountry = driver.findElement(selectCountry);
        chooseCountry.click();
    }

    public void waitForCountryListOpen(){
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[value=\"eu\"]")));
    }

    public void chooseEuropeInList(){
        By chooseEurope = By.cssSelector("[value=\"eu\"]");
        WebElement europe = driver.findElement(chooseEurope);
        europe.click();
    }

    public void waitWhenSubmitButtonIsActive(){
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
    }

    public void clickToSubmitButton(){
        By welcomeButton = By.cssSelector("[type=\"submit\"]");
        WebElement welcomeButtonPush = driver.findElement(welcomeButton);
        welcomeButtonPush.click();
    }

    public void allActionWelcomePage(){
        WelcomePagesAllAction welcomePagesAllAction = new WelcomePagesAllAction(driver);

        welcomePagesAllAction.clickOnCheckLegalDrink();

        welcomePagesAllAction.waitForAgeGateSelector();

        welcomePagesAllAction.clickOnCountrySelector();

        welcomePagesAllAction.waitForCountryListOpen();

        welcomePagesAllAction.chooseEuropeInList();

        welcomePagesAllAction.waitWhenSubmitButtonIsActive();

        welcomePagesAllAction.clickToSubmitButton();
    }

*/
}
