package scenario_based.hotel_reservation_system;

public class RegularPricing implements PricingStrategy {
    @Override
    public double calculateBill(double basePrice, int nights) {
        return basePrice * nights;
    }
}
