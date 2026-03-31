public class Student {
	
	private static String universityName = "Global University";
	private static int totalStudents;
	private String name;
	private final int rollNumber;
	private char grade;
	
	Student(String name, int rollNumber, char grade){
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
		totalStudents++;
	}
	
	public void displayStudentDetails() {
		if(this instanceof Student) {
			System.out.println("University Name: "+universityName);
			System.out.println("Roll Number: "+rollNumber);
			System.out.println("Name: "+name);
			System.out.println("Grade: "+grade);
		}else {
			System.err.println("Student details not found");
		}
	}
	
	public void updateGrade(char newGrade) {
		if(this instanceof Student) {
			grade = newGrade;
			System.out.println("Grade updated to: "+grade);
		}else {
			System.err.println("Student details not found");
		}
	}
	
	public static void displayTotalStudents() {
		System.out.println("Total Students Enrolled: "+totalStudents);
	}

	public static void main(String[] args) {
		Student s1 = new Student("Hemashree", 101, 'A');
		Student s2 = new Student("Sharmila", 102, 'B');
		Student.displayTotalStudents();
		s1.displayStudentDetails();
		s2.displayStudentDetails(); 
		s2.updateGrade('A');
		s2.displayStudentDetails();

	}

}
