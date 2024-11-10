package me.nobugs.api;

import me.nobugs.api.models.Unicorn;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ChecksForApiTests {
    public static void ensureEntityDoesNotExist(String endpoint, String id) {
        given()
        .when()
                .get("/" + endpoint.toLowerCase() + "/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    public static void verifyUnicorn(Unicorn expectedUnicorn) {
        given()
        .when()
                .get("/unicorn/" + expectedUnicorn.getId())
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body("tailColor", equalTo(expectedUnicorn.getTailColor().name()));
    }
}
