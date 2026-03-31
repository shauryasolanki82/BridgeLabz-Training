import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Movies> movie = new ArrayList<>();
        
        movie.add(new Movies("kgf",4,2021));
        movie.add(new Movies("kgf2",5,2022));
        movie.add(new Movies("kgf3",2,2023));
        movie.add(new Movies("kgf4",3,2024));
        movie.add(new Movies("kgf5",5,2025));
        movie.add(new Movies("kgf6",4,2026));

        List<Movies> list = movie.stream().sorted(Comparator.comparing(Movies::getRating).reversed()).limit(5).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
