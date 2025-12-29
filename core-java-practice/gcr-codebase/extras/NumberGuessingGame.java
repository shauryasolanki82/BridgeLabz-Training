import java.util.Scanner;
public class NumberGuessingGame {
  // Function to generate a random guess within range
  public static int generateGuess(int low, int high) {
    return low + (int)(Math.random() * (high - low + 1));
  }
  // Function to get user feedback
  public static String getFeedback(Scanner sc) {
    System.out.print("Is the guess high, low, or correct? ");
    return sc.next().toLowerCase();
  }
  // Main game logic
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int low = 1;
    int high = 100;
    boolean guessedCorrectly = false;
    System.out.println("Think of a number between 1 and 100.");
    System.out.println("I will try to guess it!");
    System.out.println("Press any key to proceed");
    String s = sc.next();
    while (!guessedCorrectly) {
      int guess = generateGuess(low, high);
      System.out.println("My guess is: " + guess);
      String feedback = getFeedback(sc);
      if (feedback.equals("low")) {
          low = guess + 1;
      } else if (feedback.equals("high")) {
          high = guess - 1;
      } else if (feedback.equals("correct")) {
          System.out.println("Guessed your number correctly ");
          guessedCorrectly = true;
      } else {
          System.out.println("Invalid input. Please enter high, low, or correct.");
      }
    }
    sc.close();
  }
}
