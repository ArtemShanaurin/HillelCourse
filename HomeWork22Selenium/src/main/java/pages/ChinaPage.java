package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class ChinaPage extends AbstractPage{
    public ChinaPage() {
        super();
    }

    @FindBy(css = "#image-comp-id-1533175598405")
    private WebElement imageOnChinaPage;

    @FindBy(css = ".sgg-comp-social-slot.social-weibo")
    private WebElement weiboLogo;

    public void waitToLoadChinaPage(){
        Waiters.waitForElementToBeVisible(imageOnChinaPage);
    }

    public void waitToWeiboLogoIsDisplayed(){
        Waiters.waitForElementToBeVisible(weiboLogo);
    }

    public void clickToWeiboLogo(){
        weiboLogo.click();
    }

    public boolean imageOnChinaPageIsDisplayed(){
        imageOnChinaPage.isDisplayed();
        return true;
    }
    public String currentUrl = DriverProvider.getDriver().getCurrentUrl();
}
