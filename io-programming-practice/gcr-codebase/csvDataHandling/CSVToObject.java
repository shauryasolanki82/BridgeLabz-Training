package csvDataHandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVToObject {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                CSVToObject.class
                                        .getResourceAsStream("/csvDataHandling/students.csv")
                        )
                )
        ) {

            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                );

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ⭐ Print objects
        students.forEach(System.out::println);
    }
}
