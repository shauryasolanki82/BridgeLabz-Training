package regex;

public class IPAddress {

	public static void main(String[] args) {
        System.out.println(isValidIPv4("192.168.1.1"));
        System.out.println(isValidIPv4("255.255.255.255"));
        System.out.println(isValidIPv4("256.1.1.1"));
        System.out.println(isValidIPv4(".1.1.1"));
        System.out.println(isValidIPv4("01.1.1.1"));
	}

	public static boolean isValidIPv4(String ip) {
	    String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"+"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	    return ip.matches(regex);
	}

}
