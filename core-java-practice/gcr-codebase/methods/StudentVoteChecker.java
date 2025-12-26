package methods;
import java.util.Scanner;

public class StudentVoteChecker{
	public static boolean canStudentVote(int age) {
		if(age < 0) {
			return false;
		}
		if(age >= 18) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] students = new int[10];
		for(int i=0; i<10; i++) {
			System.out.print("Enter Student "+ (i+1) + " age: ");
			students[i] = input.nextInt();
		}
		System.out.println();
		int j = 1;
		for(int i:students) {
			if(canStudentVote(i)) {
				System.out.println("Student "+ j++ +" can Vote");
			}else {
				System.out.println("Student "+ j++ +" cannot Vote");
			}
		}
		input.close();
	}
}