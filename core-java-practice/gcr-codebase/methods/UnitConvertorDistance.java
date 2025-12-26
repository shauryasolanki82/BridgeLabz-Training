

public class UnitConvertorDistance {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        double kiloMeter = 10.0;
        double miles = 6.21371;
        double meters = 5.0;
        double feet = 16.4042;
        System.out.println(kiloMeter + " km to miles: " + convertKmToMiles(kiloMeter));
        System.out.println(miles + " miles to km: " + convertMilesToKm(miles));
        System.out.println(meters + " meters to feet: " + convertMetersToFeet(meters));
        System.out.println(feet + " feet to meters: " + convertFeetToMeters(feet));
    }
}