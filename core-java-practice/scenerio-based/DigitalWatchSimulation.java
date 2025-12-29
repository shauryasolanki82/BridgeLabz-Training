import java.util.Scanner;

public class DigitalWatchSimulation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking starting time from user
        System.out.print("Enter starting hour (0-23): ");
        int startHour = sc.nextInt();

        System.out.print("Enter starting minute (0-59): ");
        int startMinute = sc.nextInt();

        // Outer loop for hours
        for (int hour = startHour; hour < 24; hour++) {

            // Inner loop for minutes
            for (int minute = (hour == startHour ? startMinute : 0);
                 minute < 60; minute++) {

                // Print time in HH:MM format
                System.out.printf("%02d:%02d\n", hour, minute);

                // Power cut at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("Power Cut! Watch stopped.");
                    return; 
                }
            }
        }
        sc.close();
    }
}
