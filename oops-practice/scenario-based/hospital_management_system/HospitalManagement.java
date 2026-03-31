package scenario_based.hospital_management_system;
import java.util.*;

public class HospitalManagement implements HospitalService {
    private List<Appointment> appointments;

    public HospitalManagement() {
        this.appointments = new ArrayList<>();
    }

    @Override
    public void bookAppointment(Patient p, Doctor d, String date) throws AppointmentNotAvailableException {
        if (d.getName().contains("Busy")) {
            throw new AppointmentNotAvailableException("Dr. " + d.getName() + " is fully booked on " + date);
        }
        
        Appointment newAppt = new Appointment(p, d, date);
        appointments.add(newAppt);
        System.out.println("Success: Appointment booked for " + p.getName());
    }

    @Override
    public void printAppointmentDetails() {
        System.out.println("Current Appointments");
        for (Appointment appt : appointments) {
            System.out.println(appt);
        }
    }
}
