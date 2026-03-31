package employee_salary_categorization;

import java.util.*;
import java.util.stream.Collectors;

public class SalaryGrouping {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee("Rahul", "IT", 60000),new Employee("Amit", "IT", 80000),new Employee("Neha", "HR", 50000),new Employee("Pooja", "HR", 55000),
   new Employee("Karan", "Finance", 70000),new Employee("Riya", "Finance", 90000));

        Map<String, Double> avgSalaryByDept =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " : " + avgSalary));
    }
}

