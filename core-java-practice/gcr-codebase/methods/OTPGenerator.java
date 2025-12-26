
import java.util.*;

public class OTPGenerator {

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    
    public static boolean isUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; 
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otp = new int[10];
        for (int i = 0; i < otp.length; i++) {
            otp[i] = generateOTP();
        }
        System.out.println("Generated OTPs: " + Arrays.toString(otp));
        boolean unique = isUnique(otp);
        if (unique) {
            System.out.println("Success: All generated OTPs are unique.");
        } else {
            System.out.println("Duplicate found: The OTPs are NOT unique.");
        }
    }
}
