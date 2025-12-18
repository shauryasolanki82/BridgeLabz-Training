public class UniversityFee {
    public static void main(String[] args) {
        int Fee = 125000; 
        int discountPercentage = 10; 
        double discountAmount = (Fee * discountPercentage) / 100.0;
        System.out.println("The Discount Amount is INR " + discountAmount +" and final discounted fee is INR " + (Fee - discountAmount));
    }
}
