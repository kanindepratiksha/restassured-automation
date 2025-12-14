package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.APIPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetBookingTest extends BaseTest {

    @Test
    public void getBookingById() {

        given()
        .when()
            .get(APIPath.BOOKING + CreateBookingTest.bookingId)
        .then()
            .statusCode(200)
            .body("firstname", equalTo("WrongName")) // ❌ Intentional fail
            .body("lastname", equalTo("Kaninde"))
            .body("depositpaid", equalTo(true))
            .log().all();
    }
}
