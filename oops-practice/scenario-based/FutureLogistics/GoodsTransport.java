
public abstract class GoodsTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating){
        this.transportDate = transportDate;
        this.transportId = transportId;
        this.transportRating = transportRating;
    }
    public String getTransportId() {
        return transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }
    abstract public String vehicleSelection();
    abstract public float calculateTotalCharge();
}
