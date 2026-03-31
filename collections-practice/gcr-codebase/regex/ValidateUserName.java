import java.util.Scanner;
import java.util.regex.*;
public class ValidateUserName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "[a-zA-z]+[a-zA-Z0-9_]{5,15}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter username: ");
        String s = sc.nextLine(); 
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("valid username");
        }
        else{
            System.out.println("Invalid username");
        }
        sc.close();
    }
}
