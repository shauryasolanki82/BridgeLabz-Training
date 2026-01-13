package scenario_based.hotel_reservation_system;
import java.util.*;

public class HotelService {
    private List<Room> rooms;

    public HotelService() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }
    
    public void bookRoom(int roomNumber, Guest guest, int nights, PricingStrategy strategy) throws RoomNotAvailableException {
        Room targetRoom = null;
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                targetRoom = r;
                break;
            }
        }
        if (targetRoom == null) {
            System.out.println("Room " + roomNumber + " does not exist.");
            return;
        }
        if (targetRoom.isOccupied()) {
            throw new RoomNotAvailableException("Room " + roomNumber + " is already occupied.");
        }
        targetRoom.setOccupied(true);
        double totalBill = strategy.calculateBill(targetRoom.getBasePrice(), nights);
        System.out.println("Booking Success");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room: " + targetRoom.getClass().getSimpleName() + " " + roomNumber);
        System.out.println("Nights: " + nights);
        System.out.println("Total Bill: $" + totalBill);
    }
    
    public void checkOut(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                if (r.isOccupied()) {
                    r.setOccupied(false);
                    System.out.println("Room " + roomNumber + " has been checked out.");
                } else {
                    System.out.println("Room " + roomNumber + " was not occupied.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }
}
