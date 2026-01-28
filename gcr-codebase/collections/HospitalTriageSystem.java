package collections;

import java.util.PriorityQueue;
class Patient {
    String name;
    int severity;
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(
                (p1, p2) -> p2.severity - p1.severity
        );
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));
        System.out.print("Treatment Order: ");
        while (!queue.isEmpty()) {
            Patient p = queue.remove();
            System.out.print(p.name + " ");
        }
    }
}
