import java.util.Scanner;
public class TemperatureConverter {
  // Fahrenheit to Celsius conversion
  public static double FtoC(double f){
     return (f - 32) * (5.0 / 9.0);
  }
  // Celsius to Fahrenheit conversion
  public static double CtoF(double c){
    return (c * (9.0 / 5.0)) + 32;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //input in fahrenhiet
    System.out.print("Enter temperature in Fahrenheit: ");
    double f = scanner.nextDouble();
    //output in celsius
    System.out.println("Fahrenheit to celcius: "+FtoC(f));
    //input in celsius
    System.out.print("Enter temperature in celsius: ");
    double c = scanner.nextDouble();
    //output in fahrenheit
    System.out.println("Celcius to Fahrenheit: "+CtoF(c));
    scanner.close();
  }
}
