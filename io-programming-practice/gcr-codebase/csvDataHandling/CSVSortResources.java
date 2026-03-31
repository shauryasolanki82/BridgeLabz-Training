package csvDataHandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Employee {

    String id;
    String name;
    String dept;
    double salary;

    Employee(String id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class CSVSortResources {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        try (
                BufferedReader bf = new BufferedReader(
                        new InputStreamReader(
                                CSVSortResources.class
                                        .getResourceAsStream("/csvDataHandling/Employee.csv")
                        )
                )
        ) {

            String line;
            bf.readLine(); // skip header

            while ((line = bf.readLine()) != null) {

                String[] l = line.split(",");

                employees.add(
                        new Employee(
                                l[0],
                                l[1],
                                l[2],
                                Double.parseDouble(l[3])
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ⭐ SORT DESCENDING
        employees.sort((e1, e2) ->
                Double.compare(e2.salary, e1.salary));

        // ⭐ PRINT
        for (Employee e : employees) {
            System.out.println(
                    e.id + " " +
                    e.name + " " +
                    e.dept + " " +
                    e.salary
            );
        }
    }
}
