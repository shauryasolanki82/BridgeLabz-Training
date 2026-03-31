package searching;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChallengeString {

    private static final String FILE_NAME = "large_test_file.txt";
    private static final int CONCAT_ITERATIONS = 1_000_000;
    public static void main(String[] args) {
        System.out.println("Generating test file");
        generateTestFile(FILE_NAME, 500_000);
        System.out.println("Test file generated.\n");
        compareStringBuilders();
        compareFileReaders();
    }
    
    // --- PART 1: StringBuilder vs StringBuffer ---
    private static void compareStringBuilders() {
        String text = "test";
        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < CONCAT_ITERATIONS; i++) {
            sbBuffer.append(text);
        }
        long timeBuffer = (System.nanoTime() - startBuffer) / 1_000_000;
        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < CONCAT_ITERATIONS; i++) {
            sbBuilder.append(text);
        }
        long timeBuilder = (System.nanoTime() - startBuilder) / 1_000_000;
        System.out.println("StringBuffer Time: " + timeBuffer + " ms");
        System.out.println("StringBuilder Time: " + timeBuilder + " ms");
        if(timeBuilder < timeBuffer) {
            System.out.println(" Winner: StringBuilder (Not synchronized = Faster)");
        }
    }

    // --- PART 2: FileReader vs InputStreamReader ---
    private static void compareFileReaders() {
        long startFile = System.nanoTime();
        int countFile = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                countFile += line.split("\\s+").length;
            }
        } catch (IOException e) { e.printStackTrace(); }
        long timeFile = (System.nanoTime() - startFile) / 1_000_000;
        long startStream = System.nanoTime();
        int countStream = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                countStream += line.split("\\s+").length;
            }
        } catch (IOException e) { e.printStackTrace(); }
        long timeStream = (System.nanoTime() - startStream) / 1_000_000;
        System.out.println("FileReader Time:       " + timeFile + " ms (Words: " + countFile + ")");
        System.out.println("InputStreamReader Time: " + timeStream + " ms (Words: " + countStream + ")");
        System.out.println(">> Conclusion: Performance is usually similar if both are Buffered.");
        System.out.println("   InputStreamReader is preferred when you need specific charset encoding (UTF-8).");
    }

    private static void generateTestFile(String name, int lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            for (int i = 0; i < lines; i++) {
                bw.write("Java IO is fun and powerful ");
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
