package scenario_based.hotel_reservation_system;

public abstract class Room {
    protected int roomNumber;
    protected double basePrice;
    protected boolean isOccupied;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.isOccupied = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public double getBasePrice() { return basePrice; }
    public boolean isOccupied() { return isOccupied; }

    public void setOccupied(boolean status) {
        this.isOccupied = status;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [Price: $" + basePrice + "]";
    }
}
