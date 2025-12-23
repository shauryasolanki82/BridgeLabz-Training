import java.util.Scanner;

public class FreqOfCharUsingNestedLoop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] frequencyResult = findFrequency(input);

        System.out.println("\nCharacter Frequency:");
        for (String s : frequencyResult) {
            System.out.println(s);
        }

        scanner.close();
    }

    // Method to find character frequency using nested loops
    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int length = chars.length;
        int[] freq = new int[length];

        // Initialize frequency array
        for (int i = 0; i < length; i++) {
            freq[i] = 1;
        }

        // Nested loop to calculate frequency
        for (int i = 0; i < length; i++) {

            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate
                }
            }
        }

        // Count valid characters
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // 1D String array for result
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " -> " + freq[i];
                index++;
            }
        }

        return result;
    }
}