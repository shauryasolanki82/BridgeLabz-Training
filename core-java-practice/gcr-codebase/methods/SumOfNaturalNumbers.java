import java.util.Scanner;
public class SumOfNaturalNumbers {
    public static int sumOfNumber(int n){
        int sum = n*(n-1)/2;
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumOfNumber(n));
        sc.close();
    }
}
