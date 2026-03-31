
import java.util.Scanner;

public class RemoveCharacter {
	
	public static String remove(String text, char target) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) == target) {
				continue;
			}
			sb.append(text.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		char target = input.next().charAt(0);
		String result = remove(text, target);
		System.out.println(result);
		input.close();
	}

}
