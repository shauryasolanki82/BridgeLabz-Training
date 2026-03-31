import java.util.Scanner;
public class YoungestAmongThreeFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age for " + names[i] + ":");
            ages[i] = scanner.nextInt();
            System.out.println("Enter height for " + names[i] + ":");
            heights[i] = scanner.nextDouble();
        }
        int youngestIndex = 0;
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        System.out.println("Youngest friend is: " + names[youngestIndex]);
        System.out.println("Tallest friend is: " + names[tallestIndex]);
        scanner.close();
    }
}