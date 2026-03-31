import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        // 1. Demonstration of Addition and Subtraction (Must be same size)
        System.out.println("=== DEMO 1: Addition & Subtraction (3x3 Matrices) ===");
        int[][] matrixA = createRandomMatrix(3, 3);
        int[][] matrixB = createRandomMatrix(3, 3);

        printMatrix(matrixA, "Matrix A");
        printMatrix(matrixB, "Matrix B");

        int[][] sumMatrix = addMatrices(matrixA, matrixB);
        printMatrix(sumMatrix, "Result: A + B");

        int[][] diffMatrix = subtractMatrices(matrixA, matrixB);
        printMatrix(diffMatrix, "Result: A - B");

        // 2. Demonstration of Multiplication (Rectangular)
        // Based on the image logic: A (2x3) * B (3x2)
        System.out.println("\n=== DEMO 2: Multiplication (Rectangular) ===");
        int[][] matrixC = createRandomMatrix(2, 3); // 2 Rows, 3 Cols
        int[][] matrixD = createRandomMatrix(3, 2); // 3 Rows, 2 Cols

        printMatrix(matrixC, "Matrix C (2x3)");
        printMatrix(matrixD, "Matrix D (3x2)");

        // C x D should result in a 2x2 matrix
        int[][] productCD = multiplyMatrices(matrixC, matrixD);
        printMatrix(productCD, "Result: C * D (should be 2x2)");
        
        // D x C should result in a 3x3 matrix
        int[][] productDC = multiplyMatrices(matrixD, matrixC);
        printMatrix(productDC, "Result: D * C (should be 3x3)");
    }

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Generates a random number between 1 and 10
                matrix[i][j] = rand.nextInt(10) + 1; 
            }
        }
        return matrix;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix, String label) {
        System.out.println("\n--- " + label + " ---");
        if (matrix == null) {
            System.out.println("Empty Matrix or Invalid Operation");
            return;
        }

        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int elem : row) {
                // Formats the number to be aligned (width of 4)
                System.out.printf("%4d", elem); 
            }
            System.out.println(" ]");
        }
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (rowsA != rowsB || colsA != colsB) {
            System.out.println("Error: Matrix addition requires same dimensions.");
            return null;
        }

        int[][] result = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (rowsA != rowsB || colsA != colsB) {
            System.out.println("Error: Matrix subtraction requires same dimensions.");
            return null;
        }

        int[][] result = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        // Valid multiplication check: Cols of A must equal Rows of B
        if (colsA != rowsB) {
            System.out.printf("Error: Cannot multiply %dx%d by %dx%d.%n", rowsA, colsA, rowsB, colsB);
            return null;
        }

        // Resulting matrix dimension is rowsA x colsB
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}