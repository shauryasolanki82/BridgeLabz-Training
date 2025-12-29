import java.util.Scanner;
public class PalindromeChecker {
  public static String input(String prompt){
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    sc.close();
    return sc.nextLine();
  }
  public static boolean isPalindromme(String str){
    String s = str.toLowerCase();
    for(int i=0;i<(s.length()/2)-1;i++){
      if(s.charAt(i)!=s.charAt(s.length()-1-i)){
        return  false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    String s = input("Enter a String: ");
    System.out.print("Is palindrome? ");
    System.out.println(isPalindromme(s));
  }
}
