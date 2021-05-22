import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.DriverProvider;
import utils.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class TestNgRunner {
    @BeforeEach
    public void beforeEachFunction(){

        DriverProvider.INSTANCE.getDriver().get(Constant.BASIC_URL);
        DriverProvider.INSTANCE.getDriver().manage().window().maximize();
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterMethod(alwaysRun = true)
    public void after(ITestResult result){
        if (!result.isSuccess()) {
            makeScreenshot();
        }
        DriverProvider.INSTANCE.removeDriver(); }

    @Attachment(value = "Page screenshot", type = "image/png")
    byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}


