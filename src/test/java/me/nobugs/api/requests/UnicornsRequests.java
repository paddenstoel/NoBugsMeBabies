package me.nobugs.api.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import me.nobugs.api.models.Unicorn;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornsRequests {

    public static Unicorn createUnicorn(Unicorn unicorn) {
        String unicornJson = serializeToJson(unicorn);

        return given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn/")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().as(Unicorn.class, ObjectMapperType.GSON);
    }

    public static void deleteUnicorn(String id) {
        given()
        .when()
                .delete("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicorn(Unicorn createdUnicorn) {
        String updatedUnicornJson = serializeToJson(createdUnicorn);

        given()
                .body(updatedUnicornJson)
                .contentType(ContentType.JSON)
        .when()
                .put("/unicorn/" + createdUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    private static String serializeToJson(Object obj) {
        String objJson;

        try {
            objJson = new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }

        return objJson;
    }
}
