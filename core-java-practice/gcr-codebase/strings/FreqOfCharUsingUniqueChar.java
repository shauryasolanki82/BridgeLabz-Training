import java.util.Scanner;
public class FreqOfCharUsingUniqueChar {
    static void calculatefreq(String str, int[] freq) {
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        System.out.println("Character frequencies:");
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                System.out.println((char) i + " occurs " + freq[i] + " times");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int freq[] = new int[256];
        calculatefreq(str, freq);
        scanner.close();
    }
}
