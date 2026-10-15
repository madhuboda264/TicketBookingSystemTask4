package ticketbooking;

public class BookingTask implements Runnable{
    private final String customerName;
    private final TicketCounter ticketCounter;
    public BookingTask(String customerName , TicketCounter ticketCounter){
        this.customerName= customerName;
        this.ticketCounter= ticketCounter;
    }
    @Override
    public void run() {
        try{
            ticketCounter.bookTickert(customerName);
        }catch (RuntimeException e){
            System.out.println("Booking error for "+ customerName+":"+e.getMessage());
        }
    }
}
