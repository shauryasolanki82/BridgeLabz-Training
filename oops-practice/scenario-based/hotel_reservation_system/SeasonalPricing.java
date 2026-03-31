package scenario_based.hotel_reservation_system;

public class SeasonalPricing implements PricingStrategy {
    @Override
    public double calculateBill(double basePrice, int nights) {
        return (basePrice * nights) * 1.20;
    }
}
