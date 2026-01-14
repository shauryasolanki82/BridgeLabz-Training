import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();

        int start = 0;
        int end = 0;
        int currPetrol = 0;

        while (queue.size() < n) {

            // Add petrol from current pump
            currPetrol += pumps[end].petrol - pumps[end].distance;
            queue.add(end);

            // If petrol becomes negative, reset start
            while (currPetrol < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                currPetrol -= pumps[removed].petrol - pumps[removed].distance;
                start = removed + 1;
            }

            end = (end + 1) % n;

            if (end == start && currPetrol >= 0) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        int start = findStartingPoint(pumps);
        System.out.println("Starting Pump Index: " + start);
    }
}
