package regex;

import java.util.Scanner;
import java.util.regex.*;

public class ExtractLinks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter sentance that may contains links ");
		String s = sc.nextLine();
		String regex = "https?://\\S+|www\\.\\S+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		sc.close();
	}

}
