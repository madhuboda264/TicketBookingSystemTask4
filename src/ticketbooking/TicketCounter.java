package ticketbooking;

public class TicketCounter {
    private int availableTickets;

    public TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public synchronized void bookTicket(String customerName) {
        if (availableTickets > 0) {
            System.out.println(customerName + " is booking a ticket.");
            availableTickets--;
            System.out.println("Booking successful for " + customerName);
            System.out.println("Remaining tickets: " + availableTickets);
            System.out.println("------------------------------");
        } else {
            System.out.println("Booking failed for " + customerName
                    + ": No tickets available.");
        }
    }

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }
}
