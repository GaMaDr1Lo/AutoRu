package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//a [contains (@class,'HeaderUserMenu__loginButton')]")
    private WebElement loginButton;

    public void openAuthorizationPage(){
        loginButton.isDisplayed();
        loginButton.click();
    }
}
