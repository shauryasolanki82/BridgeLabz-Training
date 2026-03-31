package searching;
import java.io.*;

public class ConsoleToFile {

    public static void main(String[] args) {
        String outputFileName = "example";
        System.out.println("Type text to write to the file. Type 'exit' to finish.");
        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader consoleReader = new BufferedReader(isr);
            FileWriter fw = new FileWriter(outputFileName);
            BufferedWriter fileWriter = new BufferedWriter(fw)
        ) {
            String userInput;
            while (true) {
                System.out.print("> ");
                userInput = consoleReader.readLine();
                if (userInput == null || "exit".equalsIgnoreCase(userInput.trim())) {
                    System.out.println("Exiting and saving to " + outputFileName + "...");
                    break;
                }
                fileWriter.write(userInput);
                fileWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}