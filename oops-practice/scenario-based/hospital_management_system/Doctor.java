package scenario_based.hospital_management_system;

public abstract class Doctor extends Person {
    protected String specialization;

    public Doctor(int id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }
    public abstract double calculateFee();
}

class GeneralPhysician extends Doctor {
    public GeneralPhysician(int id, String name, int age) {
        super(id, name, age, "General Medicine");
    }
    @Override
    public double calculateFee() {
        return 50.00;
    }
}

class Specialist extends Doctor {
    public Specialist(int id, String name, int age, String type) {
        super(id, name, age, type);
    }
    @Override
    public double calculateFee() {
        return 150.00;
    }
}
