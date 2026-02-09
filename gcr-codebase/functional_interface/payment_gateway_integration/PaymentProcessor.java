package functional_interface.payment_gateway_integration;

public interface PaymentProcessor {
	void processPayment(double amount);
	default void refund(double amount) {
		System.out.println("refund not supported");
	}
}
