import java.time.LocalDateTime;

// Node representing a Ticket
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               String seatNumber, LocalDateTime bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular Linked List for Ticket Reservation
class TicketReservationSystem {
    private TicketNode tail = null;

    // 1. Add new ticket at the end
    public void addTicket(int id, String customer, String movie,
                          String seat, LocalDateTime time) {

        TicketNode newTicket = new TicketNode(id, customer, movie, seat, time);

        if (tail == null) {
            tail = newTicket;
            tail.next = tail;   // Circular link
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully.");
    }

    // 2. Remove ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode curr = tail.next;
        TicketNode prev = tail;

        do {
            if (curr.ticketId == ticketId) {

                // Only one node
                if (curr == tail && curr.next == tail) {
                    tail = null;
                }
                // Removing tail
                else if (curr == tail) {
                    prev.next = curr.next;
                    tail = prev;
                }
                // Removing other node
                else {
                    prev.next = curr.next;
                }

                System.out.println("Ticket removed successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        System.out.println("Ticket ID not found.");
    }

    // 3. Display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = tail.next;
        System.out.println("---- Current Booked Tickets ----");
        do {
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Customer: " + temp.customerName);
            System.out.println("Movie: " + temp.movieName);
            System.out.println("Seat: " + temp.seatNumber);
            System.out.println("Time: " + temp.bookingTime);
            System.out.println("--------------------------------");
            temp = temp.next;
        } while (temp != tail.next);
    }

    // 4. Search ticket by Customer Name or Movie Name
    public void searchTicket(String key) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = tail.next;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(key)
                    || temp.movieName.equalsIgnoreCase(key)) {

                System.out.println("Ticket Found:");
                System.out.println("Ticket ID: " + temp.ticketId +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName);
                found = true;
            }
            temp = temp.next;
        } while (temp != tail.next);

        if (!found)
            System.out.println("No matching ticket found.");
    }

    // 5. Count total booked tickets
    public int countTickets() {
        if (tail == null)
            return 0;

        int count = 0;
        TicketNode temp = tail.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != tail.next);

        return count;
    }
}

// Main Class
public class OnlineTicketReservationSystem {
    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Inception", "A1", LocalDateTime.now());
        system.addTicket(102, "Bob", "Avatar", "B2", LocalDateTime.now());
        system.addTicket(103, "Charlie", "Inception", "C3", LocalDateTime.now());

        system.displayTickets();

        system.searchTicket("Inception");

        system.removeTicket(102);
        system.displayTickets();

        System.out.println("Total Tickets Booked: " + system.countTickets());
    }
}
