import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<Claim> claim = new ArrayList<>();

        claim.add(new Claim(25000, "Accident"));
        claim.add(new Claim(50000, "health"));
        claim.add(new Claim(25000, "Accident"));
        claim.add(new Claim(50000, "health"));
        claim.add(new Claim(250000, "property"));

        Map<String, Double> map = claim.stream().collect(Collectors.groupingBy(Claim::getClaimType, Collectors.averagingDouble(Claim::getAmount)));

        map.forEach((type, avg) ->
        System.out.println(type+" "+avg));
    }
}
