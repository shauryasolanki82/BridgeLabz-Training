import java.util.Scanner;
import java.util.regex.*;
public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your credit card number");
        String s = sc.nextLine();
        if(s.charAt(0)=='4'){
            String regex = "[4]{1}+[0-9]{15}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                System.out.println("valid visa credit card");
            }
            else{
                System.out.println("invalid credit card");
            }
        }
        else if(s.charAt(0)=='5'){
            String regex = "[5]{1}+[0-9]{15}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                System.out.println("valid MasterCard credit card");
            }
            else{
                System.out.println("invalid credit card");
            }
        }
        else{
            System.out.println("Invalid Credit card");
        }
        sc.close();
    }
}
