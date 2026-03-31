package scenario_based.hotel_reservation_system;

public class Main {
    public static void main(String[] args) {
        HotelService hotel = new HotelService();
        hotel.addRoom(new StandardRoom(101));
        hotel.addRoom(new DeluxeRoom(201));
        Guest g1 = new Guest("John Doe", "ID_123");
        Guest g2 = new Guest("Jane Smith", "ID_456");
        PricingStrategy regular = new RegularPricing();
        PricingStrategy holiday = new SeasonalPricing();

        try {
            System.out.println("Booking Standard Room (Regular Price)");
            hotel.bookRoom(101, g1, 3, regular);
            System.out.println("\nBooking Deluxe Room (Holiday Season)");
            hotel.bookRoom(201, g2, 2, holiday);
            System.out.println("\nAttempting to double-book Room 101");
            hotel.bookRoom(101, g2, 1, regular);

        } catch (RoomNotAvailableException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println("Checkout Process");
        hotel.checkOut(101);
        try {
             System.out.println("Retrying booking for Room 101");
             hotel.bookRoom(101, g2, 1, regular);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
