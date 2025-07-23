import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.ProjectConfig;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setup() {
        openBrowser();
    }

    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.url());
        logger.info("Страница https://auto.ru/ открыта");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
        logger.info("Браузер закрыт");
    }

    public void closeBrowser() {
        driver.quit();
    }
}
