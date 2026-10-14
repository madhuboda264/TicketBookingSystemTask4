# Ticket Booking System

## 1. Project Overview
A Java application that demonstrates multithreading by allowing multiple
customers to book tickets concurrently. Synchronization prevents
overbooking when multiple customers access the same ticket counter.

## 2. Technologies Used
- Java 21
- IntelliJ IDEA Community Edition

## 3. Project Structure
- `TicketBookingSystem.java` – Accepts user input and manages booking tasks.
- `TicketCounter.java` – Manages available tickets and ensures thread safety.
- `BookingTask.java` – Represents each customer's booking request.

## 4. Key Features
- User input and input validation
- Multithreading using `Runnable`
- Thread management using `ExecutorService`
- Synchronization to prevent overbooking
- Exception handling
- Proper executor shutdown and resource management

## 5. How It Works
1. The user enters the number of tickets and customers.
2. The program creates a shared ticket counter.
3. Booking tasks are submitted to a thread pool.
4. Synchronized methods safely process booking requests.
5. Customers receive success or failure messages.
6. The program displays the final available ticket count.

## 6. Test Case

**Test Case ID:** TC-01

**Objective:** Verify that the system prevents overbooking.

**Input:**
- Total tickets: 3
- Total customers: 5
- Customer names: Arun, Sneha, Rahul, Priya, Madhu

**Expected Result:**
- 3 successful bookings
- 2 failed bookings
- Final available tickets: 0
- No overbooking

**Actual Result:** As shown in the program output, three customers
booked successfully, two bookings failed, and zero tickets remained.

**Status:** PASS

**Explanation:** The `synchronized` booking method ensures that
multiple threads cannot book more tickets than are available.
The order of customer results may vary because tasks run concurrently.

## 7. Conclusion
This project demonstrates Java multithreading, concurrency,
synchronization, thread safety, exception handling, and resource
management through a practical ticket booking application.