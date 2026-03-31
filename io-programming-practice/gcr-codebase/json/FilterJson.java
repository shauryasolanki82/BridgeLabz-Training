package bridgelabz.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    public String name;
    public int age;
    public String city;
    
    public Person() {} 
}

public class FilterJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Person> people = mapper.readValue(
                new File("data1.json"), 
                new TypeReference<List<Person>>(){}
            );
            
            List<Person> result = people.stream()
                .filter(p -> p.age > 25)
                .collect(Collectors.toList());
            for (Person p : result) {
                System.out.println(p.name + " (" + p.age + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
