public class CalculateProfitAndLoss {
    public static void main(String[] args) {
        double costPrice = 129; 
        double sellingPrice = 191; 
            double profit = sellingPrice - costPrice;
            double profitPercentage = (double)((profit / costPrice) * 100);
            System.out.println("The Cost Price in INR "+ profit +" and Selling Price in INR "+ sellingPrice);
            System.out.println("The Profit is INR "+ profit + " and Profit Percentage is " + profitPercentage+ "%");
        
    }
}
