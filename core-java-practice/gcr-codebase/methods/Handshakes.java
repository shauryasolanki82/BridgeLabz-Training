
import java.util.Scanner;

public class Handshakes {
	public static void studentHandshakes(int students) {
		int possibleHandshakes = (students*(students-1))/2;
        System.out.println("Possible Handshkes by the "+students+" students are "+possibleHandshakes);
	}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int students = input.nextInt();
        studentHandshakes(students);
        input.close();
    }
}
