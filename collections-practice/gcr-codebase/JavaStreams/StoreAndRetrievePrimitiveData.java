package JavaStreams;
import java.io.*;
public class StoreAndRetrievePrimitiveData {

	public static void main(String[] args) {
        try {
            DataOutputStream dos =new DataOutputStream(new FileOutputStream("student.dat"));
            dos.writeInt(101);
            dos.writeUTF("Dheeraj");
            dos.writeDouble(8.75);
            System.out.println("Student data written successfully");
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataInputStream dis =new DataInputStream(new FileInputStream("student.dat"));
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("\nRetrieved Student Details:");
            System.out.println("Roll No: " + roll);
            System.out.println("Name   : " + name);
            System.out.println("GPA    : " + gpa);
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
