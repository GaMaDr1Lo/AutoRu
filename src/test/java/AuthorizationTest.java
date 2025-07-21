import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainPage;

public class AuthorizationTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        openBrowser();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void testLoginWithAutoRuPositive() {
        MainPage mainPage = new MainPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        mainPage.openAuthorizationPage();
        authorizationPage.openAuthorizationAutoRu();
        authorizationPage.setLogin(config.login());
    }

    @Test
    public void testLoginWithAutoRuNegative() {
        MainPage mainPage = new MainPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        mainPage.openAuthorizationPage();
        authorizationPage.openAuthorizationAutoRu();
        authorizationPage.setLogin("1");
    }
}
