package JavaStreams;
import java.io.*;

class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	String department;
	double salary;
	public Employee(String id,String name,String department,double salary) {
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	public String toString() {
		return "Employee--> Id: "+id+", Name: "+name+", Department: "+department+", Salary: "+salary;
	}
}

public class SaveAndRetrieveAnObject {
	public static void main(String[] args) {
		Employee employee1 = new Employee("41204","Dheeraj kumar","xyzz",250000);
		Employee employee2 = new Employee("42655","Vikash","bn",250000);
		//Serialize
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EmployeeList.ser"));
			oos.writeObject(employee1);
			oos.writeObject(employee2);
			System.out.println("Serialized successfully");
			oos.close();
		}catch ( IOException e){
			System.out.println("Error occurred");
		}
		//Deserialize
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("EmployeeList.ser"));
			Employee e1 = (Employee) ois.readObject();
			Employee e2 = (Employee) ois.readObject();
			System.out.println("Deserielized object: ");
			System.out.println(e1);
			System.out.println(e2);
			ois.close();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			//System.out.println("error occured");
		}
		
	}
}
