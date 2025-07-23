package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchCar() {
        MainPage mainPage = new MainPage(driver);

        List<String> carsModelsNames = mainPage.getCarsModels();
        String firstCar = carsModelsNames.getFirst();

        mainPage.setAnnouncement(firstCar);
        mainPage.confirmSearch(firstCar);
        String searchPageTitle = mainPage.getSearchPageTitle();

        Assert.assertTrue(searchPageTitle.contains(firstCar), "Отобразился некорректный результат поиска");
    }

    @Test
    public void testSearchIncorrectValue() {
        MainPage mainPage = new MainPage(driver);
        String incorrectValue = "!@#";

        mainPage.setAnnouncement(incorrectValue);
        String message = mainPage.getValidationMessage();

        Assert.assertEquals(message,"Ничего не найдено", "Не отобразилось сообщение валидации");
    }
}
