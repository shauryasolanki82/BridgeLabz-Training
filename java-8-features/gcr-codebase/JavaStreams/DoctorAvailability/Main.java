import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Doctor> doctor = new ArrayList<>();

        doctor.add(new Doctor("doctor1", "neuro", false));
        doctor.add(new Doctor("doctor2", "cardio", true));
        doctor.add(new Doctor("doctor3", "neuro", false));
        doctor.add(new Doctor("doctor5", "cancer", false));
        doctor.add(new Doctor("doctor5", "radiologist", true));

        List<Doctor> list =  doctor.stream().filter(Doctor::getIsAvailable).sorted(Comparator.comparing(Doctor::getSpeciality)).collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
