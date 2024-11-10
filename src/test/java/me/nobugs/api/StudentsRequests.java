package me.nobugs.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import me.nobugs.api.models.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentsRequests {

    public static Student createStudent(Student student) {
        String studentJson = serializeToJson(student);

        return given()
                .body(studentJson)
                .contentType(ContentType.JSON)
       .when()
                .post("/student/")
       .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().as(Student.class, ObjectMapperType.GSON);
    }

    public static void deleteStudent(String id) {
        given()
        .when()
                .delete("/student/" + id)
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
