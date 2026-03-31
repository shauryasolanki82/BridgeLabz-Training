package scenario_based.hotel_reservation_system;

public interface PricingStrategy {
    double calculateBill(double basePrice, int nights);
}
