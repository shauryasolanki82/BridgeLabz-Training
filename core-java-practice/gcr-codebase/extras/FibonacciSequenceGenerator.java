import java.util.Scanner;
public class FibonacciSequenceGenerator {
  public static void Fibonacci(int n){
    int a =0,b=1;
    for(int i=1;i<=n;i++){
      System.out.print(a+" ");
      int temp = a+b;
      a=b;
      b=temp;
      
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Fibonacci(n);

  }
}
