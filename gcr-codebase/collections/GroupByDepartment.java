package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
public class GroupByDepartment {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for (Employee emp : employees) {
            departmentMap
                    .computeIfAbsent(emp.department, k -> new ArrayList<>())
                    .add(emp);
        }
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {

            System.out.print(entry.getKey() + ": ");

            for (Employee e : entry.getValue()) {
                System.out.print(e.name + " ");
            }
            System.out.println();
        }
    }
}
