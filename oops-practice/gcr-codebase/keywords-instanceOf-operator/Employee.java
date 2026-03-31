public class Employee {
	
	private static String companyName = "Tech Solutions Inc.";
	private static int totalEmployees;
	private String name;
	private final int id;
	private String designation;
	
	Employee(String name, int id, String designation){
		this.name = name;
		this.id = id;
		this.designation = designation;
		totalEmployees++;
	}
	
	public void displayEmployeeDetails() {
		if(this instanceof Employee) {
			System.out.println("Company Name: "+companyName);
			System.out.println("Employee Id: "+id);
			System.out.println("Name: "+name);
			System.out.println("Designation: "+designation);
		}else {
			System.err.println("Employee details not found");
		}
	}
	
	public static void displayTotalEmployees() {
		System.out.println("Total Employees: "+totalEmployees);
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("Thamarai", 101, "Software Engineer");
		Employee emp2 = new Employee("Rohan", 102, "Project Manager");
		Employee.displayTotalEmployees();
		emp1.displayEmployeeDetails();
		emp2.displayEmployeeDetails();
	}

}
