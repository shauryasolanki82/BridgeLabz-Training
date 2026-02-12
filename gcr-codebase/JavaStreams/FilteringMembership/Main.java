import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Gym> gym = new ArrayList<>();

        gym.add(new Gym("Vikash",25));
        gym.add(new Gym("Subhash",21));
        gym.add(new Gym("Rajat",35));
        gym.add(new Gym("Dheeraj",45));
        gym.add(new Gym("Nikhil",31));


        List<Gym> list = gym.stream().filter(e -> e.getNoOfDaysLeft()>30).collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
