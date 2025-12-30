 import java.util.Scanner;
 class Employee{
    String name;
    int id;
    int salary;
    public Employee(String name, int id, int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
        public void display(){
        System.out.println("Name of Employee: "+name);
        System.out.println("ID of Employee: "+id);
        System.out.println("Salary of Employee is: "+salary);
    }
}
public class DisplayEmployeeDetails {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
          System.out.println("Enter Employee Name");
        String name = sc.nextLine();
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();
        System.out.println("Enter the salary of the employee");
        int salary = sc.nextInt();
        Employee employee = new Employee(name, id, salary);
        employee.display();
        sc.close();
    }
}
