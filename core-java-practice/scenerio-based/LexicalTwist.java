import java.util.Scanner;
public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first String: ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second String: ");
        String str2 = sc.nextLine();
        String rev = "";
        for(int i=str2.length()-1;i>=0;i--){
            rev += str2.charAt(i);
        }
        if(str1.equalsIgnoreCase(rev)){
            StringBuilder sb = new StringBuilder(str2.toLowerCase());

            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    sb.setCharAt(i, '@');
                }
            }

            System.out.println(sb.toString());
        }
        else{
            String ans = str1+str2;
            System.out.println(ans);
            ans = ans.toUpperCase();
            int consonant = 0, vowels = 0;
            for(int i=0;i<ans.length();i++){
                char ch = ans.charAt(i);
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    vowels++;
                }
                else{
                    consonant++;
                }
            }
            if(vowels>consonant){
                char cha = 'a';
                int c = 0;
                 for(int i=0;i<ans.length() && c!=2;i++){
                char ch = ans.charAt(i);
                if(ch!=cha){
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    cha = ch;
                    System.out.println(Character.toUpperCase(ch));
                    c++;
                }
            }
            }
            }
            else if(vowels<consonant){
                char cha = 'e';
                int c = 0;
                 for(int i=0;i<ans.length() && c!=2;i++){
                char ch = ans.charAt(i);
                if(ch!=cha){
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    cha = ch;
                    System.out.println(Character.toUpperCase(ch));
                    c++;
                }
            }
            }
            }
            else{
                System.out.println("Vowels and consonants are equals");
            }
        }
        sc.close();
    }
}
