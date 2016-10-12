package design.booking.services;

/**
 * Created by adityajoshee on 22/05/16.
 */
public class BookingService {

    private static BookingService instance = null;  // lazy init
    private static int availableTickets;
    private static int partialBooking=0;

    private BookingService(){
    }

    // Get lazy init singleton
    public static BookingService getService(int availableTickets){
        if(instance!=null){
            return instance;
        }
        synchronized (BookingService.class){
            if(instance!=null){
                return instance;
            }
            instance = new BookingService();
            instance.setAvailableTickets(availableTickets);
            return instance;
        }
    }


    public static int getAvailableTickets() {
        return availableTickets;
    }

    private static void setAvailableTickets(int availableTickets) {
        BookingService.availableTickets = availableTickets;
    }


    public synchronized boolean bookTicket(int qty) throws Exception{
        if(availableTickets>=qty){
            partialBooking++;
            System.out.println("Partial Booking Count: "+ partialBooking);
            Thread.sleep(200L); // processing...transcation...fraud check...debit..persistence...logging etc...
            availableTickets-=qty;
            System.out.println("Booking Tickets: "+ qty);
            System.out.println("Available Now : "+ availableTickets);
            return true;
        }
        return false;
    }

}
