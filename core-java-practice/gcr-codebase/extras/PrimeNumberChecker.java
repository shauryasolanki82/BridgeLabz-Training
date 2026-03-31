import java.util.Scanner;
public class PrimeNumberChecker {
  //input
  public static int takeInput(String prompt){
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    sc.close();
    return sc.nextInt();
  }
  //check prime
  public static boolean isprime(int n){
    for(int i=2;i<=n/2;i++){
      if(n%i==0){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    int n = takeInput("Enter a number: ");
    System.out.println(isprime(n));
  }
}
