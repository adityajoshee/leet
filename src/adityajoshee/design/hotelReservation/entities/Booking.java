package adityajoshee.design.hotelReservation.entities;

import adityajoshee.design.hotelReservation.enums.booking.BookingStatus;

import java.util.Date;

/**
 * Created by aditya on 11/30/16.
 */
public class Booking {
    private Integer id;
    private Room room;
    private Customer customer;
    private Date checkIn;
    private Date checkOut;
    private BookingStatus bookingStatus;
    private Payment payment;
}
