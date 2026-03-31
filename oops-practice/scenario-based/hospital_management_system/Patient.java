package scenario_based.hospital_management_system;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<String> medicalHistory;

    public Patient(int id, String name, int age) {
        super(id, name, age);
        this.medicalHistory = new ArrayList<>();
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }
}
