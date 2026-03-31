package scenario_based.hotel_reservation_system;

public class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}