package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    @FindBy(xpath = "//span[@id='autoru']")
    private WebElement autoRuLoginButton;

    @FindBy(xpath = "//div [contains (@class, 'Button2__content')]")
    private WebElement yandexLoginButton;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement autoRuLoginInput;

    @FindBy(xpath = "//button [@type='submit']")
    private WebElement getSubmitButtonAutoRu;

    @FindBy(xpath = "//div [@class='Input2__error-_6b_n']")
    private WebElement validationMessageFromAutoRu;

    @FindBy(xpath = "//div [contains (@class, 'AuthFormCodeInput__text')]")
    private WebElement emailCodeConfirm;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openAuthorizationByYandex() {
        yandexLoginButton.isDisplayed();
        yandexLoginButton.click();
    }

    public String getValidationMessageAutoRU() {
        return validationMessageFromAutoRu.getText();
    }

    public void openAuthorizationByAutoRu() {
        autoRuLoginButton.isDisplayed();
        autoRuLoginButton.click();
    }

    public void setLoginAutoRu(String login) {
        autoRuLoginInput.isDisplayed();
        autoRuLoginInput.sendKeys(login);
        getSubmitButtonAutoRu.click();
    }

    public void checkCodeConfirm() {
        emailCodeConfirm.isDisplayed();
    }
}
