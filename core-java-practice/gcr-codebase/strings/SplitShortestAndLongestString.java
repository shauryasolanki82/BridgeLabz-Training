import java.util.Scanner;
import java.util.ArrayList;

public class SplitShortestAndLongestString {

    // Method to split text into words using charAt()
    public static String[] splitWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        String word = "";

        for (int i = 0; i < text.toCharArray().length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word = word + ch;
            } else {
                if (!word.equals("")) {
                    words.add(word);
                    word = "";
                }
            }
        }

        // add last word
        if (!word.equals("")) {
            words.add(word);
        }

        return words.toArray(new String[0]);
    }

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            
            count++;
        }
        return count;
    }

    // Method to create 2D array of word and its length
    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    // Method to find shortest and longest word
    // returns indices of shortest and longest words
    public static int[] findShortestLongest(String[][] wordLen) {
        int minIndex = 0;
        int maxIndex = 0;

        int minLen = Integer.parseInt(wordLen[0][1]);
        int maxLen = Integer.parseInt(wordLen[0][1]);

        for (int i = 1; i < wordLen.length; i++) {
            int currentLen = Integer.parseInt(wordLen[i][1]);

            if (currentLen < minLen) {
                minLen = currentLen;
                minIndex = i;
            }

            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text:");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordLen = wordWithLength(words);
        int[] result = findShortestLongest(wordLen);

        System.out.println("Shortest Word: " + wordLen[result[0]][0]);
        System.out.println("Longest Word: " + wordLen[result[1]][0]);

        sc.close();
    }
}
