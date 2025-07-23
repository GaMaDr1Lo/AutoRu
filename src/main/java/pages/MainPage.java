package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    @FindBy(xpath = "//a [contains (@class,'HeaderUserMenu__loginButton')]/span")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='HeaderUserMenu__avatar']")
    private WebElement avatarProfile;
    @FindBy(xpath = "//div[contains(@class,'SearchLineSuggest__inputControl')]//input")
    private WebElement searchInput;
    @FindBy(xpath = "//div[contains(@class,'ListingHead')]//span")
    private WebElement searchPageTitle;
    @FindBy(xpath = "//div[contains(@class,'IndexMarks__col')]//div[contains(@class,'IndexMarks')][1]")
    private List<WebElement> carsModels;
    @FindBy(xpath = "//div[contains(@class,'SearchLineSuggestItem__title')]")
    private WebElement searchDropDown;
    @FindBy(xpath = "//div[@class='SearchLineSuggest__emptyResult']")
    private WebElement validationMessage;

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

    public List<String> getCarsModels() {
        List<String> carsModelsNames = new ArrayList<>();
       for (WebElement carModel: carsModels) {
           carsModelsNames.add(carModel.getText());
       }
       return carsModelsNames;
    }

    public void setAnnouncement(String announcementValue) {
        searchInput.isDisplayed();
        searchInput.click();
        searchInput.sendKeys(announcementValue);
        logger.info("Введен поисковой запрос '" + announcementValue);

    }

    public void confirmSearch(String announcementValue) {
        if(searchDropDown.getText().equals(announcementValue)) {
            searchDropDown.click();
            logger.info("В поисковой строке выбран автомобиль марки " + announcementValue);
        }
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

    public String getSearchPageTitle() {
        return searchPageTitle.getText();
    }
}
