package functional_interface.payment_gateway_integration;

public class Main {

	public static void main(String[] args) {
		PaymentProcessor paytm=new PayTm();
		PaymentProcessor gpay=new GPay();
		
		paytm.processPayment(1000);
		paytm.refund(1000);
		
		gpay.processPayment(1000);
		gpay.refund(1000);
	}

}
