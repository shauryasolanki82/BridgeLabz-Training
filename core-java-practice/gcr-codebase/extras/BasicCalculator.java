import java.util.Scanner;
public class BasicCalculator {
  public static double add(double a, double b){
    return a+b;
  }
  public static double subtract(double a, double b){
    return a-b;
  }
  public static double multiply(double a, double b){
    return a*b;
  }
  public static double divide(double a, double b){
    return a/b;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter first number: ");
    double n1 = sc.nextDouble();
    System.out.print("Enter second number: ");
    double n2 = sc.nextDouble();
    System.out.print("Enter operator: ");
    char operator = sc.next().charAt(0);
    switch(operator){
      case '+':
      System.out.println("addition: "+add(n1,n2));
      break;
      case '-':
      System.out.println("subtraction: "+subtract(n2, n2));
      break;
      case '*':
      System.out.println("multiplication: "+multiply(n1,n2));
      break;
      case '/':
      System.out.println("divide: "+divide(n1,n2));
      break;
      default:
      System.out.println("invalid operator!");
    }
    sc.close();
  }
}
