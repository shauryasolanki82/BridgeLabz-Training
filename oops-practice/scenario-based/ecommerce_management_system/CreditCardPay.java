package scenario_based.ecommerce_management_system;

public class CreditCardPay implements Payment {
	private String cardNumber;
	
	CreditCardPay(String cardNumber){
		this.cardNumber = cardNumber;
	}
	
	public void pay(double Amount) throws PaymentFailedException{
		if(cardNumber.length() < 16) {
			throw new PaymentFailedException("Invalid Credit Card details.");
		}
		System.out.println("Payment Successful");
	}
}
