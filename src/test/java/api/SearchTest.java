package api;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest {

    @Test
    public void testSearchCarModel() {
        String query = "BMW дизель";
        String carModel = "BMW";

        ValidatableResponse response = GetCarsBmwAllRequest.perform(query)
                .statusCode(200);

        String title = response.extract().body().htmlPath().get("html.head.title").toString();
        System.out.println(title);

        Assert.assertTrue(title.contains(carModel), "Не найдена марка машин " + carModel);
    }
}