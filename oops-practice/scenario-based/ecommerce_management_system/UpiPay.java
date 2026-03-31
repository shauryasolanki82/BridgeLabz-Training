package scenario_based.ecommerce_management_system;

public class UpiPay implements Payment {
	
	private String upiId;
	
	UpiPay(String upiId){
		this.upiId = upiId;
	}
	
	public void pay(double amount) throws PaymentFailedException{
		if(!upiId.contains("@")) {
			throw new PaymentFailedException("Invalid UPI Id.");
		}
		System.out.println("Payment Successful");
	}
}
