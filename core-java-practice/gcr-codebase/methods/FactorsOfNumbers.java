
import java.util.*;

public class FactorsOfNumbers {

    public static int[] factors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }
    
    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > max) {
                max = factors[i];
            }
        }
        return max;
    }
    
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }
    
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
    
    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1.0;
        for (int factor : factors) {
            double cube = Math.pow(factor, 3);
            product *= cube;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = input.nextInt();
        int[] factors = factors(number);
        System.out.println("Factors: " + Arrays.toString(factors));
        int greatest = greatestFactor(factors);
        System.out.println("Greatest Factor: " + greatest);
        int sum = sumOfFactors(factors);
        System.out.println("Sum of Factors: " + sum);
        long product = productOfFactors(factors);
        System.out.println("Product of Factors: " + product);
        double cubeProduct = productOfCubeOfFactors(factors);
        System.out.printf("Product of Cubes: %.0f%n", cubeProduct);
        input.close();
    }
}