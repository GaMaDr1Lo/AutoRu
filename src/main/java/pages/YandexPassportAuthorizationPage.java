package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPassportAuthorizationPage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginInput;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div [@id='field:input-login:hint']")
    private WebElement validationMessage;

    public YandexPassportAuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String login) {
        loginInput.isDisplayed();
        loginInput.sendKeys(login);
        submitButton.click();
    }

    public void setPassword(String password) {
        passwordInput.isDisplayed();
        passwordInput.sendKeys(password);
        submitButton.click();

    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }
}
