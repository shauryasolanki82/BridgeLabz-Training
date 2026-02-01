package JUnit;

public class StringUtils {

	public String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		String s =sb.reverse().toString();
		return s;
	}

	public boolean isPalindrome(String str) {
		String r ="";
		for(int i=str.length()-1;i>=0;i--) {
			r += str.charAt(i);
		}
		return str.equals(r);
	}
	
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
