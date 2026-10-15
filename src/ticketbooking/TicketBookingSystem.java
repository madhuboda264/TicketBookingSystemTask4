package ticketbooking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TicketBookingSystem {

    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(3);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            String[] customers = {
                    "Madhu",
                    "Arun",
                    "Priya",
                    "Rahul",
                    "Sneha"
            };

            for (String customer : customers) {
                executor.submit(
                        new BookingTask(customer, ticketCounter)
                );
            }

        } finally {
            executor.shutdown();

            try {
                if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                    executor.shutdownNow();

                    if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                        System.out.println(
                                "Some booking tasks did not terminate."
                        );
                    }
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
                System.out.println("Waiting for bookings was interrupted.");
            }
        }

        System.out.println("\n<--------------- BOOKING SUMMARY ---------------->");
        System.out.println("Available tickets: "
                + ticketCounter.getAvailableTickets());
        System.out.println("Booking process completed.");
    }
}