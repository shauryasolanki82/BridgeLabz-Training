import java.util.Scanner;

public class Main {
    public static void check(String input) throws InvalidFlightException {

    String[] str = input.split(":");

    int pcount = Integer.parseInt(str[2]);
    double d = Double.parseDouble(str[3]);

    FlightUtil fu = new FlightUtil();

    if (fu.validateFlightNumber(str[0]) &&
        fu.validateFlightName(str[1]) &&
        fu.validatePassengerCount(pcount, str[1])) {

        double ans = fu.calculateFuelToFillTank(str[1], d);
        System.out.println("Fuel required to fill the tank: " + ans + " liters");
        return;
    }

    throw new InvalidFlightException("Wrong detail");
}

    public static void main(String[] args) throws InvalidFlightException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter flight details");
        String input = sc.nextLine();
        check(input);
        sc.close();
}
}
