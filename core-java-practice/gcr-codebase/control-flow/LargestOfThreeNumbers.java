import java.util.Scanner;

public class LargestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();

        if (firstNumber >= secondNumber && firstNumber >= thirdNumber) {
            System.out.println("is the First number largest : true");
        }else if(secondNumber >= firstNumber && secondNumber >= thirdNumber){
            System.out.println("is the Second number largest : true");
        }else{
            System.out.println("is the Third number largest : true");
        }
        scanner.close();
    }
}
