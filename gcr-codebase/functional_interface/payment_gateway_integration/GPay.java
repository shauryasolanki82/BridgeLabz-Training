package functional_interface.payment_gateway_integration;

public class GPay implements PaymentProcessor {
	@Override
	public void processPayment(double amount) {
		System.out.println("Payment is processing via GPay for amount: "+amount);
	}
	
	@Override
	public void refund(double amount) {
		System.out.println("Refunding amount "+amount+" via GPay");
	}

}
