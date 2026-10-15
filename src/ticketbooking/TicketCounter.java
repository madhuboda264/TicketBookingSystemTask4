package ticketbooking;

public class TicketCounter {
    private int availableTickets;
    public TicketCounter(int availableTickets){
        this.availableTickets=availableTickets;
    }
    public synchronized void bookTickert(String costumerName){
    if(availableTickets > 0){
        System.out.println(costumerName+ "is booking Tickert.");
        availableTickets--;
        System.out.println("Booking successful for "+costumerName);
        System.out.println(" Remaning Tickerts "+availableTickets);
        System.out.println("------------------------------");
    }else {
        System.out.println("Booking failed for "+costumerName +" : No Tickert Available. " );
    }
    }
    public synchronized int getAvailableTickets(){
        return availableTickets;
    }
}
