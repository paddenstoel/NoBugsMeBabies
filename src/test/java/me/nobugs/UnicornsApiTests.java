package me.nobugs;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import me.nobugs.api.ChecksForApiTests;
import me.nobugs.api.models.TailColor;
import me.nobugs.api.requests.UnicornsRequests;
import me.nobugs.api.models.Unicorn;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UnicornsApiTests {

    @BeforeAll
    public static void setupTests() {
        SSLConfig sslConfig = new SSLConfig().relaxedHTTPSValidation();
        RestAssured.config = RestAssured.config().sslConfig(sslConfig);
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/4682fdc2e8a14952afdabc7a0c8e2287";
    }

    @Test
    public void userShouldBeAbleToGetAllUnicorns() {
        given()
        .when()
                .get("/unicorn/")
        .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = Unicorn.builder()
                .name("Карамелька")
                .tailColor(TailColor.PINK)
                .build();

        UnicornsRequests.createUnicorn(unicorn);
    }

    @Test
    public void userShouldBeAbleToUpdateUnicorn() {
        Unicorn unicorn = Unicorn.builder()
                .name("Искорка")
                .tailColor(TailColor.GREEN)
                .build();

        Unicorn createdUnicorn = UnicornsRequests.createUnicorn(unicorn);
        createdUnicorn.setTailColor(TailColor.RED);

        UnicornsRequests.updateUnicorn(createdUnicorn);

        ChecksForApiTests.verifyUnicorn(createdUnicorn);
    }

    @Test
    public void userShouldBeAbleToDeleteUnicorn() {
        Unicorn unicorn = Unicorn.builder()
                .name("Капелька")
                .tailColor(TailColor.WHITE)
                .build();

        Unicorn createdUnicorn = UnicornsRequests.createUnicorn(unicorn);
        UnicornsRequests.deleteUnicorn(createdUnicorn.getId());

        ChecksForApiTests.ensureEntityDoesNotExist("unicorn", createdUnicorn.getId());
    }
}
