package searching;

public class ConcatenateStrings{

    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", " ", "powerful", "."};
        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }

    public static String concatenateStrings(String[] strArray) {
        if (strArray == null || strArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String s : strArray) {
            if (s != null) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
