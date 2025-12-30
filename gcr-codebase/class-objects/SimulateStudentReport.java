import java.util.Scanner;
class Student{
    String name;
    int rollNumber;
    int[] marks;
    public Student(String name, int rollNumber, int[] marks){
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    public void calculateGrade(){
        System.out.println("Student Name: "+name);
        System.out.println("Student RollNumber: "+rollNumber);
        int sum=0;
        for(int i=0;i<marks.length;i++){
            sum+=marks[i];
            System.out.println("Mark"+(i+1)+": "+marks[i]);
        }
        int avg = sum/marks.length;
        if(avg>90){
            System.out.println("Grade A");
        }
        else if(avg>80){
            System.out.println("Grade B");
        }
        else if(avg>70){
            System.out.println("Grade C");
        }
        else{
            System.out.println("Grade D");
        }
    }
}
public class SimulateStudentReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Student: ");
        String name = sc.next();
        System.out.println("Enter RollNumber: ");
        int rollNumber = sc.nextInt();
        System.out.println("Enter no of subjects:");
        int n = sc.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter marks of student: ");
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
        }
        Student student = new Student(name, rollNumber, marks);
        student.calculateGrade();
        sc.close();
    }
}
