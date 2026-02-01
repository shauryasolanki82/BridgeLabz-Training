import java.util.regex.*;
import java.util.Scanner;
public class ExtractDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        Matcher matcher =pattern.matcher(s);
        while (matcher.find()) {
            System.out.print(matcher.group()+", ");
        }
        sc.close();
    }
}
