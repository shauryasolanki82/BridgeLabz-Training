import java.util.Scanner;
public class MaximumNoOfHandshakeBwNStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Example number of students
        int maxHandshakes = (n * (n - 1)) / 2;
        System.out.println("Maximum number of handshakes between " + n + " students is: " + maxHandshakes);
        scanner.close();
    }
}
