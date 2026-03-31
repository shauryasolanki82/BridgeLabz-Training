public class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    @Override
    public String vehicleSelection() {
        if (brickQuantity < 300)
            return "Truck";
        else if (brickQuantity <= 500)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float vehiclePrice = vehicleSelection().equalsIgnoreCase("Truck") ? 1000 :
                             vehicleSelection().equalsIgnoreCase("Lorry") ? 1700 : 3000;

        float discount = 0;
        if (transportRating == 5) discount = price * 0.20f;
        else if (transportRating >= 3) discount = price * 0.10f;

        return (price + tax + vehiclePrice) - discount;
    }
}
