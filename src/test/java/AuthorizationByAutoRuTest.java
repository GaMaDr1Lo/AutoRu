import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainPage;

public class AuthorizationByAutoRuTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        openBrowser();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        mainPage.openAuthorizationPage();
        authorizationPage.openAuthorizationByAutoRu();
        authorizationPage.setLoginAutoRu(config.login());
        authorizationPage.checkCodeConfirm();
    }

    @Test
    public void testIncorrectLoginNegative() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        mainPage.openAuthorizationPage();
        authorizationPage.openAuthorizationByAutoRu();
        authorizationPage.setLoginAutoRu("TestNegative");
        String errorMessage = authorizationPage.getValidationMessageAutoRU();

        Assert.assertEquals(errorMessage, "Укажите телефон или почту",
                "Не отобразилось сообщение 'Укажите телефон или почту'");
    }
}
