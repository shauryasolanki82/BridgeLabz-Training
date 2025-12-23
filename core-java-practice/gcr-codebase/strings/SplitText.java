import java.util.Scanner;

public class SplitText {

    // Method to find length of string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // End of string reached
        }
        return count;
    }

    // Method to split text into words without using split()
    public static String[] customSplit(String text) {
        int length = findLength(text);

        // Step 1: Count number of words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        // Step 3: Extract words using indexes
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[wordCount - 1] = text.substring(start);

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        // Custom split
        String[] customWords = customSplit(input);

        // Built-in split
        String[] builtInWords = input.split(" ");

        // Display custom split result
        System.out.println("\nCustom Split Result:");
        for (String word : customWords) {
            System.out.println(word);
        }

        // Display built-in split result
        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        // Compare results
        boolean result = compareArrays(customWords, builtInWords);
        System.out.println("\nDo both methods produce the same result? " + result);

        sc.close();
    }
}
