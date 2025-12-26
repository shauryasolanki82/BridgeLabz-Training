
import java.util.*;

public class ToogleCaseCharcaters {
	
	public static String toggleCase(String text) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<text.length(); i++) {
			char curr = text.charAt(i);
			if(curr >= 'a' && curr <= 'z') {
				sb.append(text.toUpperCase().charAt(i));
			}else if(curr >= 'A' && curr <= 'Z') {
				sb.append(text.toLowerCase().charAt(i));
			}else if(curr == ' ') {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		String result = toggleCase(text);
		System.out.println(result);
		input.close();
	}

}
