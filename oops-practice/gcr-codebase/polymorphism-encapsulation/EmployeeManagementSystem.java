import java.util.*;

interface Department {
	void assignDepartment(String deptName);
	String getDepartmentDetails();
}

abstract class Employee {

	private final int empId;
	private String name;
	private double baseSalary;

	Employee(int empId, String name, double baseSalary) {
		this.empId = empId;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	abstract double calculateSalary();

	public void displayDetails() {
		System.out.println("Employee Details");
		System.out.println("ID: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Base Salary: $" + baseSalary);
	}

	public int getEmpId() {
		return this.empId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBaseSalary() {
		return this.baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
}

class FullTimeEmployee extends Employee implements Department {

	private String departmentName;
	private double bonus;

	FullTimeEmployee(int empId, String name, double baseSalary, double bonus) {
		super(empId, name, baseSalary);
		this.bonus = bonus;
		this.departmentName = "Not Assigned";
	}

	@Override
	double calculateSalary() {
		// Full time gets Base + Bonus
		return getBaseSalary() + bonus;
	}

	@Override
	public void assignDepartment(String deptName) {
		this.departmentName = deptName;
	}

	@Override
	public String getDepartmentDetails() {
		return this.departmentName;
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Type: Full Time");
		System.out.println("Department: " + getDepartmentDetails());
		System.out.println("Total Monthly Earnings: $" + calculateSalary());
	}
}

class PartTimeEmployee extends Employee implements Department {

	private String departmentName;
	private int hoursWorked;
	private double hourlyRate;

	PartTimeEmployee(int empId, String name, int hoursWorked, double hourlyRate) {
		super(empId, name, 0);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
		this.departmentName = "Not Assigned";
	}

	@Override
	double calculateSalary() {
		return hoursWorked * hourlyRate;
	}

	@Override
	public void assignDepartment(String deptName) {
		this.departmentName = deptName;
	}

	@Override
	public String getDepartmentDetails() {
		return this.departmentName;
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Type: Part Time");
		System.out.println("Department: " + getDepartmentDetails());
		System.out.println("Total Earnings (" + hoursWorked + "hrs): $" + calculateSalary());
	}
}

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		FullTimeEmployee ft1 = new FullTimeEmployee(101, "Alice Johnson", 5000, 500);
		ft1.assignDepartment("IT Development");
		PartTimeEmployee pt1 = new PartTimeEmployee(102, "Bob Smith", 40, 25);
		pt1.assignDepartment("Customer Support");
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(ft1);
		employeeList.add(pt1);
		for (Employee emp : employeeList) {
			emp.displayDetails();
			System.out.println();
		}
	}
}