package csvDataHandling;

import java.io.FileWriter;

public class CSVWriteOperation {
	public static void main(String[] args) {
		
	 try (FileWriter writer = new FileWriter("Employee.csv")) {

         // header
         writer.append("ID,Name,Department,Salary\n");

         writer.append("1,Amit,IT,60000\n");
         writer.append("2,Neha,HR,55000\n");
         writer.append("3,Rahul,Finance,65000\n");
         writer.append("4,Pooja,Marketing,50000\n");
         writer.append("5,Karan,IT,70000\n");

         System.out.println("✅ CSV File Created!");

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
