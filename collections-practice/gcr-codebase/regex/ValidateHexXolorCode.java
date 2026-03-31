import java.util.Scanner;
import java.util.regex.*;
public class ValidateHexXolorCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^[#]{1}+[0-9a-zA-Z]{6}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter hex Color code");
        String s = sc.nextLine();
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("valid hex color code");
        }
        else{
            System.out.println("invalid hex color code");
        }
        sc.close();
    }
}
