import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGeneratorForFreelancers {

    // Represents one invoice task (service + amount)
    static class Task {
        final String name;
        final int amount;

        Task(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    static List<Task> parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Input is empty. Example: Logo Design - 3000 INR");
        }

        // Split tasks by comma, trimming spaces around commas
        String[] parts = input.trim().split("\\s*,\\s*");

        List<Task> tasks = new ArrayList<>();

        for (String part : parts) {
            if (part.isEmpty()) continue;

            // Must contain '-' between name and amount
            if (!part.contains("-")) {
                throw new InvalidInvoiceFormatException("Missing '-' in: " + part);
            }

            // Split only into 2 pieces: left = name, right = amount+currency
            String[] nameAndAmount = part.split("\\s*-\\s*", 2);
            if (nameAndAmount.length < 2) {
                throw new InvalidInvoiceFormatException("Invalid task format: " + part);
            }

            String name = nameAndAmount[0].trim();
            String rightSide = nameAndAmount[1].trim();  // ex: "3000 INR"

            if (name.isEmpty()) {
                throw new InvalidInvoiceFormatException("Task name missing in: " + part);
            }

            // Extract the first token as the amount
            String[] tokens = rightSide.split("\\s+");
            if (tokens.length == 0) {
                throw new InvalidInvoiceFormatException("Amount missing in: " + part);
            }

            int amount;
            try {
                amount = Integer.parseInt(tokens[0]);
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException("Amount is not a valid number in: " + part);
            }

            if (amount <= 0) {
                throw new InvalidInvoiceFormatException("Amount must be > 0 in: " + part);
            }

            tasks.add(new Task(name, amount));
        }

        if (tasks.isEmpty()) {
            throw new InvalidInvoiceFormatException("No valid tasks found.");
        }

        return tasks;
    }

    static int getTotalAmount(List<Task> tasks) {
        int total = 0;
        for (Task t : tasks) total += t.amount;
        return total;
    }

    static void displayInvoice(List<Task> tasks) {
        System.out.println("----------------Invoice-------------------");
        System.out.printf("%-3s %-25s %10s%n", "#", "Service", "Amount(INR)");
        System.out.println("------------------------------------------");

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("%-3d %-25s %10d%n", (i + 1), t.name, t.amount);
        }

        System.out.println("------------------------------------------");
        System.out.println("Total Amount: " + getTotalAmount(tasks) + " INR");
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter invoice like: Logo Design - 3000 INR, Web Page - 4500 INR");
        System.out.print("Invoice: ");
        String invoice = sc.nextLine().trim();
        try {
            List<Task> tasks = parseInvoice(invoice);
            displayInvoice(tasks);
        } catch (InvalidInvoiceFormatException e) {
            System.out.println("InvalidInvoiceFormatException: " + e.getMessage());
        }
        sc.close();
    }
}