public class Claim{
    private int amount;
    private String claimType;

    public Claim(int amount, String claimType){
        this.amount = amount;
        this.claimType = claimType;
    }

    int getAmount(){
        return amount;
    }
    String getClaimType(){
        return claimType;
    }

    public String toString(){
        return claimType+" "+amount;
    } 
}