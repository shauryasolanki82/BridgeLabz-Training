import java.util.ArrayList;
import java.util.List;


public class Main{
    public static void main(String[] args){
        List<String> names = new ArrayList<>();

        names.add("Shaurya");
        names.add("rajat");
        names.add("Subhash");
        names.add("anuj");
        names.add("vikash");

        names.stream().map(String::toUpperCase).sorted().forEach(System.out::println);;

        
    }
}