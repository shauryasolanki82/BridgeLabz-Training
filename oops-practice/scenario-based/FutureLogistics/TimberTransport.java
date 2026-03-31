

public class TimberTransport extends  GoodsTransport{
    float timberLength;
    float timberRadius;
    String timberType;
    float timberPrice;
    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }
    @Override
    public String vehicleSelection(){
        double area = 3.147 * timberRadius * timberLength; 
        if(area < 250){
            return "Truck";
        }
        else if(area >= 250 && area <= 400){
            return "Lorry";
        }
        return "MonsterTruck";
    }
    @Override
    public float calculateTotalCharge(){
        double volume = 3.147 * timberRadius * timberRadius * timberLength;
        double rate = timberType.equalsIgnoreCase("Premium") ? 0.25 : 0.15;

        double price = volume * timberPrice * rate;
        double tax = price * 0.3;

        double vehiclePrice = vehicleSelection().equalsIgnoreCase("Truck") ? 1000 :
                              vehicleSelection().equalsIgnoreCase("Lorry") ? 1700 : 3000;

        double discount = 0;
        if (transportRating == 5) discount = price * 0.20;
        else if (transportRating >= 3) discount = price * 0.10;

        return (float) ((price + tax + vehiclePrice) - discount);
    }

}
