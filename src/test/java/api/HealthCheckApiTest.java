package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HealthCheckApiTest {

    @Test
    public void healthCheck_returns200() {
        // Keep API smoke checks fast; use them to gate UI runs if desired.
        RestAssured.baseURI = "https://httpbin.org";

        given()
            .when()
            .get("/status/200")
            .then()
            .statusCode(200);
    }
}
