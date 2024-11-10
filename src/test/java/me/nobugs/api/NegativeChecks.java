package me.nobugs.api;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class NegativeChecks {
    public static void ensureUserDoesNotExist(String id) {
        given()
        .when()
                .get("/student/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
