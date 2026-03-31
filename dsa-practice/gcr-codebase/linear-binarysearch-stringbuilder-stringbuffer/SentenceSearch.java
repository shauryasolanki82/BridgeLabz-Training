package searching;

public class SentenceSearch {

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox",
            "Jumps over the lazy dog",
            "Java is an object-oriented language",
            "Coding is fun"
        };
        String targetWord = "Java";
        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Target Word: " + targetWord);
        System.out.println("Result: " + result);
    }

    public static String findSentenceWithWord(String[] sentences, String word) {
        if (sentences == null || word == null) {
            return "Not Found";
        }
        for (String currentSentence : sentences) {
            if (currentSentence.contains(word)) {
                return currentSentence;
            }
        }
        return "Not Found";
    }
}
