import java.util.Scanner;
public class CopyTwoDArrayIntoOneDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] twoDArray = new int[rows][columns];
        System.out.println("Enter elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoDArray[i][j] = scanner.nextInt();
            }
        }
        int[] oneDArray = new int[rows * columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                oneDArray[index++] = twoDArray[i][j];
            }
        }
        System.out.println("1D Array elements:");
        for (int i = 0; i < index; i++) {
            System.out.print(oneDArray[i] + " ");
        }
        scanner.close();
    }
}