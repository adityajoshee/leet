package design.booking;

import design.booking.entities.Passenger;
import design.booking.entities.ReservationRequest;
import design.booking.services.BookingService;

/**
 * Created by adityajoshee on 22/05/16.
 */
public class App {
    public static void main(String args[]){
        BookingService application = BookingService.getService(10);


        for(int r=0;r<15;r++){
            Passenger randomClient = new Passenger(r, "Client"+r);
            //Passenger B = new Passenger(202, "Priya");
            ReservationRequest clientA = new ReservationRequest(1, randomClient, application);
            //ReservationRequest clientB = new ReservationRequest(5, B, application);

            Thread threadA = new Thread(clientA);
            threadA.setName("Thread#"+r);
            //Thread threadB = new Thread(clientB);
            //threadB.setName("priya's request thread");

            threadA.start();
            //threadB.start();
        }



    }
}
