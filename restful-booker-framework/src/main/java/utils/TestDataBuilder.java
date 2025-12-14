package utils;

import payloads.BookingPayload;

public class TestDataBuilder {

    public static BookingPayload createBookingPayload() {
        BookingPayload payload = new BookingPayload();
        payload.firstname = "Pratiksha";
        payload.lastname = "Kaninde";
        payload.totalprice = 5000;
        payload.depositpaid = true;

        BookingPayload.BookingDates dates = new BookingPayload.BookingDates();
        dates.checkin = "2025-01-01";
        dates.checkout = "2025-01-05";
        payload.bookingdates = dates;

        payload.additionalneeds = "Breakfast";
        return payload;
    }
}
