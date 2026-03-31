package searching;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

    public static void main(String[] args) {
        String fileName = "example";
        String targetWord = "Java";
        int count = countWordInFile(fileName, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }

    public static int countWordInFile(String fileName, String targetWord) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}
