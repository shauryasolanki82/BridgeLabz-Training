package functional_interface;

public interface UnitConversionTool {
	double KM_TO_MILES = 0.621371;
    double KG_TO_LBS = 2.20462;

    static double kmToMiles(double km) {
        return km * KM_TO_MILES;
    }

    static double kgToLbs(double kg) {
        return kg * KG_TO_LBS;
    }
}
