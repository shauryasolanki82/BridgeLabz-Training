package scenario_based.hospital_management_system;

public class Main {
    public static void main(String[] args) {
        HospitalService hospital = new HospitalManagement();
        Doctor doc1 = new GeneralPhysician(101, "Anuj", 45);
        Doctor doc2 = new Specialist(102, "Bhupendra", 50, "Cardiologist");
        Doctor doc3 = new Specialist(103, "Dr. Amit", 55, "Neurologist");
        Patient p1 = new Patient(1, "Jay", 30);
        p1.addRecord("Allergy to Penicillin");
        try {
            hospital.bookAppointment(p1, doc1, "12-Oct-2023");
            hospital.bookAppointment(p1, doc2, "14-Oct-2023");
            System.out.println("Attempting to book Dr. Busy...");
            hospital.bookAppointment(p1, doc3, "15-Oct-2023");
        } catch (AppointmentNotAvailableException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        hospital.printAppointmentDetails();
        System.out.println("Patient Medical History");
        System.out.println(p1.getName() + ": " + p1.getMedicalHistory());
    }
}
