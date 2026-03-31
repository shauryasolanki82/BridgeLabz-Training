
import java.util.*;

interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {
    
    private String patientId;
    private String name;
    private int age;
    
    private List<String> medicalHistory; 

    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public abstract double calculateBill();
    
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age);
    }
    
    @Override
    public void addRecord(String diagnosis) {
        if (diagnosis != null && !diagnosis.isEmpty()) {
            medicalHistory.add(diagnosis);
        }
    }
    @Override
    public void viewRecords() {
        if (medicalHistory.isEmpty()) {
            System.out.println("   No medical records found.");
        } else {
            System.out.println("   Medical History (Confidential):");
            for (String record : medicalHistory) {
                System.out.println("    - " + record);
            }
        }
    }
    public String getName() { 
    	return name;
    }
}

class InPatient extends Patient {
    
    private double dailyRoomCharge;
    private int daysAdmitted;

    InPatient(String patientId, String name, int age, double dailyRoomCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRoomCharge = dailyRoomCharge;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        double admissionFee = 500.00;
        return (dailyRoomCharge * daysAdmitted) + admissionFee;
    }
    
    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Type: In-Patient (Admitted for " + daysAdmitted + " days)");
    }
}

class OutPatient extends Patient {
    
    private double consultationFee;

    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    
    public double calculateBill() {
        double serviceCharge = 50.00;
        return consultationFee + serviceCharge;
    }
    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Type: Out-Patient (Consultation Only)");
    }
}

public class HospitalPatientManagementSystem {

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();
        InPatient p1 = new InPatient("P-101", "Sarah Connor", 35, 200.00, 5);
        p1.addRecord("Severe Pneumonia");
        p1.addRecord("Antibiotics Administered");
        OutPatient p2 = new OutPatient("P-102", "John Wick", 40, 150.00);
        p2.addRecord("Minor Hand Injury");
        p2.addRecord("Stitches Applied");
        patientList.add(p1);
        patientList.add(p2);
        System.out.println("HOSPITAL BILLING SYSTEM");
        for (Patient p : patientList) {
            p.getPatientDetails();
            p.viewRecords();
            double bill = p.calculateBill();
            System.out.println("Total Bill Amount: $" + String.format("%.2f", bill));
        }
    }
}
