import java.util.Scanner;
import java.util.regex.*;
public class ExtractEmailAddresses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "[a-zA-Z0-9.+-_]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("enter the string");
        String s = sc.nextLine();
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println("Matched :"+matcher.group());
        }
        sc.close();
    }
}
