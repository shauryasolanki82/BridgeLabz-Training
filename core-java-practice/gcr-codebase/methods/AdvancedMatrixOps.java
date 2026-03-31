// import java.util.Scanner;

public class AdvancedMatrixOps {

    public static void main(String[] args) {
        // 1. TRANSPOSE DEMO
        System.out.println("=== 1. Transpose Operation ===");
        int[][] matrixA = createRandomMatrix(2, 3);
        displayMatrix(matrixA, "Original Matrix (2x3)");
        int[][] transposeA = transposeMatrix(matrixA);
        displayMatrix(transposeA, "Transposed Matrix (3x2)");

        // 2. DETERMINANT & INVERSE (2x2) DEMO
        System.out.println("\n=== 2. 2x2 Determinant & Inverse ===");
        int[][] matrix2x2 = createRandomMatrix(2, 2);
        displayMatrix(matrix2x2, "Random 2x2 Matrix");
        
        double det2 = getDeterminant2x2(matrix2x2);
        System.out.println("Determinant: " + det2);
        
        if (det2 != 0) {
            double[][] inv2 = getInverse2x2(matrix2x2);
            displayDoubleMatrix(inv2, "Inverse of 2x2 Matrix");
        } else {
            System.out.println("Inverse does not exist (Determinant is 0).");
        }

        // 3. DETERMINANT & INVERSE (3x3) DEMO
        System.out.println("\n=== 3. 3x3 Determinant & Inverse ===");
        int[][] matrix3x3 = createRandomMatrix(3, 3);
        displayMatrix(matrix3x3, "Random 3x3 Matrix");

        double det3 = getDeterminant3x3(matrix3x3);
        System.out.println("Determinant: " + det3);

        if (det3 != 0) {
            double[][] inv3 = getInverse3x3(matrix3x3);
            displayDoubleMatrix(inv3, "Inverse of 3x3 Matrix");
        } else {
            System.out.println("Inverse does not exist (Determinant is 0).");
        }
        

    }

    // --- HELPER METHODS ---

    // Method to create a random matrix (using your Math.random approach)
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10) + 1;
            }
        }
        return matrix;
    }

    // Method to find the transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows]; // Note: dims are swapped

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
    
    // Method to find the determinant of a 2x2 matrix
    // Formula: (a*d) - (b*c)
    public static double getDeterminant2x2(int[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // Method to find the determinant of a 3x3 matrix
    // Formula: a(ei − fh) − b(di − fg) + c(dh − eg)
    public static double getDeterminant3x3(int[][] m) {
        double x = (m[1][1] * m[2][2]) - (m[1][2] * m[2][1]);
        double y = (m[1][0] * m[2][2]) - (m[1][2] * m[2][0]);
        double z = (m[1][0] * m[2][1]) - (m[1][1] * m[2][0]);

        return (m[0][0] * x) - (m[0][1] * y) + (m[0][2] * z);
    }

    // Method to find the inverse of a 2x2 matrix
    // Formula: (1/det) * [d, -b; -c, a]
    public static double[][] getInverse2x2(int[][] m) {
        double det = getDeterminant2x2(m);
        double[][] inverse = new double[2][2];

        inverse[0][0] = m[1][1] / det;
        inverse[0][1] = -m[0][1] / det;
        inverse[1][0] = -m[1][0] / det;
        inverse[1][1] = m[0][0] / det;

        return inverse;
    }

    // Method to find the inverse of a 3x3 matrix
    // Method: 1/Determinant * Adjugate Matrix
    public static double[][] getInverse3x3(int[][] m) {
        double det = getDeterminant3x3(m);
        double[][] inverse = new double[3][3];

        // Calculating Cofactors
        // Row 0
        inverse[0][0] = ((m[1][1]*m[2][2]) - (m[1][2]*m[2][1])) / det;
        inverse[1][0] = -((m[1][0]*m[2][2]) - (m[1][2]*m[2][0])) / det; // Transposed position
        inverse[2][0] = ((m[1][0]*m[2][1]) - (m[1][1]*m[2][0])) / det; // Transposed position

        // Row 1
        inverse[0][1] = -((m[0][1]*m[2][2]) - (m[0][2]*m[2][1])) / det; // Transposed position
        inverse[1][1] = ((m[0][0]*m[2][2]) - (m[0][2]*m[2][0])) / det;
        inverse[2][1] = -((m[0][0]*m[2][1]) - (m[0][1]*m[2][0])) / det; // Transposed position

        // Row 2
        inverse[0][2] = ((m[0][1]*m[1][2]) - (m[0][2]*m[1][1])) / det; // Transposed position
        inverse[1][2] = -((m[0][0]*m[1][2]) - (m[0][2]*m[1][0])) / det; // Transposed position
        inverse[2][2] = ((m[0][0]*m[1][1]) - (m[0][1]*m[1][0])) / det;

        return inverse;
    }

    // Method to display an integer matrix
    public static void displayMatrix(int[][] matrix, String label) {
        System.out.println(label + ":");
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
    }

    // Method to display a double matrix (for inverses)
    public static void displayDoubleMatrix(double[][] matrix, String label) {
        System.out.println(label + ":");
        for (double[] row : matrix) {
            for (double elem : row) {
                // Formats to 2 decimal places
                System.out.printf("%8.2f", elem); 
            }
            System.out.println();
        }
    }
}
