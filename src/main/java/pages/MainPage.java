package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//a [contains (@class,'HeaderUserMenu__loginButton')]/span")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='HeaderUserMenu__avatar']")
    private WebElement avatarProfile;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openAuthorizationPage() {
        loginButton.isDisplayed();
        loginButton.click();
    }

    public void checkLogin() {
        avatarProfile.isDisplayed();
    }
}
