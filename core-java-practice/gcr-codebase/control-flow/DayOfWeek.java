public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            return;
        }
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // Adjust month and year for Jan and Feb
        if (m < 3) {
            m += 12;
            y--;
        }

        int k = y % 100;   // Year of the century
        int j = y / 100;   // Century

        // Zeller's Congruence (Gregorian)
        int h = (d + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        
        System.out.println(h);
    }
}
