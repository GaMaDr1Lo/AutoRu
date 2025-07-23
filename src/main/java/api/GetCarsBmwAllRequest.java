package api;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import setup.ProjectConfig;

import static io.restassured.RestAssured.given;

public class GetCarsBmwAllRequest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    private static String url = config.url() + "cars/bmw/all/";

    public static ValidatableResponse perform(String query) {
        return given()
                .queryParam("query", query)
                .queryParam("from", "searchline")
                .get(url)
                .then();
    }
}
