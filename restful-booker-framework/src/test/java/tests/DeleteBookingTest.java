package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.APIPath;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends BaseTest {

    @Test
    public void deleteBooking() {

        given()
            .cookie("token", AuthTokenTest.token)
        .when()
            .delete(APIPath.BOOKING + CreateBookingTest.bookingId)
        .then()
            .statusCode(201)
            .log().all();
    }
}
