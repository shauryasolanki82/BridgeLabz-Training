import java.util.Scanner;
class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;
    void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    void displayTicket() {
        if (isBooked) {
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();
        ticket.displayTicket();
        System.out.print("Enter movie name: ");
        String movie = sc.nextLine();
        System.out.print("Enter seat number: ");
        String seat = sc.nextLine();
        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();
        ticket.bookTicket(movie, seat, price);
        ticket.bookTicket(movie, seat, price);
        ticket.displayTicket();
        sc.close();
    }
}
