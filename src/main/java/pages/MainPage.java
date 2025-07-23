package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//a [contains (@class,'HeaderUserMenu__loginButton')]/span")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='HeaderUserMenu__avatar']")
    private WebElement avatarProfile;
    @FindBy(xpath = "//div[contains(@class,'SearchLineSuggest__inputControl')]//input")
    private WebElement searchInput;

    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openAuthorizationPage() {
        loginButton.isDisplayed();
        loginButton.click();
        logger.info("Открыта страница главной авторизации");
    }

    public boolean isAvatarDisplayed() {
        return avatarProfile.isDisplayed();
    }

    public void startSearchMoto(String motoName) {
        searchInput.isDisplayed();
        searchInput.click();
        searchInput.sendKeys(motoName);
        logger.info("Запуск поиска мотокицла");
        searchInput.submit();
    }
}
