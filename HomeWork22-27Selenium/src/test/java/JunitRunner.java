import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DriverProvider;
import utils.Constant;

import java.time.Duration;

public class JunitRunner {
    @BeforeEach
    public void beforeEachFunction(){

        DriverProvider.getDriver().get(Constant.BASIC_URL);
        DriverProvider.getDriver().manage().window().maximize();
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterEach
    public void after(){
        DriverProvider.getDriver().quit();
    }

}

