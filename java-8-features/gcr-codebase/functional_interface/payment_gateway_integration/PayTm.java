package functional_interface.payment_gateway_integration;

public class PayTm implements PaymentProcessor {
	@Override
	public void processPayment(double amount) {
		System.out.println("Payment is processing via paytm for amount: "+amount);
	}
}
