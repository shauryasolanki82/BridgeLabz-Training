import java.util.Scanner;
public class ReverseTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while (number != 0) {
            if (index >= maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index++] = number % 10;
            number /= 10;
        }
        int[] reversedDigits = new int[index];
        for (int i = 0; i < index; i++) {
            reversedDigits[i] = digits[index - i - 1];
        }
        System.out.print("Reversed array: ");
        for (int i = 0; i < index; i++) {
            System.out.print(reversedDigits[i] + " ");
        }
        scanner.close();
    }
}