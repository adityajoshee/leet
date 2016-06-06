package com.booking.entities;

import com.booking.services.BookingService;

/**
 * Created by adityajoshee on 22/05/16.
 */
public class ReservationRequest extends Request {

    private int qty;           // every client request will have qty of tickets to book
    private Passenger passenger;
    private BookingService bookingService; // shared resource
    private boolean status;
    public ReservationRequest(int qty, Passenger passenger, BookingService bookingService){
        this.qty  = qty;
        this.passenger = passenger;
        this.bookingService = bookingService;
    }

    @Override
    public void run(){
        System.out.println("Booking in process: Thread:"+Thread.currentThread().getName()+", Passenger:"+passenger.getName());
        boolean result = false;
        try{
            result = bookingService.bookTicket(qty);
        }
        catch (Exception e){
            System.err.print("Concurrency Error:"+ Thread.currentThread().getName());
        }
        this.setStatus(result);
        if(result){
            System.out.println("Booking Success: Thread:"+Thread.currentThread().getName()+", Passenger:"+passenger.getName());
        }
        else{
            System.out.println("Booking Failure: Thread:"+Thread.currentThread().getName()+", Passenger:"+passenger.getName());
        }
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public boolean isStatus() {
        return status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }
}
