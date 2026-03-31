import java.util.Scanner;
import java.util.regex.*;
public class ValidateLicensePlateNumber {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String regex = "[A-Z]{2}[0-9]{4}";
    Pattern pattern = Pattern.compile(regex);
    System.out.println("Enter license plate number");
    String s = sc.nextLine();
    Matcher matcher = pattern.matcher(s);
    if(matcher.find()){
        System.out.println("valid number plate");
    }
    else{
        System.out.println("invalid number plate");
        sc.close();
    }
    }  
}
