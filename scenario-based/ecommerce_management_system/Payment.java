package scenario_based.ecommerce_management_system;

public interface Payment {
	void pay(double amount) throws PaymentFailedException;
}
