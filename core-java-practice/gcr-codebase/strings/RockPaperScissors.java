import java.util.Scanner;

public class RockPaperScissors {

    // 0 = Rock, 1 = Paper, 2 = Scissors
    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int games = sc.nextInt();

        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("\nGame Results:");
        System.out.println("------------------------------------------------");
        System.out.println("Game\tUser Choice\tComputer Choice\tResult");
        System.out.println("------------------------------------------------");

        for (int i = 1; i <= games; i++) {
            int userChoice = getUserChoice(sc, i);
            int computerChoice = getComputerChoice();
            String result = findWinner(userChoice, computerChoice);

            // Update counters
            if (result.equals("User")) {
                userWins++;
            } else if (result.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }

            // Display each game result
            displayGameResult(i, userChoice, computerChoice, result);
        }

        // Build summary as String[][] and display
        String[][] summaryTable = buildSummaryTable(games, userWins, computerWins, draws);
        System.out.println();
        displaySummaryTable(summaryTable);

        sc.close();
    }

    // Method: Get computer choice using Math.random
    private static int getComputerChoice() {
        // Math.random() -> [0.0, 1.0)
        // * 3 -> [0.0, 3.0) -> cast to int -> 0, 1, 2
        return (int) (Math.random() * 3);
    }

    // Method: Get user choice for each game
    private static int getUserChoice(Scanner sc, int gameNumber) {
        while (true) {
            System.out.print("Game " + gameNumber +
                    " - Enter your choice (0: Rock, 1: Paper, 2: Scissors): ");
            int choice = sc.nextInt();
            if (choice >= 0 && choice <= 2) {
                return choice;
            }
            System.out.println("Invalid choice. Please enter 0, 1, or 2.");
        }
    }

    // Method: Find winner between user and computer
    // Returns: "User", "Computer", or "Draw"
    private static String findWinner(int userChoice, int compChoice) {
        if (userChoice == compChoice) {
            return "Draw";
        }

        // Rock beats Scissors, Paper beats Rock, Scissors beats Paper
        // (userChoice - compChoice + 3) % 3 == 1 => user wins
        int diff = (userChoice - compChoice + 3) % 3;
        if (diff == 1) {
            return "User";
        } else {
            return "Computer";
        }
    }

    // Method: Display single game result
    private static void displayGameResult(int gameNo, int userChoice, int compChoice, String result) {
        String resultText;
        if (result.equals("User")) {
            resultText = "User Wins";
        } else if (result.equals("Computer")) {
            resultText = "Computer Wins";
        } else {
            resultText = "Draw";
        }

        System.out.printf("%d\t%-11s\t%-15s\t%s%n",
                gameNo,
                CHOICES[userChoice],
                CHOICES[compChoice],
                resultText);
    }

    // Method: Create a String 2D array with totals, averages, and percentages
    private static String[][] buildSummaryTable(int totalGames, int userWins, int compWins, int draws) {
        double userWinPercent = totalGames > 0 ? (userWins * 100.0 / totalGames) : 0.0;
        double compWinPercent = totalGames > 0 ? (compWins * 100.0 / totalGames) : 0.0;
        double drawPercent = totalGames > 0 ? (draws * 100.0 / totalGames) : 0.0;

        // 4 rows: Header, User, Computer, Draw
        // 4 cols: Category, Wins, Average (wins/game), Percentage
        String[][] table = new String[4][4];

        table[0][0] = "Category";
        table[0][1] = "Wins";
        table[0][2] = "Avg Wins/Game";
        table[0][3] = "Win %";

        table[1][0] = "User";
        table[1][1] = String.valueOf(userWins);
        table[1][2] = String.format("%.2f", totalGames > 0 ? (userWins * 1.0 / totalGames) : 0.0);
        table[1][3] = String.format("%.2f%%", userWinPercent);

        table[2][0] = "Computer";
        table[2][1] = String.valueOf(compWins);
        table[2][2] = String.format("%.2f", totalGames > 0 ? (compWins * 1.0 / totalGames) : 0.0);
        table[2][3] = String.format("%.2f%%", compWinPercent);

        table[3][0] = "Draws";
        table[3][1] = String.valueOf(draws);
        table[3][2] = String.format("%.2f", totalGames > 0 ? (draws * 1.0 / totalGames) : 0.0);
        table[3][3] = String.format("%.2f%%", drawPercent);

        return table;
    }

    // Method: Display the summary 2D String array in table format
    private static void displaySummaryTable(String[][] table) {
        System.out.println("Overall Stats:");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-10s\t%-6s\t%-13s\t%-7s%n",
                    table[i][0],
                    table[i][1],
                    table[i][2],
                    table[i][3]);
        }
    }
}
//rockpapper