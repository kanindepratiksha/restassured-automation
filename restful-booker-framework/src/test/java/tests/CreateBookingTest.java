package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import payloads.BookingPayload;
import utils.APIPath;
import utils.TestDataBuilder;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends BaseTest {

    public static int bookingId;

    @Test
    public void createBooking() {

        BookingPayload body = TestDataBuilder.createBookingPayload();

        bookingId =
            given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post(APIPath.BOOKING)
            .then()
                .statusCode(200)
                .log().all()
                .extract()
                .path("bookingid");
    }
}
