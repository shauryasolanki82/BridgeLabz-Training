import java.util.Scanner;
public class FrequencyOfACharacter {
    
    public static void CalculateFrequency(String str, int[] freq) {
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                System.out.println((char) i + " occurs " + freq[i] + " times");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] freq = new int[256];
        String str = sc.nextLine();
        CalculateFrequency(str, freq);
        sc.close();
    }
}
