package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.APIPath;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class AuthTokenTest extends BaseTest {

    public static String token;

    @Test
    public void createToken() {

        String body = "{ \"username\": \"" + ConfigReader.get("username") +
                      "\", \"password\": \"" + ConfigReader.get("password") + "\" }";

        token =
            given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post(APIPath.AUTH)
            .then()
                .statusCode(200)
                .extract()
                .path("token");

        System.out.println("Token = " + token);
    }
}
