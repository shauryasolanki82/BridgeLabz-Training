import java.util.Scanner;

public class WordLength2DArray {

    // Method to find length of a string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // End of string
        }
        return count;
    }

    // Method to split text into words without using split()
    public static String[] splitWords(String text) {
        int length = findLength(text);

        // Count number of words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndex = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }

        // Extract words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndex.length; i++) {
            words[i] = text.substring(start, spaceIndex[i]);
            start = spaceIndex[i] + 1;
        }
        words[wordCount - 1] = text.substring(start);

        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] wordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        // Split words
        String[] words = splitWords(input);

        // Create 2D array
        String[][] wordLen = wordLengthArray(words);

        // Display result
        System.out.println("\nWord\tLength");
        System.out.println("--------------");
        for (int i = 0; i < wordLen.length; i++) {
            int length = Integer.parseInt(wordLen[i][1]);
            System.out.println(wordLen[i][0] + "\t" + length);
        }

        sc.close();
    }
}