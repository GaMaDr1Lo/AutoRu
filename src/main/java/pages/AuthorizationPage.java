package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage {
//    @FindBy(xpath = "//span[@id='autoru']")
    @FindBy(xpath = "//div [contains (@class, 'Button2__content-eyTVN')]")
    private WebElement yandexLoginButton;
//    @FindBy(xpath = "//input[@name='login']")
    @FindBy(xpath = "//input[@type='text']")
    private WebElement yandexLoginInput;
//    @FindBy(xpath = "//button [@type='submit']")
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement yandexPasswordInput;


    public void openAuthorizationAutoRu() {
        yandexLoginButton.isDisplayed();
        yandexLoginButton.click();
    }

    public void setLogin(String login) {
        yandexLoginInput.isDisplayed();
        yandexLoginInput.sendKeys(login);
        submitButton.click();
    }
    public void setPassword(String password){
        yandexPasswordInput.isDisplayed();
        yandexPasswordInput.sendKeys(password);
        submitButton.click();
    }
}
