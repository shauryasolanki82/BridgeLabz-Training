package bridgelabz.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ObjectsToJson {

    static class Student {
        private String name;
        private int id;
        private String email;

        public Student(String name, int id, String email) {
            this.name = name;
            this.id = id;
            this.email = email;
        }

        public String getName() { return name; }
        public int getId() { return id; }
        public String getEmail() { return email; }
    }

    public static void main(String[] args) {
        try {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Alice", 101, "alice@example.com"));
            students.add(new Student("Bob", 102, "bob@example.com"));
            students.add(new Student("Charlie", 103, "charlie@example.com"));
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}