package scenario_based.flight_booking_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightService service = new FlightService();
        boolean running = true;

        System.out.println("Flight Booking System");

        while (running) {
            System.out.println("1. Search Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. View My Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String src = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = scanner.nextLine();
                    service.searchFlights(src, dest);
                    break;
                case 2:
                    System.out.print("Enter Flight ID to book: ");
                    int id = scanner.nextInt();
                    service.bookFlight(id);
                    break;
                case 3:
                    service.displayBookings();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using Flight App.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
