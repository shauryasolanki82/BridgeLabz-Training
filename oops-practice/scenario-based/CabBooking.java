import java.util.ArrayList;
import java.util.List;

class User {
    private final String userName;
    private final String userID;

    User(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
}

class Driver {
    private final String driverName;
    private final String driverID;
    private boolean isAvailable = true;

    Driver(String driverName, String driverID) {
        this.driverName = driverName;
        this.driverID = driverID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookDriver() {
        isAvailable = false;
    }

    public void freeDriver() {
        isAvailable = true;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverID() {
        return driverID;
    }
}

enum RideStatus {
    BOOKED, COMPLETED, CANCELLED
}

class Ride {
    private final String rideId;
    private final User user;
    private Driver driver;                 // assigned later
    private final double distanceKm;
    private RideStatus status = RideStatus.BOOKED;
    private double fare;                   // computed on completion/booking

    Ride(String rideId, User user, double distanceKm) {
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be > 0");
        }
        this.rideId = rideId;
        this.user = user;
        this.distanceKm = distanceKm;
    }

    public String getRideId() { return rideId; }
    public User getUser() { return user; }
    public Driver getDriver() { return driver; }
    public double getDistanceKm() { return distanceKm; }
    public RideStatus getStatus() { return status; }
    public double getFare() { return fare; }

    public void assignDriver(Driver driver) {
        this.driver = driver;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void complete() {
        this.status = RideStatus.COMPLETED;
    }

    public void cancel() {
        this.status = RideStatus.CANCELLED;
    }
}

interface FareCalculator {
    double calculateFare(double distanceKm);
}

class NormalFareCalculator implements FareCalculator {
    private final double baseFare;
    private final double perKmRate;

    NormalFareCalculator(double baseFare, double perKmRate) {
        this.baseFare = baseFare;
        this.perKmRate = perKmRate;
    }

    @Override
    public double calculateFare(double distanceKm) {
        return baseFare + (perKmRate * distanceKm);
    }
}

class PeakFareCalculator implements FareCalculator {
    private final FareCalculator delegate;
    private final double multiplier; // e.g., 1.5x during peak

    PeakFareCalculator(FareCalculator delegate, double multiplier) {
        this.delegate = delegate;
        this.multiplier = multiplier;
    }

    @Override
    public double calculateFare(double distanceKm) {
        return delegate.calculateFare(distanceKm) * multiplier;
    }
}

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

class RideService {
    private final List<Driver> drivers = new ArrayList<>();
    private final List<Ride> rideHistory = new ArrayList<>();
    private int rideCounter = 1;

    public void addDriver(Driver driver) { // Create
        drivers.add(driver);
    }

    public List<Ride> getRideHistory() { // Read
        return new ArrayList<>(rideHistory);
    }

    public Ride bookRide(User user, double distanceKm, FareCalculator fareCalculator)
            throws NoDriverAvailableException { // Create
        Driver assigned = assignAvailableDriver(); // may throw

        String rideId = "R" + rideCounter++;
        Ride ride = new Ride(rideId, user, distanceKm);
        ride.assignDriver(assigned);
        ride.setFare(fareCalculator.calculateFare(distanceKm));

        rideHistory.add(ride);
        return ride;
    }

    public void completeRide(String rideId) { // Update
        Ride ride = findRideById(rideId);
        if (ride == null) return;

        if (ride.getStatus() == RideStatus.BOOKED) {
            ride.complete();
            if (ride.getDriver() != null) ride.getDriver().freeDriver();
        }
    }

    public void cancelRide(String rideId) { 
        Ride ride = findRideById(rideId);
        if (ride == null) return;

        if (ride.getStatus() == RideStatus.BOOKED) {
            ride.cancel();
            if (ride.getDriver() != null) ride.getDriver().freeDriver();
        }
    }

    private Driver assignAvailableDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.bookDriver();
                return d;
            }
        }
        throw new NoDriverAvailableException("No driver available right now.");
    }

    private Ride findRideById(String rideId) {
        for (Ride r : rideHistory) {
            if (r.getRideId().equals(rideId)) return r;
        }
        return null;
    }
}


public class CabBooking {
    public static void main(String[] args) {
        // Setup (changed values)
        User u1 = new User("Neha", "U509");
        User u2 = new User("Arjun", "U777");

        Driver d1 = new Driver("Karan", "D901");
        Driver d2 = new Driver("Meera", "D902");
        Driver d3 = new Driver("Irfan", "D903");

        RideService service = new RideService();
        service.addDriver(d1);
        service.addDriver(d2);
        service.addDriver(d3);

        // Changed fare rules
        FareCalculator normal = new NormalFareCalculator(40, 15);      // base 40, perKm 15
        FareCalculator peak = new PeakFareCalculator(normal, 1.75);    // 1.75x

        try {
            // 1) Normal ride by Neha
            Ride r1 = service.bookRide(u1, 6.5, normal);
            System.out.println("Booked " + r1.getRideId() + " | User: " + r1.getUser().getUserName()
                    + " | Driver: " + r1.getDriver().getDriverName()
                    + " | Fare: " + r1.getFare());

            // 2) Peak ride by Arjun
            Ride r2 = service.bookRide(u2, 12, peak);
            System.out.println("Booked " + r2.getRideId() + " | User: " + r2.getUser().getUserName()
                    + " | Driver: " + r2.getDriver().getDriverName()
                    + " | Fare: " + r2.getFare());

            // 3) Another normal ride by Neha
            Ride r3 = service.bookRide(u1, 3, normal);
            System.out.println("Booked " + r3.getRideId() + " | User: " + r3.getUser().getUserName()
                    + " | Driver: " + r3.getDriver().getDriverName()
                    + " | Fare: " + r3.getFare());

            // 4) Now all 3 drivers are booked; this should trigger the exception (edge case test)
            Ride r4 = service.bookRide(u2, 4, normal);
            System.out.println("Booked " + r4.getRideId());

        } catch (NoDriverAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        // Update tests: complete one, cancel one (different from earlier demo)
        service.completeRide("R2"); // completes Arjun's ride, frees that driver
        service.cancelRide("R3");   // cancel Neha's ride, frees that driver

        // Try booking again after freeing drivers (should succeed now)
        try {
            Ride r5 = service.bookRide(u2, 9, peak);
            System.out.println("Booked " + r5.getRideId() + " | User: " + r5.getUser().getUserName()
                    + " | Driver: " + r5.getDriver().getDriverName()
                    + " | Fare: " + r5.getFare());
        } catch (NoDriverAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        // Print ride history
        System.out.println("\nRide history:");
        for (Ride r : service.getRideHistory()) {
            String driverName = (r.getDriver() == null) ? "NA" : r.getDriver().getDriverName();
            System.out.println(r.getRideId() + " | " + r.getUser().getUserName()
                    + " | Driver: " + driverName
                    + " | " + r.getStatus()
                    + " | Fare: " + r.getFare());
        }
    }
}