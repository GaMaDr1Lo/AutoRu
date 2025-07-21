import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import setup.ProjectConfig;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(config.url());
    }

    public void closeBrowser() {
        driver.quit();
    }
}
