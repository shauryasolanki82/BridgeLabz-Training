package scenario_based.hotel_reservation_system;

public class Guest {
    private String name;
    private String idProof;

    public Guest(String name, String idProof) {
        this.name = name;
        this.idProof = idProof;
    }

    public String getName() { return name; }
}
