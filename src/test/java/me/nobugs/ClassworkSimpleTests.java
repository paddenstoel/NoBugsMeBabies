package me.nobugs;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import me.nobugs.api.ChecksForApiTests;
import me.nobugs.api.requests.StudentsRequests;
import me.nobugs.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClassworkSimpleTests {

    @BeforeAll
    public static void setupTests() {
        SSLConfig sslConfig = new SSLConfig().relaxedHTTPSValidation();
        RestAssured.config = RestAssured.config().sslConfig(sslConfig);
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/c022c2a0ea484d098ed510a5f9d1ff49";
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        Student student = Student.builder()
                .name("Ирина Злоебучая")
                .grade(2)
                .build();

        StudentsRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        Student student = Student.builder()
                .name("Елена Пахучая")
                .grade(3)
                .build();

        Student createdStudent = StudentsRequests.createStudent(student);

        StudentsRequests.deleteStudent(createdStudent.getId());
        ChecksForApiTests.ensureEntityDoesNotExist("student", createdStudent.getId());
    }
}

// ПРИНЦИПЫ РАЗРАБОТКИ API ТЕСТОВ:
// 1. АТОМАРНОСТЬ
// 2. ТЕСТ САМ СЕБЕ ГОТОВИТ ДАННЫЕ