import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.YandexPassportAuthorizationPage;

public class AuthorizationByYandexTest extends BaseTest {

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAuthorizationPage();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        YandexPassportAuthorizationPage yandexPassport = new YandexPassportAuthorizationPage(driver);
        authorizationPage.openAuthorizationByYandex();
        yandexPassport.setLogin(config.login());
        yandexPassport.setPassword(config.password());
        mainPage.checkLogin();
    }

    @Test
    public void testIncorrectLoginNegative() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAuthorizationPage();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        YandexPassportAuthorizationPage yandexPassport = new YandexPassportAuthorizationPage(driver);
        authorizationPage.openAuthorizationByYandex();
        yandexPassport.setLogin("123");
        String errorMessage = yandexPassport.getValidationMessage();

        Assert.assertEquals(errorMessage, "Такой логин не подойдет",
                "Не отобразилось сообщение 'Такой логин не подойдет'");
    }

    @Test
    public void testEmptyLoginNegative() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAuthorizationPage();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        YandexPassportAuthorizationPage yandexPassport = new YandexPassportAuthorizationPage(driver);
        authorizationPage.openAuthorizationByYandex();
        yandexPassport.setLogin("");
        String errorMessage = yandexPassport.getValidationMessage();

        Assert.assertEquals(errorMessage, "Логин не указан",
                "Не отобразилось сообщение 'Логин не указан'");
    }
}
