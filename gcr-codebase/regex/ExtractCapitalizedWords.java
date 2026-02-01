import java.util.regex.*;
import java.util.Scanner;
public class ExtractCapitalizedWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "[A-Z]+[A-Za-z]{0,}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.print(matcher.group()+" ");
        }
        sc.close();
    }
}
