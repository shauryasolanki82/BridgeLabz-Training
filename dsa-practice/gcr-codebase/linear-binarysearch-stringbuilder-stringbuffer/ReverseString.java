package searching;

public class ReverseString {

	public static void main(String[] args) {
		String input = "hello";
		String result = reverseString(input);
		System.out.println("Original String: " + input);
		System.out.println("Reversed String: " + result);
	}

	public static String reverseString(String str) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse();
		return sb.toString();
	}
}
