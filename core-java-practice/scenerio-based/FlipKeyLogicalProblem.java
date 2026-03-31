import java.util.Scanner;
public class FlipKeyLogicalProblem {
    public static String CleanseAndInvert(String input){
        if(input.length()<6 || input.contains(" ") || !input.matches("[a-zA-Z]+")){
            System.out.println("Invalid Input");
            return "";
        }
        input = input.toLowerCase();
        String s = "";
        for(int i=0;i<input.length();i++){
            int a = 0-input.charAt(i);
            if(a%2==0){
                continue;
            }
            s = s + input.charAt(i);
        }
        String rev = "";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        String out = "";
        for(int i=0;i<rev.length();i++){
            if(i%2==0){
                char c = rev.charAt(i);
                out += Character.toUpperCase(c); 
            }
            else{
                out += rev.charAt(i); 
            }
        }
     return out;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String s = CleanseAndInvert(input);
        System.out.println(s);
        sc.close();
    }
}
