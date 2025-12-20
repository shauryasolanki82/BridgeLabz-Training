import java.util.Scanner;

public class SmallestBetweenThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();


        if (firstNumber <= secondNumber && firstNumber <= thirdNumber) {
            System.out.println("is the first number "+firstNumber+" the smallest among three numbers? : true");
        }else{
            System.out.println("is the first number "+firstNumber+" the smallest among three numbers? : false");
        }
        scanner.close();
    }
}
