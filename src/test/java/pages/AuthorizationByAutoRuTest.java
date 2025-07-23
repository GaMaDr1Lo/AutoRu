package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationByAutoRuTest extends BaseTest {

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAuthorizationPage();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openAuthorizationByAutoRu();
        authorizationPage.setLoginAutoRu(config.login());
        boolean codeConfirmDisplayed = authorizationPage.isCodeConfirmDisplayed();

        Assert.assertTrue(codeConfirmDisplayed, "Ошибка авторизации");
    }

    @Test
    public void testIncorrectLoginNegative() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAuthorizationPage();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openAuthorizationByAutoRu();
        authorizationPage.setLoginAutoRu("TestNegative");
        String errorMessage = authorizationPage.getValidationMessageAutoRU();

        Assert.assertEquals(errorMessage, "Укажите телефон или почту",
                "Не отобразилось сообщение 'Укажите телефон или почту'");
    }
}
