package student_result_grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentGrouping {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(new Student("Rahul", "A"),new Student("Anita", "B"),new Student("Vikas", "A"),new Student("Neha", "C"),new Student("Rohit", "B"),new Student("Priya", "A"));

        Map<String, List<String>> groupedByGrade =
                students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));

        groupedByGrade.forEach((grade, names) -> {
            System.out.println("Grade " + grade + " : " + names);
        });
    }
}
