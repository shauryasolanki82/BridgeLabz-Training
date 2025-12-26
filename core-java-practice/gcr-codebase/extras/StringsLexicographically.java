
import java.util.Scanner;

public class StringsLexicographically {
	
	public static void lexicographically(String text1, String text2) {
		String shorter = text1;
		String longer = text2;
		if(text1.length() > text2.length()) {
			shorter = text2;
			longer = text1;
		}
		boolean flag = false;
		for(int i=0; i<shorter.length(); i++) {
			if(shorter.charAt(i)<longer.charAt(i)) {
				System.out.println("\""+shorter+"\" comes before \""+longer+"\" in lexicographical order");
				flag = true;
				break;
			}
			else if(shorter.charAt(i)>longer.charAt(i)){
				System.out.println("\""+longer+"\" comes before \""+shorter+"\" in lexicographical order");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("\""+shorter+"\" comes before \""+longer+"\" in lexicographical order");
		}
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text1 = input.next();
		String text2 = input.next();
		lexicographically(text1, text2);
		input.close();
	}

}
