import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DriverProvider;
import utils.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class JunitRunner {
    @BeforeEach
    public void beforeEachFunction(){

        DriverProvider.getDriver().get(Constant.BASIC_URL);
        DriverProvider.getDriver().manage().window().maximize();
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterEach
    public void after(){ DriverProvider.getDriver().quit(); }

    public void makeScreenshot() {
        Path target = Paths.get("screenshots/temp.png");
        File source = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(source.toPath(),target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File was not download");
        }
    }

}

